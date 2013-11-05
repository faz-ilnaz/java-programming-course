package com.kpfu.itis.transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task23 {


	public static void main(String[] args) {
		
		int percentage = 5;
		
		if(updateBookPrices(percentage)) {
			System.out.println("Update was successful");
		}
	}

	public static boolean updateBookPrices(int percentage) {
		
		boolean ok = true;

		PreparedStatement updatePrices = null;
		String updateStatement = "update book "
				+ "set price = price + price * ?";
		
		double value = percentage * 1.0 / 100;
		
		Connection con = getConnection();
		
		try {
			con.setAutoCommit(false);
			
			updatePrices = con.prepareStatement(updateStatement);
			updatePrices.setDouble(1, value);
			updatePrices.executeUpdate();
			
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			ok = false;
			if (con != null) {
				try {
					System.err.print("Error! Transaction is being rolled back");
					con.rollback();
				} catch (SQLException excep) {
					e.printStackTrace();
				}
			}
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
