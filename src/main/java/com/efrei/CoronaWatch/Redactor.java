package com.efrei.CoronaWatch;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Redactor extends User {

    private Set<Article> redactorCommentaries = new HashSet<Article>();
    public  Redactor(){super();}
    public Redactor(String userName, String firstName, String secondName, String email, String passWord, String userType){
        super(userName,firstName,secondName,email,passWord,userType);}
    @OneToMany(mappedBy="articleRedactor", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore

    public Set<Article> getRedactorCommentaries() {
        return redactorCommentaries;
    }

    public void setRedactorCommentaries(Set<Article> redactorCommentaries) {
        this.redactorCommentaries = redactorCommentaries;
    }
}
