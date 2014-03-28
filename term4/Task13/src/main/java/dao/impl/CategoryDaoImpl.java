package dao.impl;

import dao.CategoryDao;
import model.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl extends CRUDDaoImpl<Category> implements CategoryDao {

    @Autowired
    public CategoryDaoImpl(SessionFactory sessionFactory) {
        super(Category.class, sessionFactory);
    }
}
