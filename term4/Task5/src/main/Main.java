package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import logic.Student;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;
import util.PrintUtil;

public class Main {

	public static void main(String[] args) throws SQLException {
		// Student s1 = new Student();
		// Student s2 = new Student();
		// Student s3 = new Student();
		// Student s4 = new Student();
		//
		// s1.setName("Ivanov Ivan");
		// s1.setAge(21l);
		// s2.setName("Petrova Alisa");
		// s2.setAge(24l);
		// s3.setName("Pirozhkov Artur");
		// s3.setAge(26l);
		// s4.setName("Zubin Egor");
		// s4.setAge(20l);

		//
		// Factory.getInstance().getStudentDAO().addStudent(s1);
		// Factory.getInstance().getStudentDAO().addStudent(s2);
		// Factory.getInstance().getStudentDAO().addStudent(s3);
		// Factory.getInstance().getStudentDAO().addStudent(s4);

		Session session = null;
		List<Student> studs = new ArrayList<Student>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();

			// 1) Criteria query
			studs = session
					.createCriteria(Student.class)
					.add(Restrictions.in("name", new String[] {
							"Pirozhkov Artur", "Ivanov Ivan" }))
					.add(Restrictions.disjunction()
							.add(Restrictions.isNull("age"))
							.add(Restrictions.gt("age", new Long(20))))
					.addOrder(Order.desc("name"))
					.setMaxResults(50)
					.list();
			PrintUtil.printAndClean("Criteria", studs);
			

			// 2) SQL query
			studs = session
					.createSQLQuery("select * from Student where age > ?")
					.addEntity(Student.class).setInteger(0, 21).list();
			PrintUtil.printAndClean("SQL", studs);
			
			
			// 3) HQL query
			Query q = session.createQuery("from Student order by age ASC");
//			q.setString(0, "age");
			studs = q.list();
			PrintUtil.printAndClean("HQL", studs);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

	}
}