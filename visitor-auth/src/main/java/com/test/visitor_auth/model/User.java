package com.test.visitor_auth.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.extern.slf4j.Slf4j;


@Entity(name = "user")
@Slf4j
public class User implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private boolean enabled;
    private boolean locked;
    @Transient //这个注言会然它下面的成员在生成表时忽略，不生成对应字段
    private List<Role> roles;
    @Transient
    private static final long serialVersionUID = 1L;
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        log.info("username: " + username);
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
            log.info("    role: " + role.getName());
        }
        return authorities;
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    @Override
    public boolean isEnabled() {
        return enabled;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public boolean getEnabled() {
        return enabled;
    }
    
    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    
    public boolean getLocked() {
        return locked;
    }
    
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
    public List<Role> getRoles() {
        return roles;
    }
    
}
