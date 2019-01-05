package com.assignment.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.news.model.Article;
import com.assignment.news.model.Author;
import com.assignment.news.repository.NewsRepository;

@RestController
@RequestMapping("/v1/news")
public class NewsService {
	
	@Autowired
    @Qualifier("newRepository")
    private NewsRepository repository;
	
	@GetMapping("/authors")
	public List<String> getAvailableAuthors() {
		return repository.getAvailableAuthors();
	}

	@GetMapping("/articles/author/{authorName}")
	public List<Article> getArticlesByAuthor(@PathVariable String authorName) {
		return repository.getArticlesByAuthor(authorName);
	}
	
	@GetMapping("/articles")
	public List<Article> getArticlesByTitleAndDescription(@RequestParam("title") String title, @RequestParam("description") String description) {
		return repository.getArticlesByTitleAndDescription(title, description);
	}
	@GetMapping("/authors/{date}")
	public List<Author> getAuthorsByDate(@PathVariable String date) {
		return repository.getAuthorsByDate(date);
	}
	
	@GetMapping("/articles/date/{date}")
	public List<Article> getArticlesByDate(@PathVariable String date) {
		return repository.getArticlesByDate(date);
	}
	
	@GetMapping("/articles/tags/{tag}")
	public List<Article> getArticlesByTags(@PathVariable String tag) {
		return repository.getArticlesByTags(tag);
	}
	
	@GetMapping("/articles/city/{city}")
	public List<Article> getArticlesByCity(@PathVariable String city) {
		return repository.getArticlesByCity(city);
	}
	
	@GetMapping("/articles/category/{category}")
	public List<Article> getArticlesByCategory(@PathVariable String category) {
		return repository.getArticlesByCategory(category);
	}
}
