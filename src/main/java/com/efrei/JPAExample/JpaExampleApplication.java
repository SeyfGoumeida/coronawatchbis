package com.efrei.JPAExample;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class JpaExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaExampleApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo( ArticleRepository articlerepository) {
		return (args) -> {
			

			Redactor redactor1 =  new Redactor("UserRedactor","firstnameRedactor","LastNameRedactor","Redactor@gmail.com","azerty","Redactor");
			Article article1 = new Article("Article Title ","Article Content");
			article1.setArticleRedactor(redactor1);
			articlerepository.save(article1);

			Redactor redactor2 = new Redactor("UserRedactor2","firstnameRedacto2","LastNameRedactor 2","Redactor2@gmail.com","azerty","Redactor");
			Article article2 = new Article("Article Title 2 ","Article Content 2");
			article2.setArticleRedactor(redactor2);
			articlerepository.save(article2);

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
