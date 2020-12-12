package com.efrei.CoronaWatch.Repositories;

import com.efrei.CoronaWatch.Entities.CountryStatistics;
import com.efrei.CoronaWatch.Entities.HealthAgent;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CountryStatisticsCountry extends CrudRepository<CountryStatistics, Long> {

    Set<CountryStatistics> findByStatisticsHealthAgent(HealthAgent healthAgent);


}
