package com.efrei.CoronaWatch.Entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CountryStatistics extends Statistics {

    private Country statisticsCountry;
    private Boolean statisticsValidate;
    private Set<RegionsStatistics> regionsStatistics = new HashSet<RegionsStatistics>();
    private ContinentStatistics countryStatisticsContinentStatistics;


    public CountryStatistics() {
        super();
    }

    public CountryStatistics(Integer nbDeaths, Integer nbSuspected, Integer nbConfirmed, Integer nbRecovred,StatisticsTypes statisticsTypes) {
        super(nbDeaths, nbSuspected, nbConfirmed, nbRecovred,statisticsTypes);
        this.statisticsValidate = false;
    }


    @OneToOne(orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonBackReference
    // @JsonBackReference to avoid Infinite Recursion with Jackson JSON and Hibernate JPA issue
    public Country getStatisticsCountry() {
        return statisticsCountry;
    }
    public void setStatisticsCountry(Country statisticsCountry) {
        this.statisticsCountry = statisticsCountry;
    }

    //Country Statistics

    @OneToMany(mappedBy="regionsStatisticsCountryStatistics", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    public Set<RegionsStatistics> getRegionsStatistics() {
        return regionsStatistics;
    }

    public void setRegionsStatistics(Set<RegionsStatistics> regionsStatistics) {
        this.regionsStatistics = regionsStatistics;
    }
    // Continent Statistics
    @ManyToOne(optional = true, targetEntity=ContinentStatistics.class)
    public ContinentStatistics getCountryStatisticsContinentStatistics() {
        return countryStatisticsContinentStatistics;
    }

    public void setCountryStatisticsContinentStatistics(ContinentStatistics countryStatisticsContinentStatistics) {
        this.countryStatisticsContinentStatistics = countryStatisticsContinentStatistics;
    }

}

