package dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.CompanyDao;
import model.Company;

@Repository
public class CompanyDaoImpl extends CRUDDaoImpl<Company> implements CompanyDao {

	@Autowired
	public CompanyDaoImpl(SessionFactory sessionFactory) {
		super(Company.class, sessionFactory);
	}

}
