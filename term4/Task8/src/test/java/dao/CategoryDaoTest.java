package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;
import java.util.List;

import model.Category;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import config.PersistenceConfig;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        PersistenceConfig.class})
public class CategoryDaoTest {

	@Autowired
	private CategoryDao categoryDao;
	
	private Category createCategory() {
		Category category = new Category();
		category.setName("Technology");
		return category;
	}
	
	@Test
	public void categoryFindAllTest() throws SQLException {
		List<Category> categories = categoryDao.findAll();
		assertNotNull(categories);
		assertFalse(categories.isEmpty());
		for (Category category : categories) {
			assertNotNull(category);
			assertNotNull(category.getId());
		}
	}
	
	@Test
	public void categoryCRUDTest() throws SQLException {
		Category category = createCategory();
		// create, read
		categoryDao.save(category);
		
		assertEquals(categoryDao.findById(category.getId()).getName(), "Technology");
		
		// update
		category.setName("Programming");
		categoryDao.save(category);
		assertEquals(categoryDao.findById(category.getId()).getName(), "Programming");
		
		// delete
		categoryDao.delete(category);
		assertNull(categoryDao.findById(category.getId()));
	}
}
