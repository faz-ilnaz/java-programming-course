package dao.impl;

import dao.CompanyDao;
import model.Company;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDaoImpl extends CRUDDaoImpl<Company> implements CompanyDao {
    @Autowired
    public CompanyDaoImpl(SessionFactory sessionFactory) {
        super(Company.class, sessionFactory);
    }
}
