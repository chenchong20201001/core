package com.pingan.bill.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(length = 25)
    private String name;
    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    private List<User> users;
    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
    private List<Authority> authoritys;
}
