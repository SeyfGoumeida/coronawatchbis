package com.efrei.CoronaWatch.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity

public class HealthAgent extends User {
    private Set<Statistics> healthAgentStatistics= new HashSet<>();

    public  HealthAgent(){super();}
    public HealthAgent(String userName, String firstName, String secondName, String email, String passWord, String userType){
        super(userName,firstName,secondName,email,passWord,userType);}

    @OneToMany(mappedBy="statisticsHealthAgent", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    public Set<Statistics> getHealthAgentStatistics() {
        return healthAgentStatistics;
    }

    public void setHealthAgentStatistics(Set<Statistics> healthAgentStatistics) {
        this.healthAgentStatistics = healthAgentStatistics;
    }
}
