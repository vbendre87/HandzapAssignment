package com.assignment.news.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="author")
public class Author {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String authorName;
	
	@Column(name = "status")
	private Boolean status;
	
	@Column(name = "last_written_date")
	private Date lastWrittenDate;
	
	@OneToMany(mappedBy = "author")
	private Set<Article> articles;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getLastWrittenDate() {
		return lastWrittenDate;
	}

	public void setLastWrittenDate(Date lastWrittenDate) {
		this.lastWrittenDate = lastWrittenDate;
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}		
}
