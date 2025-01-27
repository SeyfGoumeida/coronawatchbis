package com.efrei.CoronaWatch.Entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Statistics {

    private long idStatistics;
    private Integer nbDeaths;
    private Integer nbSuspected;
    private Integer nbConfirmed;
    private Integer nbRecovered;
    private HealthAgent statisticsHealthAgent;
    private Boolean statisticsValidate;
    private StatisticsTypes statisticsType;



    public Statistics(){
        super();
    }
    public Statistics(Integer nbDeaths, Integer nbSuspected, Integer nbConfirmed, Integer nbRecovered,StatisticsTypes statisticsType) {
        this.nbDeaths = nbDeaths;
        this.nbSuspected = nbSuspected;
        this.nbConfirmed = nbConfirmed;
        this.nbRecovered = nbRecovered;
        this.statisticsValidate = false;
        this.statisticsType = statisticsType;
        this.statisticsHealthAgent =null;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
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

    public Integer getNbRecovered() {
        return nbRecovered;
    }

    public void setNbRecovered(Integer nbRecovered) {
        this.nbRecovered = nbRecovered;
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

    public StatisticsTypes getStatisticsType() {
        return statisticsType;
    }

    public void setStatisticsType(StatisticsTypes statisticsType) {
        this.statisticsType = statisticsType;
    }
}
