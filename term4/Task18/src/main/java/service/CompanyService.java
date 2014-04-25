package service;

import model.Company;
import model.Vacancy;

public interface CompanyService {
    Vacancy getVacancyById(Long id);

    Company getCompanyById(Long id);

    void saveVacancy(Vacancy vacancy);

    Iterable<Vacancy> getAllVacancies();

    Iterable<Vacancy> getVacancyListByCategoryId(Long categoryId);

    public Iterable<Vacancy> getVacanciesByNamePart(String term);

    Company save(Company company);

    void delete(Long id);
}
