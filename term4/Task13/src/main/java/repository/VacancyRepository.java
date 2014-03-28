package repository;

import model.Category;
import model.Company;
import model.Vacancy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VacancyRepository extends CrudRepository<Vacancy, Long> {
    public List<Vacancy> findVacanciesByCompany(Company company);
    public List<Vacancy> findVacanciesByCategory(Category category);
}
