package model;

public class User {
	private String name;
	private String username;
	private String password;
	private int editor;
	private int author;
	
	public User(){
		
	}
	
	public User(String name, String username, String password, int editor, int author) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.editor = editor;
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEditor() {
		return editor;
	}

	public void setEditor(int editor) {
		this.editor = editor;
	}
	
	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}
	
	
	
	
}
