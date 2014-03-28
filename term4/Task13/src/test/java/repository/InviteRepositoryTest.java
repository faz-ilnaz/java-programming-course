package repository;

import config.DataSourceConfig;
import config.SpringDataJPAConfig;
import model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        DataSourceConfig.class, SpringDataJPAConfig.class})
public class InviteRepositoryTest {

    @Autowired
    private InviteRepository inviteRepository;

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
        inviteRepository.save(newInvite);

        List<Invite> invites = inviteRepository.findInvitesByCv(newInvite.getCv());
        assertFalse(invites.isEmpty());
        for (Invite i : invites) {
            assertNotNull(i);
            assertNotNull(i.getId());
        }
        // DELETE
        inviteRepository.delete(newInvite);
        assertNull(inviteRepository.findOne(newInvite.getId()));
    }

    @Test
    public void testFindAll() throws SQLException {
        Iterable<Invite> invites = inviteRepository.findAll();
        assertNotNull(invites);
        assertFalse(invites.iterator().hasNext());
        for (Invite invite : invites) {
            assertNotNull(invite);
            assertNotNull(invite.getId());
        }
    }


    @Test
    public void testFindByVacancies() throws SQLException {
        Invite newInvite = createInvite();
        // create
        inviteRepository.save(newInvite);
        List<Invite> invites = inviteRepository.findInvitesByVacancy(newInvite.getVacancy());
        assertFalse(invites.isEmpty());
        for (Invite i : invites) {
            assertNotNull(i);
            assertNotNull(i.getId());
        }
        // DELETE
        inviteRepository.delete(newInvite);
        assertNull(inviteRepository.findOne(newInvite.getId()));
    }

    @Test
    public void testCRUD() throws SQLException {
        Invite invite = createInvite();
        // create, read
        inviteRepository.save(invite);
        assertEquals(inviteRepository.findOne(invite.getId()).getType(), 1);

        // update
        invite.setType(0);
        inviteRepository.save(invite);
        assertEquals(inviteRepository.findOne(invite.getId()).getType(), 0);

        // delete
        inviteRepository.delete(invite);
        assertNull(inviteRepository.findOne(invite.getId()));
    }
}
