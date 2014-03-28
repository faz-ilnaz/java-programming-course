package repository;

import config.DataSourceConfig;
import config.SpringDataJPAConfig;
import model.CV;
import model.Category;
import model.Gender;
import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.Collections;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        DataSourceConfig.class, SpringDataJPAConfig.class})
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

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
        Iterable<User> users = userRepository.findAll();
        assertNotNull(users);
        assertFalse(users.iterator().hasNext());
        for (User user : users) {
            assertNotNull(user);
            assertNotNull(user.getId());
        }
    }

    @Test
    public void testCRUD() throws SQLException {
        User user = createUser();
        // CREATE, READ
        userRepository.save(user);
        user = userRepository.findOne(user.getId());
        assertEquals(user.getFirstName(), "Henry");

        // UPDATE
        user.setGender(Gender.MALE);
        user.setFirstName("Bob");
        user.setLastName("Fisher");
        user.setCity("Portland");
        user.setPassword("654321");
        user.setPhoneNumber("345-13-85");
        user.setEmail("bob@example.com");
        userRepository.save(user);

        assertEquals(userRepository.findOne(user.getId()).getGender(), Gender.MALE);
        assertEquals(userRepository.findOne(user.getId()).getFirstName(), "Bob");
        assertEquals(userRepository.findOne(user.getId()).getLastName(), "Fisher");
        assertEquals(userRepository.findOne(user.getId()).getCity(), "Portland");
        assertEquals(userRepository.findOne(user.getId()).getPassword(), "654321");
        assertEquals(userRepository.findOne(user.getId()).getPhoneNumber(),
                "345-13-85");
        assertEquals(userRepository.findOne(user.getId()).getEmail(),
                "bob@example.com");

        // DELETE
        userRepository.delete(user);
        assertNull(userRepository.findOne(user.getId()));
    }

}
