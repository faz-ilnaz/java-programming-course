package main;

import java.sql.SQLException;
import java.util.List;

import logic.Company;
import logic.User;
import DAO.Factory;

public class Main {

	public static void main(String[] args) throws SQLException {

		User u1 = new User();
		u1.setFirstname("Peter");
		u1.setLastName("Brunos");
		u1.setCity("Portland");
		u1.setEmail("peter@yahoo.com");
		u1.setPassword("1111");
		u1.setPhoneNumber("999999");
		
		Company c1 = new Company();
		c1.setName("My_company");
		c1.setCity("Boston");
		c1.setEmail("example@example.com");
		c1.setPassword("123");
		c1.setAbout("Firm_description");

		Factory.getInstance().getUserDAO().addUser(u1);
		Factory.getInstance().getCompanyDAO().addCompany(c1);
		
        List<User> users = Factory.getInstance().getUserDAO().getAllUsers();
        System.out.println("========Все пользователи=========");
        for(int i = 0; i < users.size(); ++i) {
                System.out.println("User: " + users.get(i).getFirstname());
                System.out.println("=============================");              
        }  
        
        List<Company> companies = Factory.getInstance().getCompanyDAO().getAllCompanies();
        System.out.println("========Все компании=========");
        for(int i = 0; i < users.size(); ++i) {
                System.out.println("Company: " + companies.get(i).getName());
                System.out.println("=============================");              
        } 
        
	}
}