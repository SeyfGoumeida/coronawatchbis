package com.efrei.CoronaWatch.Security.Services;

import com.efrei.CoronaWatch.Entities.User;
import com.efrei.CoronaWatch.Entities.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    String ROLE_PREFIX = "ROLE_";

    private Long id;

    private String username;

    private String email;

    @JsonIgnore
    private String password;

    private UserType usertype;

    public UserDetailsImpl(Long id, String username, String email, String password,
                          UserType usertype) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.usertype = usertype;
    }

    public static UserDetailsImpl build(User user) {
        return new UserDetailsImpl(
                user.getIdUser(),
                user.getUserName(),
                user.getEmail(),
                user.getPassWord(),
                user.getUserType());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

        list.add(new SimpleGrantedAuthority(ROLE_PREFIX + usertype));

        return list;
    }

    public UserType getusertype() {
        return usertype;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}