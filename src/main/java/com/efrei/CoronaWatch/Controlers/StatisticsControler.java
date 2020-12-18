package com.efrei.CoronaWatch.Controlers;

import com.efrei.CoronaWatch.Entities.Statistics;
import com.efrei.CoronaWatch.Entities.StatisticsTypes;
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
        public Iterable<Statistics> getStatistics(){ return statisticsRepository.findAll(); }

        @GetMapping("/Statistics/World")
        public Statistics getStatisticsWord(){

            Iterable<Statistics> listOfStatistics = getStatistics();
            Statistics WorldsStatistics = new Statistics(0,0,0,0,StatisticsTypes.Word);
            for(Statistics statistics :listOfStatistics ){
                if(statistics.getStatisticsValidate() && statistics.getStatisticsType().equals(StatisticsTypes.Country))
                {
                    WorldsStatistics.setNbConfirmed(WorldsStatistics.getNbConfirmed()+statistics.getNbConfirmed());
                    WorldsStatistics.setNbDeaths(WorldsStatistics.getNbDeaths()+statistics.getNbDeaths());
                    WorldsStatistics.setNbRecovered(WorldsStatistics.getNbRecovered()+statistics.getNbRecovered());
                    WorldsStatistics.setNbSuspected(WorldsStatistics.getNbSuspected()+statistics.getNbSuspected());
                }
            }
            return WorldsStatistics;
        }
        @GetMapping("/Statistics/Country")
        public Iterable<Statistics> getStatisticsContinents(){

            Iterable<Statistics> listOfStatistics = getStatistics();
            List<Statistics> listOfValidatedStatistics = new ArrayList<>();
            for(Statistics statistics :listOfStatistics ){
                if(statistics.getStatisticsValidate() && statistics.getStatisticsType().equals(StatisticsTypes.Country))
                {
                    listOfValidatedStatistics.add(statistics);
                }
            }
            return listOfValidatedStatistics;

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

        @PostMapping("/Statistics/Region")
        @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
        public void addStatistics(@RequestBody Statistics statistics) throws Exception {
            statisticsRepository.save(statistics);

        }


}
