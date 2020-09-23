package com.example.shopping.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Review implements Serializable{
	private static final long serialVersionUID = 8825077708774058624L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String stars;

	@Column(length = 300)
	private String text;
	
	@Column(length = 100)
	private String author;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JsonIgnore
	private Product product;
	
	
	public Review() {
		super();
	}
	
	public Review(int id, String stars, String text, String author) {
		super();
		this.id = id;
		this.stars = stars;
		this.text = text;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", stars=" + stars + ", text=" + text + ", author=" + author + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStars() {
		return stars;
	}

	public void setStars(String stars) {
		this.stars = stars;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
}
