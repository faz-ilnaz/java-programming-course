package com.kpfu.itis;

import java.util.Date;

public class CV {

	private int id;
	private String title;
	private Education education;
	private Date experience_from;
	private Gender gender;
	private String text;
	
	private int id_user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	public Date getExperience_from() {
		return experience_from;
	}

	public void setExperience_from(Date experience_from) {
		this.experience_from = experience_from;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
}
