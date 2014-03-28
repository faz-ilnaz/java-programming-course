package repository;

import config.DataSourceConfig;
import config.SpringDataJPAConfig;
import model.Category;
import model.Company;
import model.Vacancy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        DataSourceConfig.class, SpringDataJPAConfig.class})
public class VacancyRepositoryTest {

    @Autowired
    private VacancyRepository vacancyRepository;

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
        Iterable<Vacancy> vacancies = vacancyRepository.findAll();
        assertNotNull(vacancies);
        assertFalse(vacancies.iterator().hasNext());
        for (Vacancy v : vacancies) {
            assertNotNull(v);
            assertNotNull(v.getId());
        }
    }

    @Test
    public void testFindByCompany() throws SQLException {
        Vacancy newVac = createVacancy();
        // create
        vacancyRepository.save(newVac);
        List<Vacancy> vacancies = vacancyRepository.findVacanciesByCompany(newVac.getCompany());

        assertNotNull(vacancies);
        assertFalse(vacancies.isEmpty());
        for (Vacancy v : vacancies) {
            assertNotNull(v);
            assertNotNull(v.getId());
        }
        // delete
        vacancyRepository.delete(newVac);
        assertNull(vacancyRepository.findOne(newVac.getId()));
    }

    @Test
    public void testFindByCategory() throws SQLException {
        Vacancy newVac = createVacancy();
        // create
        vacancyRepository.save(newVac);
        List<Vacancy> vacancies = vacancyRepository.findVacanciesByCategory(newVac.getCategory());

        assertNotNull(vacancies);
        assertFalse(vacancies.isEmpty());
        for (Vacancy v : vacancies) {
            assertNotNull(v);
            assertNotNull(v.getId());
        }
        // delete
        vacancyRepository.delete(newVac);
        assertNull(vacancyRepository.findOne(newVac.getId()));
    }

    @Test
    public void testCRUD() throws SQLException {
        Vacancy vacancy = createVacancy();
        // create, read
        vacancyRepository.save(vacancy);

        vacancy = vacancyRepository.findOne(vacancy.getId());
        assertEquals(vacancy.getTitle(),
                "Java developer");
        assertEquals(vacancy.getCity(), "Kazan");

        // update
        vacancy.setCity("Scotland");
        vacancyRepository.save(vacancy);

        assertEquals(vacancyRepository.findOne(vacancy.getId()).getCity(), "Scotland");

        // delete
        vacancyRepository.delete(vacancy);
        assertNull(vacancyRepository.findOne(vacancy.getId()));
    }
}
