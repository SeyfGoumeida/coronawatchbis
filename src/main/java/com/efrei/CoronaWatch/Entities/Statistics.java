package com.efrei.CoronaWatch.Entities;

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
    private Boolean validate;

    public Boolean getValidate() {
        return validate;
    }

    public void setValidate(Boolean validate) {
        this.validate = validate;
    }

    public Statistics(){
        super();
    }
    public Statistics(long idStatistics, Integer nbDeaths, Integer nbSuspected, Integer nbConfirmed, Integer nbRecovred) {
        this.idStatistics = idStatistics;
        this.nbDeaths = nbDeaths;
        this.nbSuspected = nbSuspected;
        this.nbConfirmed = nbConfirmed;
        this.nbRecovred = nbRecovred;
        this.validate = false;
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
    @OneToOne
    public Region getStatisticsRegion() {
        return statisticsRegion;
    }

    public void setStatisticsRegion(Region statisticsRegion) {
        this.statisticsRegion = statisticsRegion;
    }
    @ManyToOne(cascade= CascadeType.ALL)
    public HealthAgent getStatisticsHealthAgent() {
        return statisticsHealthAgent;
    }

    public void setStatisticsHealthAgent(HealthAgent statisticsHealthAgent) {
        this.statisticsHealthAgent = statisticsHealthAgent;
    }
}

