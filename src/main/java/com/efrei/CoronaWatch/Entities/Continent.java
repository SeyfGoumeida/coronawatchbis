package com.efrei.CoronaWatch.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Continent {
    private long idContinent;
    private Continents nameContinent;
    private Set<Country> countries = new HashSet<Country>();

    public Continent(){super();}

    public Continent( Continents nameContinent) {
        this.nameContinent = nameContinent;
    }
    @OneToMany(mappedBy="countryContinent", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdContinent() {
        return idContinent;
    }

    public void setIdContinent(long idContinent) {
        this.idContinent = idContinent;
    }
    // to use the Enumiration USerType
    @Enumerated(EnumType.STRING)
    public Continents getNameContinent() {
        return nameContinent;
    }

    public void setNameContinent(Continents nameContinent) {
        this.nameContinent = nameContinent;
    }
}
