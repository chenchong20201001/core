package com.pingan.bill.core.service;

import com.pingan.bill.core.dao.AuthDao;
import com.pingan.bill.core.entity.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class MyInvocationSecurityMetaDataSourceService implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private AuthDao authDao;
    private HashMap<String,Collection<ConfigAttribute>> map;
    public void loadResourceDefine(){
        map=new HashMap<>();
        Collection<ConfigAttribute> array;
        ConfigAttribute cfg;
        List<Authority> permissions=authDao.findAll();
        for(Authority permission:permissions){
            array=new ArrayList<>();
            cfg=new SecurityConfig(permission.getName());
            array.add(cfg);
            map.put(permission.getUrl(),array);
        }
    }
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if(map==null) loadResourceDefine();
        HttpServletRequest request=((FilterInvocation)object).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        for(Iterator<String> iter = map.keySet().iterator(); iter.hasNext();){
            resUrl=iter.next();
            if(resUrl.indexOf("?")>-1){
                resUrl=resUrl.substring(0,resUrl.indexOf("?"));
            }
            matcher = new AntPathRequestMatcher(resUrl);
            if(matcher.matches(request)){
                return map.get(resUrl);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
