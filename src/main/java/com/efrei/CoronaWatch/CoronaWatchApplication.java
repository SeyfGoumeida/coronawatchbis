package com.efrei.CoronaWatch;

import com.efrei.CoronaWatch.Entities.*;
import com.efrei.CoronaWatch.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CoronaWatchApplication {
	@Autowired
	PasswordEncoder encoder;

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


			Redactor redactor = new Redactor("UserRedactor", "firstnameRedactor", "LastNameRedactor", "Redactor@gmail.com", encoder.encode("azerty"), UserType.Redactor);
			Redactor redactor2 = new Redactor("UserRedactor2", "firstnameRedacto2", "LastNameRedactor 2", "Redactor2@gmail.com", "azerty", UserType.Redactor);
			SuperAdmin SuperAdmin = new SuperAdmin("SuperAdmin", "Super", "Admin", "superadmin@gmail.com", encoder.encode("azerty"), UserType.SuperAdmin);
			Moderator moderator = new Moderator("UserModerator", "firstnameModerator", "LastNameModerator", "Moderator@gmail.com", "azerty", UserType.Moderator);
			HealthAgent healthagent = new HealthAgent("UserHealthAgent", "firstnameHealthAgent", "LastNameHealthAgent", "HealthAgent@gmail.com", "azerty", UserType.HealthAgent);


			userrepository.save(healthagent);
			userrepository.save(moderator);
			userrepository.save(SuperAdmin);
			userrepository.save(redactor);
			userrepository.save(redactor2);



			//--------------TEST ARTICLES -----------------------------
		/*	Article article1 = new Article("Article Title ", "Article Content");
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
			Continent asia = new Continent(Continents.Asia);
			Continent north_America = new Continent(Continents.North_America);
			Continent south_America = new Continent(Continents.South_America);
			Continent australia_Oceania = new Continent(Continents.Australia_Oceania);
			Continent antarctica = new Continent(Continents.Antarctica);


			continentRepository.save(asia);
			continentRepository.save(north_America);
			continentRepository.save(south_America);
			continentRepository.save(australia_Oceania);
			continentRepository.save(antarctica);
			continentRepository.save(africa);
			continentRepository.save(europe);
			ContinentStatistics af = new ContinentStatistics(1,1,1,1,StatisticsTypes.Continent);
			af.setStatisticsContinent(africa);
			africa.setContinentStatistics(af);
			africa.getContinentStatistics().setStatisticsValidate(true);
			ContinentStatistics as = new ContinentStatistics(1,1,1,1,StatisticsTypes.Continent);
			as.setStatisticsContinent(asia);
			asia.setContinentStatistics(as);
			asia.getContinentStatistics().setStatisticsValidate(true);
			ContinentStatistics so = new ContinentStatistics(1,1,1,1,StatisticsTypes.Continent);
			so.setStatisticsContinent(south_America);
			south_America.setContinentStatistics(so);
			south_America.getContinentStatistics().setStatisticsValidate(true);
			ContinentStatistics no = new ContinentStatistics(1,1,1,1,StatisticsTypes.Continent);
			no.setStatisticsContinent(north_America);
			north_America.setContinentStatistics(no);
			north_America.getContinentStatistics().setStatisticsValidate(true);
			ContinentStatistics au = new ContinentStatistics(1,1,1,1,StatisticsTypes.Continent);
			au.setStatisticsContinent(australia_Oceania);
			australia_Oceania.setContinentStatistics(au);
			australia_Oceania.getContinentStatistics().setStatisticsValidate(true);
			ContinentStatistics an = new ContinentStatistics(1,1,1,1,StatisticsTypes.Continent);
			an.setStatisticsContinent(antarctica);
			antarctica.setContinentStatistics(an);
			antarctica.getContinentStatistics().setStatisticsValidate(true);
			ContinentStatistics e = new ContinentStatistics(1,1,1,1,StatisticsTypes.Continent);
			e.setStatisticsContinent(europe);
			europe.setContinentStatistics(e);
			europe.getContinentStatistics().setStatisticsValidate(true);
			statisticsRepository.save(asia.getContinentStatistics());
			statisticsRepository.save(north_America.getContinentStatistics());
			statisticsRepository.save(south_America.getContinentStatistics());
			statisticsRepository.save(australia_Oceania.getContinentStatistics());
			statisticsRepository.save(antarctica.getContinentStatistics());
			statisticsRepository.save(africa.getContinentStatistics());
			statisticsRepository.save(europe.getContinentStatistics());


			Country algeria = new Country("Algeria");
			Country tunisia = new Country("Tunisia");
			Country france  = new Country("France");
			Country germany = new Country("Germany");

			countryRepository.save(algeria);
			countryRepository.save(tunisia);
			countryRepository.save(france);
			countryRepository.save(germany);

			CountryStatistics al = new CountryStatistics(0,0,0,0,StatisticsTypes.Country);
			al.setStatisticsCountry(algeria);
			algeria.setCountryStatistics(al);
			al.setCountryStatisticsContinentStatistics(africa.getContinentStatistics());
			statisticsRepository.save(algeria.getCountryStatistics());

			CountryStatistics tu = new CountryStatistics(0,0,0,0,StatisticsTypes.Country);
			tu.setStatisticsCountry(tunisia);
			tunisia.setCountryStatistics(tu);
			statisticsRepository.save(tunisia.getCountryStatistics());

			CountryStatistics fr = new CountryStatistics(0,0,0,0,StatisticsTypes.Country);
			fr.setStatisticsCountry(france);
			france.setCountryStatistics(fr);
			statisticsRepository.save(france.getCountryStatistics());

			CountryStatistics gr = new CountryStatistics(0,0,0,0,StatisticsTypes.Country);
			gr.setStatisticsCountry(germany);
			germany.setCountryStatistics(gr);
			statisticsRepository.save(germany.getCountryStatistics());




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
			RegionsStatistics constantineStatistics = new RegionsStatistics(11111, 11111, 11111, 11111,StatisticsTypes.Region);
			constantineStatistics.setStatisticsValidate(true);
			constantineStatistics.setStatisticsRegion(constantine);
			constantineStatistics.setStatisticsHealthAgent(healthagent);
			statisticsRepository.save(constantineStatistics);

			RegionsStatistics batnaStatistics = new RegionsStatistics(22222, 22222, 22222, 22222,StatisticsTypes.Region);
			batnaStatistics.setStatisticsValidate(false);
			batnaStatistics.setStatisticsHealthAgent(healthagent);
			batnaStatistics.setStatisticsRegion(batna);
			statisticsRepository.save(batnaStatistics);

			CountryStatistics algeriaStatistics = new CountryStatistics(33333, 33333, 33333, 33333,StatisticsTypes.Country);
			algeriaStatistics.setStatisticsValidate(true);
			algeriaStatistics.setStatisticsCountry(algeria);
			algeriaStatistics.setStatisticsHealthAgent(healthagent);
			constantineStatistics.setRegionsStatisticsCountryStatistics(algeriaStatistics);
			statisticsRepository.save(algeriaStatistics);





			System.out.println("____________________________"+algeria.getCountryRegions().size());
			System.out.println("____________________________" + batnaStatistics.getStatisticsRegion().getRegionName());
			System.out.println("____________________________"+africa.getCountries().size());



*/

		};
	}
}





