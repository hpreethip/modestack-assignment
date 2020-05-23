package com.modestack.repo;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.modestack.model.Article;

@Repository
public interface ArticleRepo extends MongoRepository<Article, String>
{
	@Query("{}")
	List<Article> findAllList(PageRequest of);;
}