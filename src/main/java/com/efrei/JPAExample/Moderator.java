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

public class Moderator extends User{

    private Set<Article> moderatorArticles = new HashSet<Article>();

    @OneToMany(mappedBy="articleModerator", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    public Set<Article> getModeratorArticles() {
        return moderatorArticles;
    }

    public void setModeratorArticles(Set<Article> moderatorArticles) {
        this.moderatorArticles = moderatorArticles;
    }
}
