package com.assignment.news.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assignment.news.model.Article;
import com.assignment.news.model.Author;

@Component("newRepository")
public class NewsRepositoryImpl implements NewsRepository {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public List<String> getAvailableAuthors() {
		Session session = sessionFactory.getCurrentSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Author> cr = cb.createQuery(Author.class);
		Root<Author> authors = cr.from(Author.class);
		cr.select(authors).where(cb.equal(authors.get("status"),"Y"));
		 
		Query<Author> query = session.createQuery(cr);
		List<Author> results = query.getResultList();
		
		
        return results.stream().map(Author::getAuthorName)
                .collect(Collectors.toList());
	}

	@Override
	public List<Article> getArticlesByAuthor(final String authorName) {
		Session session = sessionFactory.getCurrentSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Article> cr = cb.createQuery(Article.class);
		Root<Article> articles = cr.from(Article.class);
		cr.select(articles).where(cb.equal(articles.get("author"), authorName));
		 
		Query<Article> query = session.createQuery(cr);
		List<Article> results = query.getResultList();
		
		
        return results;

	}

	@Override
	public List<Article> getArticlesByTitleAndDescription(String title, String description) {
		Session session = sessionFactory.getCurrentSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Article> cr = cb.createQuery(Article.class);
		Root<Article> articles = cr.from(Article.class);
		cr.select(articles).where(cb.equal(articles.get("title"), title))
		.where(cb.equal(articles.get("description"), description));
		 
		Query<Article> query = session.createQuery(cr);
		List<Article> results = query.getResultList();
		
		
        return results;
	}

	@Override
	public List<Author> getAuthorsByDate(String date) {
		Session session = sessionFactory.getCurrentSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Author> cr = cb.createQuery(Author.class);
		Root<Author> authors = cr.from(Author.class);
		cr.select(authors).where(cb.equal(authors.get("lastWrittenDate"),date));
		 
		Query<Author> query = session.createQuery(cr);
		List<Author> results = query.getResultList();
		
        return results;
	}

	@Override
	public List<Article> getArticlesByDate(String date) {
		Session session = sessionFactory.getCurrentSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Article> cr = cb.createQuery(Article.class);
		Root<Article> articles = cr.from(Article.class);
		cr.select(articles).where(cb.equal(articles.get("createdDate"), date));
		 
		Query<Article> query = session.createQuery(cr);
		List<Article> results = query.getResultList();

		return results;
	}

	@Override
	public List<Article> getArticlesByTags(String tag) {
		Session session = sessionFactory.getCurrentSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Article> cr = cb.createQuery(Article.class);
		Root<Article> articles = cr.from(Article.class);
		cr.select(articles).where(cb.equal(articles.get("tags"), tag));
		 
		Query<Article> query = session.createQuery(cr);
		List<Article> results = query.getResultList();
		
        return results;
	}

	@Override
	public List<Article> getArticlesByCity(String city) {
		Session session = sessionFactory.getCurrentSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Article> cr = cb.createQuery(Article.class);
		Root<Article> articles = cr.from(Article.class);
		cr.select(articles).where(cb.equal(articles.get("city"), city));
		 
		Query<Article> query = session.createQuery(cr);
		List<Article> results = query.getResultList();
		
		
        return results;

	}

	@Override
	public List<Article> getArticlesByCategory(String category) {
		Session session = sessionFactory.getCurrentSession();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Article> cr = cb.createQuery(Article.class);
		Root<Article> articles = cr.from(Article.class);
		cr.select(articles).where(cb.equal(articles.get("category"), category));
		 
		Query<Article> query = session.createQuery(cr);
		List<Article> results = query.getResultList();
		
		
        return results;

	}

}
