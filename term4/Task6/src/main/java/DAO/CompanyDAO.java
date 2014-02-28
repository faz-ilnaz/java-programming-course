package DAO;

import java.sql.SQLException;
import java.util.List;

import logic.Company;

public interface CompanyDAO {
	public void addCompany(Company company) throws SQLException;
	public void updateCompany(Company company) throws SQLException;
	public Company getCompanyById(Long id) throws SQLException;
	public List getAllCompanies() throws SQLException;
	public void deleteCompany(Company company) throws SQLException; 
}
