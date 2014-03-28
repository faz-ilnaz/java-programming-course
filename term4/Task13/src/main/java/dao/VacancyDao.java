package dao;

import model.Vacancy;

import java.util.List;

public interface VacancyDao extends CRUDDao<Vacancy> {
    public List<Vacancy> findVacanciesByCompany(Long company);
    public List<Vacancy> findVacanciesByCategory(Long category);
}
