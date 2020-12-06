package com.efrei.CoronaWatch;

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
    @OneToMany(mappedBy="statisticsHealthAgent", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    public Set<Statistics> getHealthAgentStatistics() {
        return healthAgentStatistics;
    }

    public void setHealthAgentStatistics(Set<Statistics> healthAgentStatistics) {
        this.healthAgentStatistics = healthAgentStatistics;
    }
}
