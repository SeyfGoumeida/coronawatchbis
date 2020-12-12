package com.efrei.CoronaWatch.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class RegionsStatistics extends Statistics {

    private Region statisticsRegion;
    private Boolean statisticsValidate;
    private CountryStatistics regionsStatisticsCountryStatistics;



    public RegionsStatistics(){
        super();
    }
    public RegionsStatistics(Integer nbDeaths, Integer nbSuspected, Integer nbConfirmed, Integer nbRecovred) {
        super(nbDeaths,nbSuspected,nbConfirmed,nbRecovred);
        this.statisticsValidate = false;
    }

    @OneToOne( optional = true, orphanRemoval = true, fetch = FetchType.LAZY )
    @JsonBackReference
    // @JsonBackReference to avoid Infinite Recursion with Jackson JSON and Hibernate JPA issue
    public Region getStatisticsRegion() {
        return statisticsRegion;
    }
    public void setStatisticsRegion(Region statisticsRegion) {
        this.statisticsRegion = statisticsRegion;
    }

    @ManyToOne(optional = true, targetEntity=CountryStatistics.class)
    public CountryStatistics getRegionsStatisticsCountryStatistics() {
        return regionsStatisticsCountryStatistics;
    }

    public void setRegionsStatisticsCountryStatistics(CountryStatistics regionsStatisticsCountryStatistics) {
        this.regionsStatisticsCountryStatistics = regionsStatisticsCountryStatistics;
    }

    //override

    public void setNbDeaths(Integer nbDeaths) {

        super.setNbDeaths(nbDeaths);
        regionsStatisticsCountryStatistics.setNbDeaths(regionsStatisticsCountryStatistics.getNbDeaths()+nbDeaths);
    }

    public void setNbSuspected(Integer nbSuspected) {

        super.setNbSuspected(nbSuspected);
        regionsStatisticsCountryStatistics.setNbSuspected(regionsStatisticsCountryStatistics.getNbSuspected()+nbSuspected);
    }

    public void setNbConfirmed(Integer nbConfirmed) {

        super.setNbConfirmed(nbConfirmed);
        regionsStatisticsCountryStatistics.setNbConfirmed(regionsStatisticsCountryStatistics.getNbConfirmed()+nbConfirmed);

    }


    public void setNbRecovred(Integer nbRecovred) {

        super.setNbConfirmed(nbRecovred);
        regionsStatisticsCountryStatistics.setNbRecovred(regionsStatisticsCountryStatistics.getNbRecovred()+nbRecovred);

    }

}


