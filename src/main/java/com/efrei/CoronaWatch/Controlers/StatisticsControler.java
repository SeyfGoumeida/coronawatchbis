package com.efrei.CoronaWatch.Controlers;

import com.efrei.CoronaWatch.Entities.RegionsStatistics;
import com.efrei.CoronaWatch.Entities.Statistics;
import com.efrei.CoronaWatch.Repositories.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class StatisticsControler {

        StatisticsRepository statisticsRepository;

        @Autowired
        public StatisticsControler(StatisticsRepository statisticsRepository) {
            super();
            this.statisticsRepository = statisticsRepository;
        }


        @GetMapping("/Statistics")
        public Iterable<Statistics> getStatistics(){
            return statisticsRepository.findAll();
        }
        @GetMapping("/Statistics/Validate")
        public Iterable<Statistics> getValidatesStatistics(){
            Iterable<Statistics> listOfStatistics = getStatistics();
            List<Statistics> listOfValidatesStatistics = new ArrayList<>();
            for(Statistics statistics :listOfStatistics ){
                if(statistics.getStatisticsValidate())
                {
                    listOfValidatesStatistics.add(statistics);
                }
            }
            return listOfValidatesStatistics;
        }
        @GetMapping("/Statistics/Invalidate")
        public Iterable<Statistics> getInvalidatesStatistics(){
            Iterable<Statistics> listOfStatistics = getStatistics();
            List<Statistics> listOfValidatesStatistics = new ArrayList<>();
            for(Statistics statistics :listOfStatistics ){
                if(!statistics.getStatisticsValidate())
                {
                    listOfValidatesStatistics.add(statistics);
                }
            }
            return listOfValidatesStatistics;
        }

        @PostMapping("/Statistics")
        @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
        public void addStatistics(@RequestBody RegionsStatistics regionsStatistics) throws Exception {
            statisticsRepository.save(regionsStatistics);

        }


}
