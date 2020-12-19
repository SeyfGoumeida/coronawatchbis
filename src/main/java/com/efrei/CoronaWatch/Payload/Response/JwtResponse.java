package com.efrei.CoronaWatch.Payload.Response;

import com.efrei.CoronaWatch.Entities.UserType;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private UserType usertype;
   // List<String> roles;
    /*,*/
    public JwtResponse(String accessToken, Long id, String username, String email,UserType usertype) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.usertype = usertype;
     //   this.roles = roles;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserType getusertype() {
        return usertype;
    }
}