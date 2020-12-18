package com.efrei.CoronaWatch.Controlers;

import com.efrei.CoronaWatch.Entities.Country;
import com.efrei.CoronaWatch.Entities.Region;
import com.efrei.CoronaWatch.Entities.Statistics;
import com.efrei.CoronaWatch.Repositories.CountryRepository;
import com.efrei.CoronaWatch.Repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class RegionsControler {
    RegionRepository regionRepository;
    CountryRepository countryRepository;
    @Autowired
    public RegionsControler(RegionRepository regionRepository,CountryRepository countryRepository) {
        super();
        this.regionRepository = regionRepository;
        this.countryRepository = countryRepository;

    }
    @GetMapping("/Regions/Countries")
    public Iterable<Country> getCountries(){
        return countryRepository.findAll();
    }
    @GetMapping("/Regions/CountryByName")
    public Country getCountryByName(@RequestParam(name = "countryName") String countryName){
        return countryRepository.findCountryByCountryName(countryName);
    }
    @GetMapping("/Regions/CountryById")
    public Country getCountryById(@RequestParam(name = "idCountry") long idCountry){
        return countryRepository.findCountryByIdCountry(idCountry);
    }

    @GetMapping("/Regions/CountryRegionsByName")
    public Iterable<Region> getCountryByNameRegions(@RequestParam(name = "countryName") String countryName){
        Country c = getCountryByName(countryName);
        return regionRepository.findRegionByRegionCountry(c);
    }

    @GetMapping("/Regions/CountryRegionsById")
    public Iterable<Region> getCountryByIdRegions(@RequestParam(name = "idCountry") long id){
        Country c = getCountryById(id);
        return regionRepository.findRegionByRegionCountry(c);
    }
    @GetMapping("/Regions/RegionByName")
    public Region getRegionByName(@RequestParam(name = "regionName") String regionName){
        return regionRepository.findRegionByRegionName(regionName);
    }
    @GetMapping("/Regions/RegionById")
    public Region getRegionById(@RequestParam(name = "id") long id){
        return regionRepository.findRegionByIdRegion(id);
    }
    //----------------POST----------------------
    @PostMapping("/Regions/Statistics")
    public void addArticle(@RequestParam(name = "id") long id, @RequestBody Statistics stat) throws Exception {
        Region myRegion = getRegionById(id);
        Country myCountry = myRegion.getRegionCountry();
        Integer d;
        Integer s;
        Integer r;
        Integer c;
        d =  myCountry.getCountryStatistics().getNbDeaths() + stat.getNbDeaths() - myRegion.getRegionStatistics().getNbDeaths();
        s =  myCountry.getCountryStatistics().getNbSuspected() + stat.getNbSuspected()- myRegion.getRegionStatistics().getNbSuspected();
        r =  myCountry.getCountryStatistics().getNbRecovered() + stat.getNbRecovered()- myRegion.getRegionStatistics().getNbRecovered();
        c =  myCountry.getCountryStatistics().getNbConfirmed() + stat.getNbConfirmed()- myRegion.getRegionStatistics().getNbConfirmed();

        myRegion.getRegionStatistics().setNbRecovered(stat.getNbRecovered());
        myRegion.getRegionStatistics().setNbConfirmed(stat.getNbConfirmed());
        myRegion.getRegionStatistics().setNbDeaths(stat.getNbDeaths());
        myRegion.getRegionStatistics().setNbSuspected(stat.getNbSuspected());

        regionRepository.save(myRegion);

        myCountry.getCountryStatistics().setNbDeaths(d);
        myCountry.getCountryStatistics().setNbSuspected(s);
        myCountry.getCountryStatistics().setNbRecovered(r);
        myCountry.getCountryStatistics().setNbConfirmed(c);
        countryRepository.save(myCountry);

    }


}
