package com.efrei.CoronaWatch.Repositories;

import com.efrei.CoronaWatch.Entities.Article;
import com.efrei.CoronaWatch.Entities.HealthAgent;
import com.efrei.CoronaWatch.Entities.Region;
import com.efrei.CoronaWatch.Entities.Statistics;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface StatisticsRepository extends CrudRepository<Statistics, Long> {

    Set<Statistics> findByStatisticsRegion(Region region);
    Set<Statistics> findByStatisticsHealthAgent(HealthAgent healthAgent);



}
