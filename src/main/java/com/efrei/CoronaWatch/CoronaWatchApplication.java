package com.efrei.CoronaWatch;

import com.efrei.CoronaWatch.Entities.*;
import com.efrei.CoronaWatch.Repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class CoronaWatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronaWatchApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ArticleRepository articlerepository ,
								  UserRepository userrepository ,
								  StatisticsRepository statisticsRepository,
								  RegionRepository regionrepository ,
								  ContinentRepository continentRepository ,
								  CountryRepository countryRepository) {
		return (args) -> {


			Redactor redactor = new Redactor("UserRedactor", "firstnameRedactor", "LastNameRedactor", "Redactor@gmail.com", "azerty", UserType.Redactor);
			Redactor redactor2 = new Redactor("UserRedactor2", "firstnameRedacto2", "LastNameRedactor 2", "Redactor2@gmail.com", "azerty", UserType.Redactor);
			SuperAdmin SuperAdmin = new SuperAdmin("SuperAdmin", "Super", "Admin", "superadmin@gmail.com", "azerty", UserType.SuperAdmin);
			Moderator moderator = new Moderator("UserModerator", "firstnameModerator", "LastNameModerator", "Moderator@gmail.com", "azerty", UserType.Moderator);
			HealthAgent healthagent = new HealthAgent("UserHealthAgent", "firstnameHealthAgent", "LastNameHealthAgent", "HealthAgent@gmail.com", "azerty", UserType.HealthAgent);


			userrepository.save(healthagent);
			userrepository.save(moderator);
			userrepository.save(SuperAdmin);
			userrepository.save(redactor);
			userrepository.save(redactor2);



			//--------------TEST ARTICLES -----------------------------
			Article article1 = new Article("Article Title ", "Article Content");
			article1.setArticleRedactor(redactor);
			article1.setArticleValidate(true);
			Article article2 = new Article("Article Title 2 ", "Article Content 2");
			article2.setArticleRedactor(redactor2);
			article2.setArticleValidate(false);


			articlerepository.save(article1);
			articlerepository.save(article2);
			//-------------- REGION COUNTRY CONTINENT    -----------------------------

			Continent africa = new Continent(Continents.Africa);
			Continent europe = new Continent(Continents.Europe);

			continentRepository.save(africa);
			continentRepository.save(europe);

			Country algeria = new Country("Algeria");
			Country tunisia = new Country("Tunisia");
			Country france  = new Country("France");
			Country germany = new Country("Germany");

			countryRepository.save(algeria);
			countryRepository.save(tunisia);
			countryRepository.save(france);
			countryRepository.save(germany);

			Region batna       = new Region("Batna");
			Region constantine = new Region("Constantineeeee");

			regionrepository.save(batna);
			regionrepository.save(constantine);


			constantine.setRegionCountry(algeria);
			batna.setRegionCountry(algeria);
			regionrepository.save(batna);
			regionrepository.save(constantine);

			algeria.setCountryContinent(africa);
			tunisia.setCountryContinent(africa);

			france.setCountryContinent(europe);
			germany.setCountryContinent(europe);


			algeria.getCountryRegions().add(constantine);
			algeria.getCountryRegions().add(batna);


			countryRepository.save(algeria);
			countryRepository.save(tunisia);
			countryRepository.save(france);
			countryRepository.save(germany);

			africa.getCountries().add(algeria);
			africa.getCountries().add(tunisia);

			europe.getCountries().add(france);
			europe.getCountries().add(germany);

			continentRepository.save(africa);
			continentRepository.save(europe);
			//--------------TEST STATISTICS -----------------------------
			RegionsStatistics constantineStatistics = new RegionsStatistics(11111, 11111, 11111, 11111);
			constantineStatistics.setStatisticsValidate(true);
			constantineStatistics.setStatisticsRegion(constantine);
			constantineStatistics.setStatisticsHealthAgent(healthagent);
			statisticsRepository.save(constantineStatistics);

			RegionsStatistics batnaStatistics = new RegionsStatistics(22222, 22222, 22222, 22222);
			batnaStatistics.setStatisticsValidate(false);
			batnaStatistics.setStatisticsHealthAgent(healthagent);
			batnaStatistics.setStatisticsRegion(batna);
			statisticsRepository.save(batnaStatistics);

			CountryStatistics algeriaStatistics = new CountryStatistics(33333, 33333, 33333, 33333);
			algeriaStatistics.setStatisticsValidate(true);
			algeriaStatistics.setStatisticsCountry(algeria);
			algeriaStatistics.setStatisticsHealthAgent(healthagent);
			constantineStatistics.setRegionsStatisticsCountryStatistics(algeriaStatistics);
			statisticsRepository.save(algeriaStatistics);





			System.out.println("____________________________"+algeria.getCountryRegions().size());
			System.out.println("____________________________" + batnaStatistics.getStatisticsRegion().getRegionName());
			System.out.println("____________________________"+africa.getCountries().size());





		};
	}
}





