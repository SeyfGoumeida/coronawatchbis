package com.efrei.CoronaWatch.Entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ContinentStatistics extends Statistics {

    private Continent statisticsContinent;
    private Boolean statisticsValidate;
    private Set<CountryStatistics> countriesStatistics = new HashSet<CountryStatistics>();



    public ContinentStatistics(){
        super();
    }
    public ContinentStatistics(Integer nbDeaths, Integer nbSuspected, Integer nbConfirmed, Integer nbRecovred) {
        super(nbDeaths,nbSuspected,nbConfirmed,nbRecovred);
        this.statisticsValidate = false;
    }

    @OneToOne( optional = true, orphanRemoval = true, fetch = FetchType.LAZY )
    @JsonBackReference
    // @JsonBackReference to avoid Infinite Recursion with Jackson JSON and Hibernate JPA issue
    public Continent getStatisticsContinent() {
        return statisticsContinent;
    }
    public void setStatisticsContinent(Continent statisticsContinent) {
        this.statisticsContinent = statisticsContinent;
    }

    //Continent Statistics

    @OneToMany(mappedBy="countryStatisticsContinentStatistics", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    public Set<CountryStatistics> getCountriesStatistics() {
        return countriesStatistics;
    }

    public void setCountriesStatistics(Set<CountryStatistics> countriesStatistics) {
        this.countriesStatistics = countriesStatistics;
    }
}

