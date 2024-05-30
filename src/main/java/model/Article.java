package model;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Article {
	static int idSeed =1;
	private String title;
	private String excerpt;
	private String category;
	private String content;
	private int id;
	private LocalDateTime submitTime;
	private LocalDateTime publishTime;
	
	public Article() {
		this.submitTime = LocalDateTime.now();
		this.id = idSeed++;
		
	}
	
	public Article(String title, String excerpt, String category) {
		this.id = idSeed++;
		this.title = title;
		this.excerpt = excerpt;
		this.category = category;
		this.submitTime = LocalDateTime.now();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getExcerpt() {
		return excerpt;
	}

	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDateTime getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(LocalDateTime time) {
		this.submitTime = time;
	}
	public LocalDateTime getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(LocalDateTime time) {
		this.publishTime = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

}

