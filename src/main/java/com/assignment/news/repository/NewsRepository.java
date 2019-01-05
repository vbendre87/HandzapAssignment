package com.assignment.news.repository;

import java.util.List;

import com.assignment.news.model.Article;
import com.assignment.news.model.Author;

public interface NewsRepository {
	
	List<String> getAvailableAuthors();
	
	List<Article> getArticlesByAuthor(String authorName);
	
	List<Article> getArticlesByTitleAndDescription(String title, String description);

	List<Author> getAuthorsByDate(String date);
	
	List<Article> getArticlesByDate(String date);
	
	List<Article> getArticlesByTags(String tag);
	
	List<Article> getArticlesByCity(String city);
	
	List<Article> getArticlesByCategory(String category);
}
