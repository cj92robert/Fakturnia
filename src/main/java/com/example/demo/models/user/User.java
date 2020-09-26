package com.example.demo.models.user;


import com.example.demo.models.Customer;
import com.example.demo.models.Invoice;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private Date createdAt;
    @ManyToMany(cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name="user_role",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")
    )
    private Set<Role> roles;

    @OneToMany
    private List<Customer> customerList;

    @OneToMany(mappedBy = "user")
    private List<Invoice> invoiceList;




    public User() {
    }

    @PrePersist
    void createdAt() {
        this.createdAt= new Date(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
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

    public void setUsername(String username) {
        this.username = username;
    }

    @Override

    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities=getRoles().stream()
                .flatMap(role->role.getPermissionUsers().stream())
                .collect(Collectors.toSet());
        authorities.addAll(getRoles());

        return authorities;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public static User from(UserRegistrationDto userRegistrationDto){
        var user= new User();
        user.setUsername(userRegistrationDto.getNickname());
        user.setPassword(userRegistrationDto.getPassword());
        user.setEmail(userRegistrationDto.getEmail());
        return user;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (createdAt != null ? !createdAt.equals(user.createdAt) : user.createdAt != null) return false;
        if (roles != null ? !roles.equals(user.roles) : user.roles != null) return false;
        if (customerList != null ? !customerList.equals(user.customerList) : user.customerList != null) return false;
        return invoiceList != null ? invoiceList.equals(user.invoiceList) : user.invoiceList == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        result = 31 * result + (customerList != null ? customerList.hashCode() : 0);
        result = 31 * result + (invoiceList != null ? invoiceList.hashCode() : 0);
        return result;
    }
}
