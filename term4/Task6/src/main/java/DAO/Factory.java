package DAO;

import DAO.Impl.CVDAOImpl;
import DAO.Impl.CategoryDAOImpl;
import DAO.Impl.CompanyDAOImpl;
import DAO.Impl.InviteDAOImpl;
import DAO.Impl.UserDAOImpl;
import DAO.Impl.VacancyDAOImpl;

public class Factory {

	private static UserDAO userDAO = null;
	private static CompanyDAO companyDAO = null;
	private static CVDAO cvdao = null;
	private static VacancyDAO vacancyDAO = null;
	private static InviteDAO inviteDAO = null;
	private static CategoryDAO categoryDAO = null;

	private static Factory instance = null;

	public static synchronized Factory getInstance() {
		if (instance == null) {
			instance = new Factory();
		}
		return instance;
	}

	public UserDAO getUserDAO() {
		if (userDAO == null) {
			userDAO = new UserDAOImpl();
		}
		return userDAO;
	}

	public CategoryDAO getCategoryDAO() {
		if (categoryDAO == null) {
			categoryDAO = new CategoryDAOImpl();
		}
		return categoryDAO;
	}
	
	public CVDAO getCvdao() {
		if (cvdao == null) {
			cvdao = new CVDAOImpl();
		}
		return cvdao;
	}
	
	public VacancyDAO getVacancyDAO() {
		if (vacancyDAO == null) {
			vacancyDAO = new VacancyDAOImpl();
		}
		return vacancyDAO;
	}
	
	public InviteDAO getInviteDAO() {
		if (inviteDAO == null) {
			inviteDAO = new InviteDAOImpl();
		}
		return inviteDAO;
	}
	
	public CompanyDAO getCompanyDAO() {
		if (companyDAO == null) {
			companyDAO = new CompanyDAOImpl();
		}
		return companyDAO;
	}
}