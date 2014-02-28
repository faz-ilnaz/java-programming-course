package DAO;

import java.sql.SQLException;
import java.util.List;

import logic.Vacancy;

public interface VacancyDAO {
	public void addVacancy(Vacancy vacancy) throws SQLException;
	public void updateVacancy(Vacancy vacancy) throws SQLException;
	public Vacancy getVacancyById(Long id) throws SQLException;
	public List getAllVacancies() throws SQLException;
	public void deleteVacancy(Vacancy vacancy) throws SQLException; 
}
