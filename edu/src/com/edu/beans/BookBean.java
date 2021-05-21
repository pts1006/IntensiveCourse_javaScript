package com.edu.beans;

public class BookBean {

	private String title;
	private String author;
	private String publisher;
	
	public BookBean() {}
	// /jstl/exam02.jsp를 위해 만든 생성자.
	
	public BookBean(String title, String author, String publisher) {
	// 생성자를 호출할 때 매개 값을 담아주는 메소드
		
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	@Override
	public String toString() {
		return "BookBean [title=" + title + ", author=" + author + ", publisher=" + publisher + "]";
	}
	
}
