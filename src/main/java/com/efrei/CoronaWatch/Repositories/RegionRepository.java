package com.efrei.CoronaWatch.Repositories;

import com.efrei.CoronaWatch.Entities.Country;
import com.efrei.CoronaWatch.Entities.Region;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;


public interface RegionRepository extends CrudRepository<Region, Long> {
    Set<Region> findRegionByRegionCountry(Country country);
    Region findRegionByRegionName(String regionname);
    Region findRegionByIdRegion(long id);


}
