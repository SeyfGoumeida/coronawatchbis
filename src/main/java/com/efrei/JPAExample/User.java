package com.efrei.JPAExample;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    protected long idUser;
    protected String userName;
    protected String firstName;
    protected String secondName;
    protected String email;
    protected String passWord;
    protected String userType;

    public User(){super();}

    public User(String userName, String firstName, String secondName, String email, String passWord, String userType) {
        this.idUser = idUser;
        this.userName = userName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.passWord = passWord;
        this.userType = userType;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
