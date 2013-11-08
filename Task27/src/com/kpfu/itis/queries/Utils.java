package com.kpfu.itis.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Formatter;

public class Utils {

	public static void query1() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			con = getConnection();
			pst = con
					.prepareStatement("SELECT name, job_title FROM employee "
							+ "WHERE job_title = "
							+ "(SELECT job_title FROM employee WHERE name = 'Victor');");
			rs = pst.executeQuery();

			ResultSetMetaData meta = rs.getMetaData();

			String colname1 = meta.getColumnName(1);
			String colname2 = meta.getColumnName(2);

			Formatter fmt1 = new Formatter();
			fmt1.format("%-21s%s", colname1, colname2);
			System.out.println(fmt1);

			while (rs.next()) {
				Formatter fmt2 = new Formatter();
				fmt2.format("%-21s", rs.getString(1));
				System.out.print(fmt2);
				System.out.println(rs.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void query2() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			con = getConnection();
			pst = con
					.prepareStatement("SELECT employee.name, dept.name FROM employee, dept "
							+ "WHERE dept_no = dept.id AND city = ("
							+ "SELECT city FROM dept WHERE dept.id = ("
							+ "SELECT dept_no FROM employee WHERE name = 'Victor'));");
			rs = pst.executeQuery();

			ResultSetMetaData meta = rs.getMetaData();

			String colname1 = meta.getColumnName(1);
			String colname2 = meta.getColumnName(2);

			Formatter fmt1 = new Formatter();
			fmt1.format("%-21s%s", colname1, colname2);
			System.out.println(fmt1);

			while (rs.next()) {
				Formatter fmt2 = new Formatter();
				fmt2.format("%-21s", rs.getString(1));
				System.out.print(fmt2);
				System.out.println(rs.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void query3() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			con = getConnection();
			pst = con
					.prepareStatement("SELECT name FROM employee WHERE	salary = ("
							+ "SELECT MIN(salary) FROM employee)");
			rs = pst.executeQuery();

			ResultSetMetaData meta = rs.getMetaData();

			String colname1 = meta.getColumnName(1);

			System.out.println(colname1);

			while (rs.next()) {
				System.out.println(rs.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void query4() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			con = getConnection();
			pst = con.prepareStatement("SELECT name FROM employee "
					+ "WHERE job_title IN ("
					+ "SELECT DISTINCT job_title FROM employee, dept "
					+ "WHERE dept_no = dept.id AND dept.name = 'sales');");
			rs = pst.executeQuery();

			ResultSetMetaData meta = rs.getMetaData();

			String colname1 = meta.getColumnName(1);

			System.out.println(colname1);

			while (rs.next()) {
				System.out.println(rs.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void query5() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			con = getConnection();
			pst = con
					.prepareStatement("SELECT * FROM employee WHERE dept_no IN "
							+ "( SELECT DISTINCT dept_no FROM employee WHERE job_title='analyst' );");
			rs = pst.executeQuery();

			ResultSetMetaData meta = rs.getMetaData();

			String colname1 = meta.getColumnName(1);
			String colname2 = meta.getColumnName(2);
			String colname3 = meta.getColumnName(3);
			String colname4 = meta.getColumnName(4);
			String colname5 = meta.getColumnName(5);
			String colname6 = meta.getColumnName(6);
			String colname7 = meta.getColumnName(7);
			String colname8 = meta.getColumnName(8);

			Formatter fmt1 = new Formatter();
			fmt1.format("%-5s%-15s%-15s%-10s%-20s%-10s%-15s%-10s", colname1,
					colname2, colname3, colname4, colname5, colname6, colname7,
					colname8);
			System.out.println(fmt1);

			while (rs.next()) {
				Formatter fmt2 = new Formatter();
				fmt2.format("%-5d%-15s%-15s%-10d%-20s%-10d%-15d%-10d",
						rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getDate(5), rs.getInt(6),
						rs.getInt(7), rs.getInt(8));
				System.out.println(fmt2);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void query6() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			con = getConnection();
			pst = con.prepareStatement("SELECT * FROM employee WHERE "
					+ "salary > ( SELECT AVG(salary) FROM employee);");
			rs = pst.executeQuery();

			ResultSetMetaData meta = rs.getMetaData();

			String colname1 = meta.getColumnName(1);
			String colname2 = meta.getColumnName(2);
			String colname3 = meta.getColumnName(3);
			String colname4 = meta.getColumnName(4);
			String colname5 = meta.getColumnName(5);
			String colname6 = meta.getColumnName(6);
			String colname7 = meta.getColumnName(7);
			String colname8 = meta.getColumnName(8);

			Formatter fmt1 = new Formatter();
			fmt1.format("%-7s%-20s%-15s%-10s%-20s%-10s%-15s%-10s", colname1,
					colname2, colname3, colname4, colname5, colname6, colname7,
					colname8);
			System.out.println(fmt1);

			while (rs.next()) {
				Formatter fmt2 = new Formatter();
				fmt2.format("%-7d%-20s%-15s%-10d%-20s%-10d%-15d%-10d",
						rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getDate(5), rs.getInt(6),
						rs.getInt(7), rs.getInt(8));
				System.out.println(fmt2);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void query7() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			con = getConnection();
			pst = con.prepareStatement("SELECT dept.id, dept.name, COUNT(*) "
					+ "FROM dept, employee "
					+ "WHERE dept_no = dept.id  AND job_title='analyst' "
					+ "GROUP BY dept.id;");
			rs = pst.executeQuery();

			ResultSetMetaData meta = rs.getMetaData();

			String colname1 = meta.getColumnName(1);
			String colname2 = meta.getColumnName(2);
			String colname3 = meta.getColumnName(3);

			Formatter fmt1 = new Formatter();
			fmt1.format("%-7s%-20s%s", colname1, colname2, colname3);
			System.out.println(fmt1);

			while (rs.next()) {
				Formatter fmt2 = new Formatter();
				fmt2.format("%-7d%-20s%d", rs.getInt(1), rs.getString(2), rs.getInt(3));
				System.out.println(fmt2);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void query8() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			con = getConnection();
			pst = con.prepareStatement(
					"SELECT dept.id, dept.name, SUM(salary) " +
					"FROM employee, dept " +
					"WHERE dept_no=dept.id " +
					"GROUP BY dept.id " +
					"HAVING COUNT(employee.id) > 2;");
			rs = pst.executeQuery();

			ResultSetMetaData meta = rs.getMetaData();

			String colname1 = meta.getColumnName(1);
			String colname2 = meta.getColumnName(2);
			String colname3 = meta.getColumnName(3);

			Formatter fmt1 = new Formatter();
			fmt1.format("%-7s%-20s%s", colname1, colname2, colname3);
			System.out.println(fmt1);

			while (rs.next()) {
				Formatter fmt2 = new Formatter();
				fmt2.format("%-7d%-20s%d", rs.getInt(1), rs.getString(2), rs.getInt(3));
				System.out.println(fmt2);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static Connection getConnection() {
		Connection con1 = null;
		try {
			con1 = ConnectionFactory.getInstance().getConnection();
		} catch (SQLException e) {
			System.err.println("Unable to connect to database");
			e.printStackTrace();
		}
		return con1;
	}

}
