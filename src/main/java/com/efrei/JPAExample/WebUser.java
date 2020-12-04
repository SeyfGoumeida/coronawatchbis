package com.efrei.JPAExample;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity

public class WebUser extends User {

    private Set<Commentary> webUserCommentaries = new HashSet<Commentary>();

    @OneToMany(mappedBy="commentEditor", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    public Set<Commentary> getWebUserCommentaries() {
        return webUserCommentaries;
    }

    public void setWebUserCommentaries(Set<Commentary> webUserCommentaries) {
        this.webUserCommentaries = webUserCommentaries;
    }
}
