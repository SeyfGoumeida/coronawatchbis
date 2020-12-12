package com.efrei.CoronaWatch.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class RegionsStatistics extends Statistics {

    private Region statisticsRegion;
    private Boolean statisticsValidate;



    public RegionsStatistics(){
        super();
    }
    public RegionsStatistics(Integer nbDeaths, Integer nbSuspected, Integer nbConfirmed, Integer nbRecovred) {
        super(nbDeaths,nbSuspected,nbConfirmed,nbRecovred);
        this.statisticsValidate = false;
    }

    @OneToOne( optional = true, orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JsonBackReference
    // @JsonBackReference to avoid Infinite Recursion with Jackson JSON and Hibernate JPA issue
    public Region getStatisticsRegion() {
        return statisticsRegion;
    }
    public void setStatisticsRegion(Region statisticsRegion) {
        this.statisticsRegion = statisticsRegion;
    }
}


