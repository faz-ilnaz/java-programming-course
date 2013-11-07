package com.kpfu.itis.transactions25;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

public class Task25 {

	public static void main(String[] args) {
		if(modifyDb(	1, "The Game", 890, 
					10, "A Farewell to Arms", 769,
					10, 5)) {
			System.out.println("transaction was successful!");
		} else {
			System.out.println("transaction has failed!");
		}
	}

	public static boolean modifyDb(
			int author_id1, String name1, int price1,
			int author_id2, String name2, int price2,
			int maxCount, int sale) {

		boolean ok = true;
		Connection con = null;
		double value = sale * 1.0 / 100;

		PreparedStatement updatePrices = null;
		Savepoint save = null;

		try {
			con = getConnection();
			con.setAutoCommit(false);

			add(author_id1, name1, price1);
			add(author_id2, name2, price2);

			save = con.setSavepoint();

			if (getCount() > maxCount) {
				try {
					String updateStatement = "update book "
							+ "set price = price - price * ?";
					updatePrices = con.prepareStatement(updateStatement);
					updatePrices.setDouble(1, value);
					updatePrices.executeUpdate();					
				} catch(SQLException exception) {
					ok = false;
					if (con != null) {
						try {
							System.err
									.print("Error! Transaction is being rolled back to savepoint");
							con.rollback(save);
						} catch (SQLException excep) {
							exception.printStackTrace();
						}
					}
				}
			}
			con.commit();
		} catch (SQLException e) {
			ok = false;
			e.printStackTrace();
			
			
		} finally {
			try {
				if (updatePrices != null)
					updatePrices.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ok;
	}

	public static int getCount() {
		Connection con = getConnection();
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String query = "SELECT COUNT(*) FROM book";

		int count = 0;

		try {
			ptmt = con.prepareStatement(query);
			rs = ptmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return count;

	}

	public static boolean add(int author_id, String name, int price) {
		Connection con = getConnection();
		boolean ok = true;
		PreparedStatement ptmt = null;

		try {
			String querystring = "INSERT INTO book (author_id, name, price) VALUES(?, ?, ?)";
			ptmt = con.prepareStatement(querystring);
			ptmt.setInt(1, author_id);
			ptmt.setString(2, name);
			ptmt.setInt(3, price);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			ok = false;
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ok;
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
