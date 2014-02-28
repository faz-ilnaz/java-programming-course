package logic;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "cv")
public class CV {

	@Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="education")
	private Education education;
	
	@Column(name="experience_from")
	@Temporal(value=TemporalType.DATE)
	private Date experienceFrom;
	
	@Column(name="gender")
	private Gender gender;
	
	@Column(name="cv_text")
	private String text;
	
	@ManyToOne
	private User user;
	
	@ManyToMany(mappedBy = "cvs")
	private List<Category> categories;
	
	@OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
	private List<Invite> invites;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
		return experienceFrom;
	}

	public void setExperience_from(Date experience_from) {
		this.experienceFrom = experience_from;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getExperienceFrom() {
		return experienceFrom;
	}

	public void setExperienceFrom(Date experienceFrom) {
		this.experienceFrom = experienceFrom;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Invite> getInvites() {
		return invites;
	}

	public void setInvites(List<Invite> invites) {
		this.invites = invites;
	}
}
