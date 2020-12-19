package com.efrei.CoronaWatch.Repositories;

import com.efrei.CoronaWatch.Entities.*;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface StatisticsRepository extends CrudRepository<Statistics, Long> {

    Set<Statistics> findByStatisticsHealthAgent(HealthAgent healthAgent);
    Statistics findStatisticsByIdStatistics(long id);




}
