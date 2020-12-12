package com.efrei.CoronaWatch.Entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class ContinentStatistics extends Statistics {

    private Continent statisticsContinent;
    private Boolean statisticsValidate;



    public ContinentStatistics(){
        super();
    }
    public ContinentStatistics(Integer nbDeaths, Integer nbSuspected, Integer nbConfirmed, Integer nbRecovred) {
        super(nbDeaths,nbSuspected,nbConfirmed,nbRecovred);
        this.statisticsValidate = false;
    }

    @OneToOne( optional = true, orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JsonBackReference
    // @JsonBackReference to avoid Infinite Recursion with Jackson JSON and Hibernate JPA issue
    public Continent getStatisticsContinent() {
        return statisticsContinent;
    }
    public void setStatisticsContinent(Continent statisticsContinent) {
        this.statisticsContinent = statisticsContinent;
    }
}

