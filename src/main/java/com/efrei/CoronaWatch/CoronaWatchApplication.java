package com.efrei.CoronaWatch;

import com.efrei.CoronaWatch.Entities.*;
import com.efrei.CoronaWatch.Repositories.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.FileReader;
import java.util.*;

@SpringBootApplication
public class CoronaWatchApplication {
	@Autowired
	PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(CoronaWatchApplication.class, args);
	}

	/*public static void writeJsonSimple() throws Exception {
		JSONObject sampleObject = new JSONObject();
		sampleObject.put("name", "Stackabuser");
		sampleObject.put("age", 35);

		JSONArray messages = new JSONArray();
		messages.add("Hey!");
		messages.add("What's up?!");

		sampleObject.put("messages", messages);
		Files.write(Paths.get("C:\\Users\\SEYF_GOUMEIDA\\Documents\\GitHub\\coronawatchbis\\src\\main\\java\\com\\efrei\\CoronaWatch\\DataBDD\\test.json"), sampleObject.toJSONString().getBytes());
	}*/
	public static void readJsonRegions(String Country,Country c,CountryRepository countryRepository,RegionRepository regionRepository,StatisticsRepository statisticsRepository) {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("C:\\Users\\SEYF_GOUMEIDA\\Documents\\GitHub\\coronawatchbis\\src\\main\\java\\com\\efrei\\CoronaWatch\\DataBDD\\geo.json"));

			JSONObject jsonObject = (JSONObject) obj;

			JSONArray regionsList = (JSONArray) jsonObject.get(Country);

			if (regionsList != null){
				for(Iterator iterator = regionsList.iterator(); iterator.hasNext();) {
					String key = (String) iterator.next();
					System.out.println(key);
					Region r = new Region(key);
					regionRepository.save(r);
					r.setRegionCountry(c);
					regionRepository.save(r);
					RegionsStatistics rStatistics = new RegionsStatistics(0, 0, 0, 0,StatisticsTypes.Region);
					rStatistics.setStatisticsValidate(false);
					rStatistics.setStatisticsRegion(r);
					rStatistics.setStatisticsHealthAgent(null);
					statisticsRepository.save(rStatistics);
					c.getCountryRegions().add(r);
				}
			}
			countryRepository.save(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void readJsonCountries(CountryRepository countryRepository,RegionRepository regionRepository,StatisticsRepository statisticsRepository) {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("C:\\Users\\SEYF_GOUMEIDA\\Documents\\GitHub\\coronawatchbis\\src\\main\\java\\com\\efrei\\CoronaWatch\\DataBDD\\geo.json"));

			JSONObject jsonObject = (JSONObject) obj;

			for(Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				Country c = new Country(key);
				countryRepository.save(c);
				CountryStatistics al = new CountryStatistics(0,0,0,0,StatisticsTypes.Country);
				al.setStatisticsCountry(c);
				c.setCountryStatistics(al);
				statisticsRepository.save(c.getCountryStatistics());

				System.out.println(jsonObject.get(key));
				System.out.println(key);
				readJsonRegions(key,c,countryRepository,regionRepository,statisticsRepository);
			}



		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Bean
	public CommandLineRunner demo(ArticleRepository articlerepository ,
								  UserRepository userrepository ,
								  StatisticsRepository statisticsRepository,
								  RegionRepository regionrepository ,
								  ContinentRepository continentRepository ,
								  CountryRepository countryRepository) {
		return (args) -> {


			Redactor redactor = new Redactor("Redactor", "firstnameRedactor", "LastNameRedactor", "Redactor@gmail.com", encoder.encode("azerty"), UserType.Redactor);
			SuperAdmin SuperAdmin = new SuperAdmin("SuperAdmin", "Super", "Admin", "superadmin@gmail.com", encoder.encode("azerty"), UserType.SuperAdmin);
			Moderator moderator = new Moderator("Moderator", "firstnameModerator", "LastNameModerator", "Moderator@gmail.com",  encoder.encode("azerty"), UserType.Moderator);
			HealthAgent healthagent = new HealthAgent("HealthAgent", "firstnameHealthAgent", "LastNameHealthAgent", "HealthAgent@gmail.com",  encoder.encode("azerty"), UserType.HealthAgent);


			userrepository.save(healthagent);
			userrepository.save(moderator);
			userrepository.save(SuperAdmin);
			userrepository.save(redactor);



			//--------------TEST ARTICLES -----------------------------
			Article article1 = new Article("Article Title 1 ", "Article Content 1");
			article1.setArticleValidate(true);
			Commentary comment1 = new Commentary("Bla Bla Bla Bla Bla Bla Bla Bla ");
			comment1.setCommentArticle(article1);
			Commentary comment2 = new Commentary("Bla Bla Bla Bla Bla Bla Bla Bla ");
			comment2.setCommentArticle(article1);
			Commentary comment3 = new Commentary("Bla Bla Bla Bla Bla Bla Bla Bla ");
			comment3.setCommentArticle(article1);
			Commentary comment4 = new Commentary("Bla Bla Bla Bla Bla Bla Bla Bla ");
			comment4.setCommentArticle(article1);
			Set<Commentary> comments = new HashSet<Commentary>();
			comments.add(comment1);
			comments.add(comment2);
			comments.add(comment3);
			comments.add(comment4);
			article1.setArticleCommentaries(comments);
			Article article2 = new Article("Article Title 2 ", "Article Content 2");
			article2.setArticleValidate(false);
			Article article3 = new Article("Article Title 3 ", "Article Content 3");
			article1.setArticleValidate(true);
			articlerepository.save(article1);
			articlerepository.save(article2);
			articlerepository.save(article3);

			//-------------- REGION COUNTRY CONTINENT    -----------------------------

/*
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
			ContinentStatistics af = new ContinentStatistics(1649480,20515259,74248878,52488879,StatisticsTypes.Continent);
			af.setStatisticsContinent(africa);
			africa.setContinentStatistics(af);
			africa.getContinentStatistics().setStatisticsValidate(true);
			ContinentStatistics as = new ContinentStatistics(0,0,0,0,StatisticsTypes.Continent);
			as.setStatisticsContinent(asia);
			asia.setContinentStatistics(as);
			asia.getContinentStatistics().setStatisticsValidate(true);
			ContinentStatistics so = new ContinentStatistics(0,0,0,0,StatisticsTypes.Continent);
			so.setStatisticsContinent(south_America);
			south_America.setContinentStatistics(so);
			south_America.getContinentStatistics().setStatisticsValidate(true);
			ContinentStatistics no = new ContinentStatistics(0,0,0,0,StatisticsTypes.Continent);
			no.setStatisticsContinent(north_America);
			north_America.setContinentStatistics(no);
			north_America.getContinentStatistics().setStatisticsValidate(true);
			ContinentStatistics au = new ContinentStatistics(0,0,0,0,StatisticsTypes.Continent);
			au.setStatisticsContinent(australia_Oceania);
			australia_Oceania.setContinentStatistics(au);
			australia_Oceania.getContinentStatistics().setStatisticsValidate(true);
			ContinentStatistics an = new ContinentStatistics(0,0,0,0,StatisticsTypes.Continent);
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
*/

			Country algeria = new Country("Algeria");
			countryRepository.save(algeria);


			CountryStatistics al = new CountryStatistics(1649480,20515259,74248878,52488879,StatisticsTypes.Country);
			al.setStatisticsCountry(algeria);
			algeria.setCountryStatistics(al);
			al.setStatisticsValidate(true);
			statisticsRepository.save(algeria.getCountryStatistics());


			Region constantine = new Region("Constantinee");
			regionrepository.save(constantine);
			RegionsStatistics r = new RegionsStatistics(1649480,20515259,74248878,52488879,StatisticsTypes.Region);
			r.setStatisticsRegion(constantine);
			statisticsRepository.save(r);
			constantine.setRegionStatistics(r);

			regionrepository.save(constantine);
			constantine.setRegionCountry(algeria);
			regionrepository.save(constantine);
			algeria.getCountryRegions().add(constantine);
			countryRepository.save(algeria);


			//--------------TEST STATISTICS -----------------------------
			/*
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

			 */

			readJsonCountries(countryRepository,regionrepository,statisticsRepository);

		};
	}
}





