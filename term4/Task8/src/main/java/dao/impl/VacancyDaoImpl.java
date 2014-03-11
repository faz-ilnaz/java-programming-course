package dao.impl;

import java.util.List;

import model.Vacancy;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.VacancyDAO;

@Repository
public class VacancyDaoImpl extends CRUDDaoImpl<Vacancy> implements VacancyDAO {
	
	@Autowired
	public VacancyDaoImpl(SessionFactory sessionFactory) {
		super(Vacancy.class, sessionFactory);
	}

	@Override
	public List<Vacancy> findVacanciesByCompany(Long company) {
		return getSession().createQuery("from Vacancy v where v.company.id=?")
                .setParameter(0, company).list();
	}

	@Override
	public List<Vacancy> findVacanciesByCategory(Long category) {
		return getSession().createQuery("from Vacancy v where v.category.id=?")
                .setParameter(0, category).list();
	}

}
