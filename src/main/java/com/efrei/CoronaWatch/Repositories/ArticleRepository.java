package com.efrei.CoronaWatch.Repositories;

import com.efrei.CoronaWatch.Entities.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

    Article findBytitle(String title);
    Article findByIdArticle(long id);
}

