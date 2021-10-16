package com.pingan.bill.jpa_data;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.management.*;
import java.lang.management.ManagementFactory;

@Component
public class Hello implements  HelloMBean{
    private String name;
    private String age;
   @PostConstruct
    public void init() throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
       MBeanServer server= ManagementFactory.getPlatformMBeanServer();
       ObjectName helloName=new ObjectName("jmxBean:name=hello");
       server.registerMBean(new Hello(),helloName);
 }
    @Override
    public String getName() {
        System.out.println("get name:"+name);
        return this.name;
    }

    @Override
    public void setName(String name) {
        System.out.println("set name:"+name);
        this.name=name;
    }

    @Override
    public String getAge() {
        System.out.println("get age:"+age);
        return this.age;
    }

    @Override
    public void setAge(String age) {
        System.out.println("set age:"+age);
        this.age=age;
    }

    @Override
    public void helloWorld() {
        System.out.println("helloWorld!");
    }

    @Override
    public void hellWorld(String str) {
        System.out.println("helloWorld:"+str);
    }

    @Override
    public void getTelephone() {
        System.out.println("get Telephone");
    }
}
