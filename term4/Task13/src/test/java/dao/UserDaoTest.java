package dao;

import config.PersistenceConfig;
import model.CV;
import model.Category;
import model.Gender;
import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        PersistenceConfig.class})
public class UserDaoTest {
	
	@Autowired
	private UserDao userDao;
	
	private User createUser() {
		User user = new User();
		user.setGender(Gender.MALE);
		user.setFirstName("Henry");
		user.setLastName("Flannagan");
		user.setCity("Tualatin");
		user.setPassword("123456");
		user.setPhoneNumber("232-12-56");
		user.setEmail("henry@example.com");
		CV cv = new CV();
        Category category = new Category();
        category.setName("Technology");
        cv.setCategories(Collections.singletonList(category));
        cv.setOwner(user);
		cv.setText("Python, Java, Ruby");
		cv.setTitle("Software developer");
		user.setCvs(Collections.singletonList(cv));
		return user;
	}
	
	@Test
	public void userFindAllTest() throws SQLException {
		List<User> users = userDao.findAll();
		assertNotNull(users);
		assertFalse(users.isEmpty());
		for (User user : users) {
			assertNotNull(user);
			assertNotNull(user.getId());
		}
	}

    @Test
    public void testCRUD() throws SQLException {
		User user = createUser();
		// CREATE, READ
		userDao.save(user);

		assertEquals(userDao.findById(user.getId()).getFirstName(), "Henry");

		// UPDATE
		user.setGender(Gender.MALE);
		user.setFirstName("Bob");
		user.setLastName("Fisher");
		user.setCity("Portland");
		user.setPassword("654321");
		user.setPhoneNumber("345-13-85");
		user.setEmail("bob@example.com");
		userDao.save(user);

		assertEquals(userDao.findById(user.getId()).getGender(), Gender.MALE);
		assertEquals(userDao.findById(user.getId()).getFirstName(), "Bob");
		assertEquals(userDao.findById(user.getId()).getLastName(), "Fisher");
		assertEquals(userDao.findById(user.getId()).getCity(), "Portland");
		assertEquals(userDao.findById(user.getId()).getPassword(), "654321");
		assertEquals(userDao.findById(user.getId()).getPhoneNumber(),
				"345-13-85");
		assertEquals(userDao.findById(user.getId()).getEmail(),
				"bob@example.com");

		// DELETE
		userDao.delete(user);
		assertNull(userDao.findById(user.getId()));
	}
	
}
