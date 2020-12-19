package com.efrei.CoronaWatch.Payload.Request;

import com.efrei.CoronaWatch.Entities.UserType;

public class SignupRequest {

    protected String userName;
    protected String firstName;
    protected String LastName;
    protected String email;
    protected String passWord;
    protected UserType userType;

    public SignupRequest(String userName, String firstName, String LastName, String email, String passWord, UserType userType) {
        this.userName = userName;
        this.firstName = firstName;
        this.LastName = LastName;
        this.email = email;
        this.passWord = passWord;
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
