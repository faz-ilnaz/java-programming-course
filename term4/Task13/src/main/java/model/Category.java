package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="category")
public class Category {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	private Long id;
	private String name;
	
	@ManyToMany
	@JoinTable(name = "cv_category")
	List<CV> cvs;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    List<Vacancy> vacancies;
	
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
	public List<Vacancy> getVacancies() {
		return vacancies;
	}
	public void setVacancies(List<Vacancy> vacancies) {
		this.vacancies = vacancies;
	}
	public List<CV> getCvs() {
		return cvs;
	}
	public void setCvs(List<CV> cvs) {
		this.cvs = cvs;
	}
	
	
}
