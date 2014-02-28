package DAO;

import java.sql.SQLException;
import java.util.List;

import logic.Category;

public interface CategoryDAO {
	public void addCategory(Category category) throws SQLException;
	public void updateCategory(Category category) throws SQLException;
	public Category getCategoryById(Long id) throws SQLException;
	public List getAllCategories() throws SQLException;
	public void deleteCategory(Category category) throws SQLException; 
}
