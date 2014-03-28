package repository;

import config.DataSourceConfig;
import config.SpringDataJPAConfig;
import model.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        DataSourceConfig.class, SpringDataJPAConfig.class})
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    private Category createCategory() {
        Category category = new Category();
        category.setName("Technology");
        return category;
    }

    @Test
    public void categoryFindAllTest() throws SQLException {
        Iterable<Category> categories = categoryRepository.findAll();
        assertNotNull(categories);
        assertFalse(categories.iterator().hasNext());
        for (Category category : categories) {
            assertNotNull(category);
            assertNotNull(category.getId());
        }
    }

    @Test
    public void categoryCRUDTest() throws SQLException {
        Category category = createCategory();
        // create, read
        categoryRepository.save(category);

        category = categoryRepository.findOne(category.getId());
        assertEquals(category.getName(), "Technology");

        // update
        category.setName("Programming");
        categoryRepository.save(category);
        assertEquals(category.getName(), "Programming");

        // delete
        categoryRepository.delete(category);
        assertNull(categoryRepository.findOne(category.getId()));
    }
}
