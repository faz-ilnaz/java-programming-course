package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;
import java.util.List;

import model.CV;
import model.Category;
import model.Company;
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
public class VacancyDaoTest {

	@Autowired
	private VacancyDAO vacancyDAO;

	private Vacancy createVacancy() {
		Vacancy vacancy = new Vacancy();
		Company company = new Company();
		company.setName("JetBrains");
		company.setCity("Kazan");
		company.setEmail("jetbrains@example.com");
		company.setPassword("*******");
		company.setAbout("bla-bla-bla");
		Category category = new Category();
		category.setName("Technology");
		vacancy.setTitle("Java developer");
		vacancy.setCity("Kazan");
		vacancy.setCompany(company);
		vacancy.setCategory(category);
		return vacancy;
	}

	@Test
	public void testFindAll() throws SQLException {
		List<Vacancy> vacancies = vacancyDAO.findAll();
		assertNotNull(vacancies);
		assertFalse(vacancies.isEmpty());
		for (Vacancy v : vacancies) {
			assertNotNull(v);
			assertNotNull(v.getId());
		}
	}

	@Test
	public void testFindByCompany() throws SQLException {
		Vacancy newVac = createVacancy();
		// create
		vacancyDAO.save(newVac);
		List<Vacancy> vacancies = vacancyDAO.findVacanciesByCompany(newVac
				.getCompany().getId());

		assertNotNull(vacancies);
		assertFalse(vacancies.isEmpty());
		for (Vacancy v : vacancies) {
			assertNotNull(v);
			assertNotNull(v.getId());
		}
	}
	
	@Test
	public void testFindByCategory() throws SQLException {
		Vacancy newVac = createVacancy();
		// create
		vacancyDAO.save(newVac);
		List<Vacancy> vacancies = vacancyDAO.findVacanciesByCategory(newVac.getCategory().getId());

		assertNotNull(vacancies);
		assertFalse(vacancies.isEmpty());
		for (Vacancy v : vacancies) {
			assertNotNull(v);
			assertNotNull(v.getId());
		}
	}

	@Test
	public void testCRUD() throws SQLException {
		Vacancy vacancy = createVacancy();
		// create, read
		vacancyDAO.save(vacancy);
		assertEquals(vacancyDAO.findById(vacancy.getId()).getTitle(),
				"Java developer");
		assertEquals(vacancyDAO.findById(vacancy.getId()).getCity(), "Kazan");

		// update
		vacancy.setCity("Scotland");
		vacancyDAO.save(vacancy);

		assertEquals(vacancyDAO.findById(vacancy.getId()).getCity(), "Scotland");

		// delete
		vacancyDAO.delete(vacancy);
		assertNull(vacancyDAO.findById(vacancy.getId()));
	}
}
