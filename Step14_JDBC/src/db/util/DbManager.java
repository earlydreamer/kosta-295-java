package db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {

	/**
	 * �ε�
	 */
	static {
		try {
			Class.forName(DbProperties.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	/**
	 * ����
	 * @throws SQLException
	 */
	// Ŀ�ؼ��� ȣ���ϴ� DAO���� ���ܸ� ó���ϵ��� ������.
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DbProperties.URL, DbProperties.USER_ID, DbProperties.USER_PASS);

	}

	public static Connection getConnection(String url, String id, String password) throws SQLException {
		return DriverManager.getConnection(url, id, password);

	}

	
	
	/**
	 * �ݱ� DML,DDL�� SELECT��
	 */

	public static void dbClose(Connection con, Statement st) {
		try {
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void dbClose(Connection con, Statement st, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose(con, st);
	}

}
