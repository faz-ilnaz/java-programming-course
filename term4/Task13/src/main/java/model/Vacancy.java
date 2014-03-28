package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="vacancy")
public class Vacancy {
	
	@Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="city")
	private String city;
	
	@Column(name="salary")
	private int salary;
	
	@Column(name="vac_text")
	private String text;
	
	@Column(name = "qualification")
	private int qualification;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id")
	private Company company;
	
	@OneToMany(mappedBy = "vacancy", cascade = CascadeType.ALL)
	private List<Invite> invites;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getQualification() {
		return qualification;
	}
	public void setQualification(int qualification) {
		this.qualification = qualification;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Invite> getInvites() {
		return invites;
	}
	public void setInvites(List<Invite> invites) {
		this.invites = invites;
	}
}
