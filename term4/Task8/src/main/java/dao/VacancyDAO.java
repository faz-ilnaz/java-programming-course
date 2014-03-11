package dao;

import java.util.List;

import model.Vacancy;

public interface VacancyDAO extends CRUDDao<Vacancy> {
	
	public List<Vacancy> findVacanciesByCompany(Long company);
}
