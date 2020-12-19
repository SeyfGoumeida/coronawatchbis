package com.efrei.CoronaWatch.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity

public class WebUser extends User {

    private Set<Commentary> webUserCommentaries = new HashSet<Commentary>();
    public WebUser(){super();};
    public WebUser(String userName, String firstName, String lastName, String email, String passWord, UserType userType)
    {
        super(userName,firstName,lastName,email,passWord,userType);
    }

    @OneToMany(mappedBy="commentEditor", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    public Set<Commentary> getWebUserCommentaries() {
        return webUserCommentaries;
    }

    public void setWebUserCommentaries(Set<Commentary> webUserCommentaries) {
        this.webUserCommentaries = webUserCommentaries;
    }
}
