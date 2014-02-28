package com.kpfu.itis;

import java.util.List;

public class Company {
	
	private int id;
	private String name;
	private String city;
	private String about;
	private String email;
	private String password;
	
	private List<Vacancy> vacancies;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Vacancy> getVacancies() {
		return vacancies;
	}
	public void setVacancies(List<Vacancy> vacancies) {
		this.vacancies = vacancies;
	}

}
