package com.efrei.CoronaWatch.Repositories;

import com.efrei.CoronaWatch.Entities.Continent;
import com.efrei.CoronaWatch.Entities.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;


public interface CountryRepository extends CrudRepository<Country, Long> {
    Set<Country> findCountryByCountryContinent(Continent continent);
    Country findCountryByCountryName(String countryName);
    Country findCountryByIdCountry(long idCountry);


}