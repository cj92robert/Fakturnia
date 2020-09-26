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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;
        if (name != null ? !name.equals(role.name) : role.name != null) return false;
        if (users != null ? !users.equals(role.users) : role.users != null) return false;
        return permissionUsers != null ? permissionUsers.equals(role.permissionUsers) : role.permissionUsers == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (users != null ? users.hashCode() : 0);
        result = 31 * result + (permissionUsers != null ? permissionUsers.hashCode() : 0);
        return result;
    }
}
