package com.kpfu.itis.Task6;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import logic.CV;
import logic.Category;
import logic.Company;
import logic.Gender;
import logic.Invite;
import logic.User;
import logic.Vacancy;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import DAO.CVDAO;
import DAO.CategoryDAO;
import DAO.CompanyDAO;
import DAO.Factory;
import DAO.InviteDAO;
import DAO.UserDAO;
import DAO.VacancyDAO;

/**
 * Unit test for simple App.
 */
public class AppTest {
	private static CVDAO cvDao;
	private static UserDAO userDAO;
	private static CompanyDAO companyDAO;
	private static CategoryDAO categoryDAO;
	private static VacancyDAO vacancyDAO;
	private static InviteDAO inviteDAO;

	private static User user;
	private static CV cv;
	private static Category category;
	private static Vacancy vacancy;
	private static Company company;
	private static Invite invite;

	@BeforeClass
	public static void init() throws SQLException {
		cvDao = Factory.getInstance().getCVDAO();
		userDAO = Factory.getInstance().getUserDAO();
		companyDAO = Factory.getInstance().getCompanyDAO();
		categoryDAO = Factory.getInstance().getCategoryDAO();
		vacancyDAO = Factory.getInstance().getVacancyDAO();
		inviteDAO = Factory.getInstance().getInviteDAO();

		user = new User();
		user.setGender(Gender.MALE);
		user.setFirstName("Henry");
		user.setLastName("Flannagan");
		user.setCity("Tualatin");
		user.setPassword("123456");
		user.setPhoneNumber("232-12-56");
		user.setEmail("henry@example.com");

		category = new Category();
		category.setName("Technology");

		cv = new CV();
		cv.setCategories(Collections.singletonList(category));
		cv.setOwner(user);
		cv.setText("Python, Java, Ruby");
		cv.setTitle("Software developer");

		company = new Company();
		company.setName("JetBrains");
		company.setCity("Kazan");
		company.setEmail("jetbrains@example.com");
		company.setPassword("*******");
		company.setAbout("bla-bla-bla");

		vacancy = new Vacancy();
		vacancy.setTitle("Java developer");
		vacancy.setCity("Kazan");
		vacancy.setCompany(company);
		vacancy.setCategory(category);

		invite = new Invite();
		invite.setType(1);
		invite.setVacancy(vacancy);
		invite.setCv(cv);
	}
	
	@Before
	public void init2() throws SQLException {
		userDAO.add(user);
		companyDAO.add(company);
		categoryDAO.add(category);
		cvDao.add(cv);
		vacancyDAO.add(vacancy);
		inviteDAO.add(invite);
	}

	@Test
	public void userCRUDTest() throws SQLException {

		// CREATE, READ
		
		assertEquals(userDAO.findById(user.getId()).getFirstName(), "Henry");

		// UPDATE
		user.setGender(Gender.MALE);
		user.setFirstName("Bob");
		user.setLastName("Fisher");
		user.setCity("Portland");
		user.setPassword("654321");
		user.setPhoneNumber("345-13-85");
		user.setEmail("bob@example.com");
		userDAO.update(user);

		assertEquals(userDAO.findById(user.getId()).getGender(), Gender.MALE);
		assertEquals(userDAO.findById(user.getId()).getFirstName(), "Bob");
		assertEquals(userDAO.findById(user.getId()).getLastName(), "Fisher");
		assertEquals(userDAO.findById(user.getId()).getCity(), "Portland");
		assertEquals(userDAO.findById(user.getId()).getPassword(), "654321");
		assertEquals(userDAO.findById(user.getId()).getPhoneNumber(),
				"345-13-85");
		assertEquals(userDAO.findById(user.getId()).getEmail(),
				"bob@example.com");

		// DELETE
		userDAO.delete(user);
		assertNull(userDAO.findById(user.getId()));
	}

	@Test
	public void companyCRUDTest() throws SQLException {
		// create, read
		companyDAO.add(company);
		assertEquals(companyDAO.findById(company.getId()).getName(),
				"JetBrains");
		assertEquals(companyDAO.findById(company.getId()).getCity(), "Kazan");
		assertEquals(companyDAO.findById(company.getId()).getEmail(),
				"jetbrains@example.com");
		assertEquals(companyDAO.findById(company.getId()).getPassword(),
				"*******");
		assertEquals(companyDAO.findById(company.getId()).getAbout(),
				"bla-bla-bla");
		

		// update
		company.setName("IT-company");
		company.setCity("NY");
		company.setEmail("example@example.com");
		company.setPassword("qwerty");
		company.setAbout("lorem ipsum ...");
		companyDAO.update(company);

		assertEquals(companyDAO.findById(company.getId()).getName(),
				"IT-company");
		assertEquals(companyDAO.findById(company.getId()).getCity(), "NY");
		assertEquals(companyDAO.findById(company.getId()).getEmail(),
				"example@example.com");
		assertEquals(companyDAO.findById(company.getId()).getPassword(),
				"qwerty");
		assertEquals(companyDAO.findById(company.getId()).getAbout(),
				"lorem ipsum ...");

		// delete
		companyDAO.delete(company);
		assertNull(companyDAO.findById(company.getId()));

	}
	
	@Test
	public void categoryCRUDTest() throws SQLException {
		// create, read
		categoryDAO.add(category);
		
		assertEquals(categoryDAO.findById(category.getId()).getName(), "Technology");
		
		// update
		category.setName("Programming");
		categoryDAO.update(category);
		assertEquals(categoryDAO.findById(category.getId()).getName(), "Programming");
		
		// delete
		categoryDAO.delete(category);
		assertNull(categoryDAO.findById(category.getId()));
	}

	@Test
	public void cvCRUDTest() throws SQLException {
		// create, read
		cvDao.add(cv);
		assertEquals(cvDao.findById(cv.getId()).getTitle(),
				"Software developer");
		assertEquals(cvDao.findById(cv.getId()).getText(), "Python, Java, Ruby");
		
		// update
		cv.setTitle("Programmer");
		cvDao.update(cv);
		assertEquals(cvDao.findById(cv.getId()).getTitle(), "Programmer");
		
		// delete
		cvDao.delete(cv);
		assertNull(cvDao.findById(cv.getId()));
	}

	@Test
	public void vacancyCRUDTest() throws SQLException {
		//create, read
		vacancyDAO.add(vacancy);
		assertEquals(vacancyDAO.findById(vacancy.getId()).getTitle(), "Java developer");
		assertEquals(vacancyDAO.findById(vacancy.getId()).getCity(), "Kazan");

		// update
		vacancy.setCity("Scotland");
		vacancyDAO.update(vacancy);
		
		assertEquals(vacancyDAO.findById(vacancy.getId()).getCity(), "Scotland");
		
		// delete
		vacancyDAO.delete(vacancy);
		assertNull(vacancyDAO.findById(vacancy.getId()));
		
	}
	
	@Test
	public void inviteCRUDTest() throws SQLException {
		// create, read	
		inviteDAO.add(invite);
		assertEquals(inviteDAO.findById(invite.getId()).getType(), 1);
		
		// update
		invite.setType(0);
		inviteDAO.update(invite);
		assertEquals(inviteDAO.findById(invite.getId()), 0);
		
		// delete
		inviteDAO.delete(invite);
		assertNull(inviteDAO.findById(invite.getId()));
	}

//	@Test
//	public void userFindAllTest() throws SQLException {
//		userDAO.add(user);
//		List<User> users = userDAO.findAll();
//		assertNotNull(users);
//		assertFalse(users.isEmpty());
//		for (User user : users) {
//			assertNotNull(user);
//			assertNotNull(user.getId());
//		}
//	}

}
