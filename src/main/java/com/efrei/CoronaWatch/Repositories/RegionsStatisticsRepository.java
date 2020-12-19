package com.efrei.CoronaWatch.Repositories;

import com.efrei.CoronaWatch.Entities.RegionsStatistics;
import org.springframework.data.repository.CrudRepository;



    public interface RegionsStatisticsRepository extends CrudRepository<RegionsStatistics, Long> {

        RegionsStatistics findRegionsStatisticsByIdStatistics(long id);

    }

