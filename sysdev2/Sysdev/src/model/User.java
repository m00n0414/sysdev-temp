package model;

import java.io.Serializable;

public class User implements Serializable {

	private String user_id;
	private String user_name;
	private String password;

	public User() {

	}

	public User(String user_id, String user_name, String password) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
	}

	public User(String user_id, String password) {
		this.user_id = user_id;
		this.password = password;

	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}