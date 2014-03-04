package DAO;

import java.sql.SQLException;
import java.util.List;

public interface CRUDDao<T> {
	public void add(T item) throws SQLException;
    public void update(T item) throws SQLException;
    public T findById(Long id) throws SQLException;
    public List<T> findAll() throws SQLException;
    public void delete(T item) throws SQLException;
}
