package com.efrei.CoronaWatch.Entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="USERTABLE")
public class User {
    protected long idUser;
    protected String userName;
    protected String firstName;
    protected String secondName;
    protected String email;
    protected String passWord;
    protected UserType userType;

    public User(){super();}

    public User(String userName, String firstName, String secondName, String email, String passWord, UserType userType) {
        this.userName = userName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.passWord = passWord;
        this.userType = userType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public long getIdUser() {
        return idUser;
    }
    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    // Email unique
    @Column(unique=true)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // UserName unique
    @Column(unique=true)
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    // FirstName unique
    @Column(unique=true)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // SecondName unique
    @Column(unique=true)
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

    // to use the Enumiration USerType
    @Enumerated(EnumType.STRING)
    public UserType getUserType() {
        return userType;
    }
    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
