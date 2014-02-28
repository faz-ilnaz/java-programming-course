package DAO;

import java.sql.SQLException;
import java.util.List;

import logic.CV;

public interface CVDAO {
	public void addCV(CV cv) throws SQLException;
	public void updateCV(CV cv) throws SQLException;
	public CV getCVById(Long id) throws SQLException;
	public List getAllCVs() throws SQLException;
	public void deleteCV(CV cv) throws SQLException; 
}
