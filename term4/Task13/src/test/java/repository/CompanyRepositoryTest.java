package repository;

import config.DataSourceConfig;
import config.SpringDataJPAConfig;
import model.Company;
import model.Vacancy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.Collections;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfig.class, SpringDataJPAConfig.class})
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

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
        company.setVacancies(Collections.singletonList(vacancy));
        return company;
    }

    @Test
    public void companyFindAllTest() throws SQLException {
        Iterable<Company> companies = companyRepository.findAll();
        assertNotNull(companies);
        assertFalse(companies.iterator().hasNext());
        for (Company company : companies) {
            assertNotNull(company);
            assertNotNull(company.getId());
        }
    }

    @Test
    public void companyCRUDTest() throws SQLException {
        Company company = createCompany();
        // create, read
        companyRepository.save(company);

        company = companyRepository.findOne(company.getId());
        assertEquals(company.getName(), "JetBrains");
        assertEquals(company.getCity(), "Kazan");
        assertEquals(company.getEmail(), "jetbrains@example.com");
        assertEquals(company.getPassword(), "*******");
        assertEquals(company.getAbout(), "bla-bla-bla");


        // update
        company.setName("IT-company");
        company.setCity("NY");
        company.setEmail("example@example.com");
        company.setPassword("qwerty");
        company.setAbout("lorem ipsum ...");
        companyRepository.save(company);

        company = companyRepository.findOne(company.getId());
        assertEquals(company.getName(), "IT-company");
        assertEquals(company.getCity(), "NY");
        assertEquals(company.getEmail(), "example@example.com");
        assertEquals(company.getPassword(), "qwerty");
        assertEquals(company.getAbout(), "lorem ipsum ...");

        // delete
        companyRepository.delete(company);
        assertNull(companyRepository.findOne(company.getId()));

    }
}
