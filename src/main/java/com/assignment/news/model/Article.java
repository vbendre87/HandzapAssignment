package com.assignment.news.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "last_updated_date")
	private Date lastUpdatedDate;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Author author;
	
	@ManyToMany
    @JoinTable(
        name = "article_tag", 
        joinColumns = { @JoinColumn(name = "article_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "tag_id") }
    )
	private Set<Tag> tags = new HashSet<Tag>();
	
	@ManyToOne
	@JoinColumn(name = "id")
	private City city;
	
	@ManyToMany
    @JoinTable(
        name = "article_category", 
        joinColumns = { @JoinColumn(name = "article_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "category_id") }
    )
	private Set<Category> categories = new HashSet<Category>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Author getAuthor() {
		return author;
	}
	
	public void setAuthor(Author author) {
		this.author = author;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
}
