package com.efrei.CoronaWatch.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Statistics {
    private long idStatistics;
    private Integer nbDeaths;
    private Integer nbSuspected;
    private Integer nbConfirmed;
    private Integer nbRecovred;
    private Region statisticsRegion;
    private HealthAgent statisticsHealthAgent;
    private Boolean statisticsValidate;



    public Statistics(){
        super();
    }
    public Statistics(Integer nbDeaths, Integer nbSuspected, Integer nbConfirmed, Integer nbRecovred) {
        this.nbDeaths = nbDeaths;
        this.nbSuspected = nbSuspected;
        this.nbConfirmed = nbConfirmed;
        this.nbRecovred = nbRecovred;
        this.statisticsValidate = false;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdStatistics() {
        return idStatistics;
    }

    public void setIdStatistics(long idStatistics) {
        this.idStatistics = idStatistics;
    }

    public Integer getNbDeaths() {
        return nbDeaths;
    }

    public void setNbDeaths(Integer nbDeaths) {
        this.nbDeaths = nbDeaths;
    }

    public Integer getNbSuspected() {
        return nbSuspected;
    }

    public void setNbSuspected(Integer nbSuspected) {
        this.nbSuspected = nbSuspected;
    }

    public Integer getNbConfirmed() {
        return nbConfirmed;
    }

    public void setNbConfirmed(Integer nbConfirmed) {
        this.nbConfirmed = nbConfirmed;
    }

    public Integer getNbRecovred() {
        return nbRecovred;
    }

    public void setNbRecovred(Integer nbRecovred) {
        this.nbRecovred = nbRecovred;
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
    @ManyToOne(optional = true, targetEntity=HealthAgent.class)
    public HealthAgent getStatisticsHealthAgent() {
        return statisticsHealthAgent;
    }

    public void setStatisticsHealthAgent(HealthAgent statisticsHealthAgent) {
        this.statisticsHealthAgent = statisticsHealthAgent;
    }
    public Boolean getStatisticsValidate() {
        return statisticsValidate;
    }

    public void setStatisticsValidate(Boolean statisticsValidate) {
        this.statisticsValidate = statisticsValidate;
    }
}

