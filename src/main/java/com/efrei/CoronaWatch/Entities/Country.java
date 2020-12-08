package com.efrei.CoronaWatch.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Country {
    private long idCountry;
    private String countryName;
    private Continent countryContinent;
    private Set<Region> countryRegions = new HashSet<Region>();
    public Country() {
        super();
    }
    public Country( String countryName) {
        this.countryName = countryName;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(long idCountry) {
        this.idCountry = idCountry;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    @ManyToOne(cascade= CascadeType.ALL,optional = true, targetEntity=Continent.class)
    public Continent getCountryContinent() {
        return countryContinent;
    }

    public void setCountryContinent(Continent countryContinent) {
        this.countryContinent = countryContinent;
    }
    @OneToMany(mappedBy="regionCountry", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    public Set<Region> getCountryRegions() {
        return countryRegions;
    }

    public void setCountryRegions(Set<Region> countryRegions) {
        this.countryRegions = countryRegions;
    }
}
