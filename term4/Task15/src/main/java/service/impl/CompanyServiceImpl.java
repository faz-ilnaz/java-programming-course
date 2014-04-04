package service.impl;

import model.Company;
import model.Vacancy;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CompanyRepository;
import repository.VacancyRepository;
import service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

    private CompanyRepository companyRepository;
    private VacancyRepository vacancyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, VacancyRepository vacancyRepository) {
        this.companyRepository = companyRepository;
        this.vacancyRepository = vacancyRepository;
    }

    @Override
    public Vacancy getVacancyById(Long id) {
        return vacancyRepository.findOne(id);
    }

    @Override
    @Transactional
    public Company getCompanyById(Long id) {
        Company company = companyRepository.findOne(id);
        Hibernate.initialize(company.getVacancies());
        return company;
    }

    @Override
    public void saveVacancy(Vacancy vacancy) {
        vacancyRepository.save(vacancy);
    }

    @Override
    public Iterable<Vacancy> getAllVacancies() {
        return vacancyRepository.findAll();
    }

    @Override
    public Iterable<Vacancy> getVacancyListByCategoryId(Long categoryID) {
        return vacancyRepository.findByCategory(categoryID);
    }


}
