package com.modestack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.modestack.dao.ArticleDao;
import com.modestack.handler.ResponseData;
import com.modestack.model.Article;
import com.modestack.repo.ArticleRepo;

@Service
public class ArticleService implements ArticleDao
{
	@Autowired
	ArticleRepo articleRepo;

	@Override
	public ResponseEntity<ResponseData> createArticle(Article article)
	{
		articleRepo.save(article);
		return new ResponseEntity<>(new ResponseData("New article created"), HttpStatus.CREATED);
	}

	@Override
	public List<Article> articlesList(int pageNo)
	{
		return articleRepo.findAllList(PageRequest.of(pageNo, 10));
	}
}