package com.efrei.CoronaWatch.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity

public class HealthAgent extends User {

    private Set<RegionsStatistics> healthAgentStatistics= new HashSet<>();

    public  HealthAgent(){super();}
    public HealthAgent(String userName, String firstName, String lastName, String email, String passWord, UserType userType){
        super(userName,firstName,lastName,email,passWord,userType);}

    @OneToMany(mappedBy="statisticsHealthAgent", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    public Set<RegionsStatistics> getHealthAgentStatistics() {
        return healthAgentStatistics;
    }

    public void setHealthAgentStatistics(Set<RegionsStatistics> healthAgentStatistics) {
        this.healthAgentStatistics = healthAgentStatistics;
    }
}
