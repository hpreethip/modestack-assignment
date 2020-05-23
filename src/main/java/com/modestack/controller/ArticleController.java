package com.modestack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.modestack.dao.ArticleDao;
import com.modestack.handler.ResponseData;
import com.modestack.model.Article;

@RestController
public class ArticleController
{
	@Autowired
	ArticleDao articleDao;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/articles")
	public ResponseEntity<ResponseData> createArticle(@RequestBody Article article)
	{
		return articleDao.createArticle(article);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/articles")
	public List<Article> articlesList(@RequestParam int pageNo)
	{
		return articleDao.articlesList(pageNo);
	}
}