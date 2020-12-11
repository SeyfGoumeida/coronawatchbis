package com.efrei.CoronaWatch.Entities;

import javax.persistence.Entity;

@Entity
public class SuperAdmin extends User {

    public  SuperAdmin(){super();}
    public SuperAdmin(String userName, String firstName, String lastName, String email, String passWord, UserType userType){
        super(userName,firstName,lastName,email,passWord,userType);}
}
