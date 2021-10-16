package com.pingan.bill.core.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="USER")
@Data
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name="USERNAME",length = 50,unique = true )
    private String username;
    @Column(name="PASSWORD",length=100)
    private String password;
    @Column(name="FIRSTNAME",length = 50)
    private String firstname;
    @Column(name = "LASTNAME",length = 50)
    private String lastname;
    @Column(name="EMAIL",length = 50)
    private Boolean enabled;
    @Column(name="LAST_PASSWORD_RESET_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPasswordResetDate;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="USER_ROLE",
            joinColumns = {@JoinColumn(name = "USER_ID",referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name="ROLE_ID",referencedColumnName = "ID")}

    )
    private List<Role> roles;

    public static void main(String[] args) {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths=new ArrayList<>();
        List<Role> roles = this.getRoles();
        for(Role role:roles){
            for(Authority aurh:role.getAuthoritys()){
                auths.add(new SimpleGrantedAuthority(aurh.getName()));
            }
        }
        return  auths;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
