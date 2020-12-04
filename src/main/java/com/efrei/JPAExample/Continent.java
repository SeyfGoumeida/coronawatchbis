package com.efrei.JPAExample;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Continent {
    private long idContinent;
    private String nameContinent;
    private Set<Country> countries = new HashSet<Country>();

    public Continent(){super();}

    public Continent(long idContinent, String nameContinent) {
        this.idContinent = idContinent;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getIdContinent() {
        return idContinent;
    }

    public void setIdContinent(long idContinent) {
        this.idContinent = idContinent;
    }

    public String getNameContinent() {
        return nameContinent;
    }

    public void setNameContinent(String nameContinent) {
        this.nameContinent = nameContinent;
    }
}
