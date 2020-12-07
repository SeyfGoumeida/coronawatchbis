package com.efrei.CoronaWatch;

import com.efrei.CoronaWatch.Entities.*;
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
			

			Redactor redactor =  new Redactor("UserRedactor","firstnameRedactor","LastNameRedactor","Redactor@gmail.com","azerty",UserType.Redactor);
			Redactor redactor2 = new Redactor("UserRedactor2","firstnameRedacto2","LastNameRedactor 2","Redactor2@gmail.com","azerty",UserType.Redactor);
			SuperAdmin SuperAdmin = new SuperAdmin("SuperAdmin","Super","Admin","superadmin@gmail.com","azerty",UserType.SuperAdmin);
			Moderator moderator = new Moderator("UserModerator","firstnameModerator","LastNameModerator","Moderator@gmail.com","azerty",UserType.Moderator);
			HealthAgent healthagent = new HealthAgent("UserHealthAgent","firstnameHealthAgent","LastNameHealthAgent","HealthAgent@gmail.com","azerty",UserType.HealthAgent);


			userrepository.save(healthagent);
			userrepository.save(moderator);
			userrepository.save(SuperAdmin);

			Article article1 = new Article("Article Title ","Article Content");
			article1.setArticleRedactor(redactor);

			Article article2 = new Article("Article Title 2 ","Article Content 2");
			article2.setArticleRedactor(redactor2);

			articlerepository.save(article1);
			articlerepository.save(article2);



		};
	}

}
