package com.modestack.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.modestack.handler.ResponseData;
import com.modestack.model.Article;

public interface ArticleDao
{
	ResponseEntity<ResponseData> createArticle(Article article);

	List<Article> articlesList(int pageNo);
}