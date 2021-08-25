package com.galvanize.tmo.paspringstarter;

/**
 * 
 * @author MShakur2
 * 
 * POJO to store book information
 *
 */
public class Book {
	private Long id;
	private String author;
	private String title;
	private int yearPublished;

	public Book()
	{
		super();
	}

	public Book(Long id, String author, String title, int yearPublished) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.yearPublished = yearPublished;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYearPublished() {
		return yearPublished;
	}
	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}


}
