package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User owner;
	
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

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CV cv = (CV) o;

        if (!id.equals(cv.id)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "CV{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", owner=" + owner +
                '}';
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
