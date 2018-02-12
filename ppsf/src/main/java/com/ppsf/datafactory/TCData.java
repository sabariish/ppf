package com.ppsf.datafactory;

import java.util.List;

public class TCData extends TestDataObject{

	String Username;
	String Password;
	
	public TCData (List<Entry<String, String>> l) {
		super(l);
	}
	
	public String getUsername() {
		return Username;
	}
	
	public void setUsername(String username) {
		this.Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		this.Password = password;
	}
	
	
}
