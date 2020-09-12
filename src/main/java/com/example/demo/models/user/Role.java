package com.example.demo.models.user;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role implements GrantedAuthority{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany( mappedBy = "roles")
    private Set<User> users;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<PermissionUser> permissionUsers;


    public Role() {
    }

    public Role(String name, Set<PermissionUser> permissionUsers) {
        this.name = name;
        this.permissionUsers = permissionUsers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role(String name, Set<User> users, Set<PermissionUser> permissionUsers) {
        this.name = name;
        this.users = users;
        this.permissionUsers = permissionUsers;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<PermissionUser> getPermissionUsers() {
        return permissionUsers;
    }

    public void setPermissionUsers(Set<PermissionUser> permissionUsers) {
        this.permissionUsers = permissionUsers;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
