package com.efrei.CoronaWatch.Controlers;

import com.efrei.CoronaWatch.Entities.RegionsStatistics;
import com.efrei.CoronaWatch.Entities.Statistics;
import com.efrei.CoronaWatch.Entities.StatisticsTypes;
import com.efrei.CoronaWatch.Repositories.RegionsStatisticsRepository;
import com.efrei.CoronaWatch.Repositories.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class StatisticsControler {

        StatisticsRepository statisticsRepository;
        RegionsStatisticsRepository regionsStatisticsRepository;
        @Autowired
        public StatisticsControler(StatisticsRepository statisticsRepository,RegionsStatisticsRepository regionsStatisticsRepository) {
            super();
            this.statisticsRepository = statisticsRepository;
            this.regionsStatisticsRepository = regionsStatisticsRepository;

        }


        @GetMapping("/Statistics")
        public Iterable<Statistics> getStatistics(){ return statisticsRepository.findAll(); }
        @GetMapping("/Statistics/RegionsStatistics")
        public Iterable<RegionsStatistics> getStatisticsRegionsStatistics(){ return regionsStatisticsRepository.findAll(); }

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

    @GetMapping("/Statistics/Regions")
    public Iterable<RegionsStatistics> getStatisticsRegions(){
        Iterable<RegionsStatistics> listOfStatistics = getStatisticsRegionsStatistics();
        List<RegionsStatistics> listOfValidatesStatistics = new ArrayList<>();
        for(RegionsStatistics statistics :listOfStatistics ){
            if( statistics.getStatisticsType()==StatisticsTypes.Region)
            {
                listOfValidatesStatistics.add(statistics);
            }
        }
        return listOfValidatesStatistics;
    }
    @GetMapping("/Statistics/Regions/Validate")
    public Iterable<RegionsStatistics> getValidatesStatisticsRegions(){
        Iterable<RegionsStatistics> listOfStatistics = getStatisticsRegionsStatistics();
        List<RegionsStatistics> listOfValidatesStatistics = new ArrayList<>();
        for(RegionsStatistics statistics :listOfStatistics ){
            if(statistics.getStatisticsValidate() && statistics.getStatisticsType()==StatisticsTypes.Region)
            {
                listOfValidatesStatistics.add(statistics);
            }
        }
        return listOfValidatesStatistics;
    }
        @GetMapping("/Statistics/Regions/Invalidate")
        public Iterable<RegionsStatistics> getInvalidatesStatisticsRegions(){
            Iterable<RegionsStatistics> listOfStatistics = getStatisticsRegionsStatistics();
            List<RegionsStatistics> listOfValidatesStatistics = new ArrayList<>();
            for(RegionsStatistics statistics :listOfStatistics ){
                if(!statistics.getStatisticsValidate() && statistics.getStatisticsType()==StatisticsTypes.Region)
                {
                    listOfValidatesStatistics.add(statistics);
                }
            }
            return listOfValidatesStatistics;
        }

        @PostMapping("/Statistics/Region")
        @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
        public void addStatistics(@RequestBody RegionsStatistics statistics) throws Exception {
            regionsStatisticsRepository.save(statistics);

        }

    @PutMapping("/Statistics/Region/Validate")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void validateStatistics(@RequestParam(name = "id") long id,@RequestParam(name = "validate")boolean validate)throws Exception  {
        RegionsStatistics regionStat = regionsStatisticsRepository.findRegionsStatisticsByIdStatistics(id);
        regionStat.setStatisticsValidate(validate);
        regionsStatisticsRepository.save(regionStat);
    }


}
