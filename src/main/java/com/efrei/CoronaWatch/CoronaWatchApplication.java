package com.efrei.CoronaWatch;

import com.efrei.CoronaWatch.Entities.*;
import com.efrei.CoronaWatch.Repositories.ArticleRepository;
import com.efrei.CoronaWatch.Repositories.StatisticsRepository;
import com.efrei.CoronaWatch.Repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class CoronaWatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronaWatchApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ArticleRepository articlerepository , UserRepository userrepository , StatisticsRepository statisticsRepository) {
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
			//--------------TEST REGION     -----------------------------

			Continent africa = new Continent(Continents.Africa);
			Country algeria = new Country("Algeria");
			Country tunisia = new Country("Tunisia");
			Country morocco = new Country("Morocco");
			List<Country> africaCountries = new ArrayList<>();
			africaCountries.add(algeria);
			africaCountries.add(tunisia);
			africaCountries.add(morocco);
			Set<Country> africaCountriesSet = new HashSet<>(africaCountries);
			africa.setCountries(africaCountriesSet);
			Region constantine = new Region("Constantineeeee");
			constantine.setRegionCountry(algeria);

			Region batna = new Region("Batna");
			constantine.setRegionCountry(algeria);
			//--------------TEST STATISTICS -----------------------------
			Statistics statistics = new Statistics(10, 100, 200, 500);
			statistics.setStatisticsValidate(true);
			statistics.setStatisticsRegion(constantine);
			statistics.setStatisticsHealthAgent(healthagent);

			statisticsRepository.save(statistics);
			statisticsRepository.save(statistics);

			Statistics statistics2 = new Statistics(10, 100, 200, 500);
			statistics2.setStatisticsValidate(false);
			statistics2.setStatisticsHealthAgent(healthagent);
			statistics2.setStatisticsRegion(batna);
			statisticsRepository.save(statistics2);




		};
	}
}





