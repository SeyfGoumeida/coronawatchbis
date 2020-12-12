package com.efrei.CoronaWatch.Repositories;

import com.efrei.CoronaWatch.Entities.ContinentStatistics;
import com.efrei.CoronaWatch.Entities.HealthAgent;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ContinentStatisticsRepository extends CrudRepository<ContinentStatistics, Long> {

    Set<ContinentStatistics> findByStatisticsHealthAgent(HealthAgent healthAgent);

}
