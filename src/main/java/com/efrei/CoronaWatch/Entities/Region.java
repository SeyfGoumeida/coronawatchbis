package com.efrei.CoronaWatch.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Region {
    private long idRegion;
    private String regionName;
    private Country regionCountry;
    private RegionsStatistics regionRegionsStatistics;
    private Boolean regionRisk;

    public Region() {
        super();
    }
    public Region( String regionName) {
        this.regionName = regionName;
        this.regionRisk = false;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(long idRegion) {
        this.idRegion = idRegion;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @ManyToOne(cascade= CascadeType.ALL,optional = true, targetEntity=Country.class)
    public Country getRegionCountry() {
        return regionCountry;
    }

    public void setRegionCountry(Country regionCountry) {
        this.regionCountry = regionCountry;
    }

    @OneToOne(mappedBy="statisticsRegion", cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    // @JsonBackReference and @JsonManagedReference to avoid Infinite Recursion with Jackson JSON and Hibernate JPA issue
    public RegionsStatistics getRegionStatistics() {
        return regionRegionsStatistics;
    }

    public Boolean getRegionRisk() {
        return regionRisk;
    }

    public void setRegionRisk(Boolean regionRisk) {
        this.regionRisk = regionRisk;
    }

    public void setRegionStatistics(RegionsStatistics regionRegionsStatistics) {
        this.regionRegionsStatistics = regionRegionsStatistics;
    }
}
