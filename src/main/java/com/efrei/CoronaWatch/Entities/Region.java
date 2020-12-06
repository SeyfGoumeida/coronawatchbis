package com.efrei.CoronaWatch.Entities;

import javax.persistence.*;

@Entity
public class Region {
    private long idRegion;
    private String regionName;
    private Country regionCountry;
    private Statistics regionStatistics;

    public Region() {
        super();
    }
    public Region(long idRegion, String regionName) {
        this.idRegion = idRegion;
        this.regionName = regionName;
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

    @ManyToOne(cascade=CascadeType.ALL)
    public Country getRegionCountry() {
        return regionCountry;
    }

    public void setRegionCountry(Country regionCountry) {
        this.regionCountry = regionCountry;
    }

   @OneToOne(mappedBy="statisticsRegion")
    public Statistics getRegionStatistics() {
        return regionStatistics;
    }

    public void setRegionStatistics(Statistics regionStatistics) {
        this.regionStatistics = regionStatistics;
    }
}
