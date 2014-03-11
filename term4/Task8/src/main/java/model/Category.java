package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="category")
public class Category {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	@Column(name = "id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany
	@JoinTable(name = "cv_category")
	Set<CV> cvs;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	Set<Vacancy> vacancies;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Vacancy> getVacancies() {
		return vacancies;
	}
	public void setVacancies(Set<Vacancy> vacancies) {
		this.vacancies = vacancies;
	}
	public Set<CV> getCvs() {
		return cvs;
	}
	public void setCvs(Set<CV> cvs) {
		this.cvs = cvs;
	}
	
	
}
