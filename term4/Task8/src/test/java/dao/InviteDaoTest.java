package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import model.CV;
import model.Category;
import model.Company;
import model.Gender;
import model.Invite;
import model.User;
import model.Vacancy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import config.PersistenceConfig;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class })
public class InviteDaoTest {

	@Autowired
	private InviteDAO inviteDAO;

	private Invite createInvite() {
		Invite invite = new Invite();
		Category category = new Category();
		category.setName("Technology");
		User user = new User();
		user.setGender(Gender.MALE);
		user.setFirstName("Henry");
		user.setLastName("Flannagan");
		user.setCity("Tualatin");
		user.setPassword("123456");
		user.setPhoneNumber("232-12-56");
		user.setEmail("henry@example.com");
		CV cv = new CV();
		cv.setCategories(Collections.singletonList(category));
		cv.setOwner(user);
		cv.setText("Python, Java, Ruby");
		cv.setTitle("Software developer");
		Company company = new Company();
		company.setName("JetBrains");
		company.setCity("Kazan");
		company.setEmail("jetbrains@example.com");
		company.setPassword("*******");
		company.setAbout("bla-bla-bla");
		Vacancy vacancy = new Vacancy();
		vacancy.setTitle("Java developer");
		vacancy.setCity("Kazan");
		vacancy.setCompany(company);
		vacancy.setCategory(category);
		invite.setType(1);
		invite.setVacancy(vacancy);
		invite.setCv(cv);
		return invite;
	}
	@Test
	public void testFindByCV() throws SQLException {
		Invite newInvite = createInvite();
		// create
		inviteDAO.save(newInvite);
		
		List<Invite> invites = inviteDAO.findInvitesByCv(newInvite.getCv()
				.getId());
		assertFalse(invites.isEmpty());
		for (Invite i : invites) {
			assertNotNull(i);
			assertNotNull(i.getId());
		}
	}

	@Test
	public void testFindAll() throws SQLException {
		List<Invite> invites = inviteDAO.findAll();
		assertNotNull(invites);
		assertFalse(invites.isEmpty());
		for (Invite invite : invites) {
			assertNotNull(invite);
			assertNotNull(invite.getId());
		}
	}


	@Test
	public void testFindByVacancies() throws SQLException {
		Invite newInvite = createInvite();
		// create
		inviteDAO.save(newInvite);
		List<Invite> invites = inviteDAO.findInvitesByVacancy(newInvite
				.getVacancy().getId());
		assertFalse(invites.isEmpty());
		for (Invite i : invites) {
			assertNotNull(i);
			assertNotNull(i.getId());
		}
	}

	@Test
	public void testCRUD() throws SQLException {
		Invite invite = createInvite();
		// create, read
		inviteDAO.save(invite);
		assertEquals(inviteDAO.findById(invite.getId()).getType(), 1);

		// update
		invite.setType(0);
		inviteDAO.save(invite);
		assertEquals(inviteDAO.findById(invite.getId()).getType(), 0);

		// delete
		inviteDAO.delete(invite);
		assertNull(inviteDAO.findById(invite.getId()));
	}
}
