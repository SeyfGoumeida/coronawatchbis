package com.efrei.CoronaWatch.Entities;

import javax.persistence.Entity;

@Entity
public class SuperAdmin extends User {
    public  SuperAdmin(){super();}
    public SuperAdmin(String userName, String firstName, String secondName, String email, String passWord, String userType){
        super(userName,firstName,secondName,email,passWord,userType);}
}
