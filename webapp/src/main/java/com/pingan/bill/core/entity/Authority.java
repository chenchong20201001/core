package com.pingan.bill.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="AUTHORITY")
@Data
public class Authority {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String url;
    private int pid;
    private String description;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="ROLE_AUTH",
            joinColumns = {@JoinColumn(name="auth_id",referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name="role_id",referencedColumnName = "ID")}
    )
    private List<Role> roles;

}
