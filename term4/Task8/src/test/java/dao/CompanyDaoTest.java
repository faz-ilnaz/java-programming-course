package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import model.Company;
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
public class CompanyDaoTest {

	@Autowired
	private CompanyDao companyDao;

	private Company createCompany() {
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
		company.setVacancies(Collections.singleton(vacancy));
		return company;
	}
	
	@Test
	public void companyFindAllTest() throws SQLException {
		List<Company> companies = companyDao.findAll();
		assertNotNull(companies);
		assertFalse(companies.isEmpty());
		for (Company company : companies) {
			assertNotNull(company);
			assertNotNull(company.getId());
		}
	}
	
	@Test
	public void companyCRUDTest() throws SQLException {
		Company company = createCompany();
		// create, read
		companyDao.save(company);
		assertEquals(companyDao.findById(company.getId()).getName(),
				"JetBrains");
		assertEquals(companyDao.findById(company.getId()).getCity(), "Kazan");
		assertEquals(companyDao.findById(company.getId()).getEmail(),
				"jetbrains@example.com");
		assertEquals(companyDao.findById(company.getId()).getPassword(),
				"*******");
		assertEquals(companyDao.findById(company.getId()).getAbout(),
				"bla-bla-bla");
		

		// update
		company.setName("IT-company");
		company.setCity("NY");
		company.setEmail("example@example.com");
		company.setPassword("qwerty");
		company.setAbout("lorem ipsum ...");
		companyDao.save(company);

		assertEquals(companyDao.findById(company.getId()).getName(),
				"IT-company");
		assertEquals(companyDao.findById(company.getId()).getCity(), "NY");
		assertEquals(companyDao.findById(company.getId()).getEmail(),
				"example@example.com");
		assertEquals(companyDao.findById(company.getId()).getPassword(),
				"qwerty");
		assertEquals(companyDao.findById(company.getId()).getAbout(),
				"lorem ipsum ...");

		// delete
		companyDao.delete(company);
		assertNull(companyDao.findById(company.getId()));

	}
}
