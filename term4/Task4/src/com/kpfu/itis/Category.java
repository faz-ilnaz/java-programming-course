package com.kpfu.itis;

import java.util.List;

public class Category {

	private int id;
	private String name;
	
	List<CV> cvs;
	List<Vacancy> vacancies;
	
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
	public List<Vacancy> getVacancies() {
		return vacancies;
	}
	public void setVacancies(List<Vacancy> vacancies) {
		this.vacancies = vacancies;
	}
	
	
}
