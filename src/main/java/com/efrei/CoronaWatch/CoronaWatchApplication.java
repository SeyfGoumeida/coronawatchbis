package com.efrei.CoronaWatch;

import com.efrei.CoronaWatch.Entities.Article;
import com.efrei.CoronaWatch.Entities.Redactor;
import com.efrei.CoronaWatch.Entities.SuperAdmin;
import com.efrei.CoronaWatch.Entities.User;
import com.efrei.CoronaWatch.Repositories.ArticleRepository;
import com.efrei.CoronaWatch.Repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CoronaWatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronaWatchApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ArticleRepository articlerepository , UserRepository userrepository) {
		return (args) -> {
			

			Redactor redactor1 =  new Redactor("UserRedactor","firstnameRedactor","LastNameRedactor","Redactor@gmail.com","azerty","Redactor");
			Article article1 = new Article("Article Title ","Article Content");
			article1.setArticleRedactor(redactor1);


			Redactor redactor2 = new Redactor("UserRedactor2","firstnameRedacto2","LastNameRedactor 2","Redactor2@gmail.com","azerty","Redactor");
			Article article2 = new Article("Article Title 2 ","Article Content 2");
			article2.setArticleRedactor(redactor2);

			articlerepository.save(article1);
			articlerepository.save(article2);

			SuperAdmin SuperAdmin = new SuperAdmin("SuperAdmin","Super","Admin","superadmin@gmail.com","azerty","SuperAdmin");
			userrepository.save(SuperAdmin);
		/*	System.out.println("-------------------------------");
			System.out.println("Vehicules found with findAll():");
			for (Vehicule vehicule : repository.findAll()) {
				System.out.println(vehicule.toString());
			}

			System.out.println("-------------------------------");
			System.out.println("Persons associted with a vehicule");
			Iterable<Rent> rents = repository.findAll();
			City c = cities.iterator().next();

			List<Person> persons = c.getPersons();
			System.out.println(persons.toString());

			System.out.println("--------------------------------------------");
			System.out.println("City found with findName('Paris'):");
			repository.findByName("Paris").forEach(city -> {
				System.out.println(city.toString());
			}); */

		};
	}

}
