package com.efrei.CoronaWatch.Repositories;

import com.efrei.CoronaWatch.Entities.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ArticleRepository extends CrudRepository<Article, Long> {

    Set<Article> findBytitle(String title);
}

