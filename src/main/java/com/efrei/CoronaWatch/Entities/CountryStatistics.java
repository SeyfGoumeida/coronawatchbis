package com.efrei.CoronaWatch.Entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
public class CountryStatistics extends Statistics {

    private Country statisticsCountry;
    private Boolean statisticsValidate;


    public CountryStatistics() {
        super();
    }

    public CountryStatistics(Integer nbDeaths, Integer nbSuspected, Integer nbConfirmed, Integer nbRecovred) {
        super(nbDeaths, nbSuspected, nbConfirmed, nbRecovred);
        this.statisticsValidate = false;
    }


    @OneToOne(orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    // @JsonBackReference to avoid Infinite Recursion with Jackson JSON and Hibernate JPA issue
    public Country getStatisticsCountry() {
        return statisticsCountry;
    }
    public void setStatisticsCountry(Country statisticsCountry) {
        this.statisticsCountry = statisticsCountry;
    }
}

