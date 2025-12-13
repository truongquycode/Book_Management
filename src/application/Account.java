package application;

import java.sql.Date;

public class Account {
	
	private int id;
	private String email;
	private String username;
	private String password;
	private String question;
	private String answer;
	private Date date;
	private Date update_date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", question=" + question + ", answer=" + answer + ", date=" + date + ", update_date=" + update_date
				+ "]";
	}
	public Account(int id, String email, String username, String password, String question, String answer, Date date,
			Date update_date) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.question = question;
		this.answer = answer;
		this.date = date;
		this.update_date = update_date;
	}
	public Account() {
		super();
	}
	
	
	
	
}
