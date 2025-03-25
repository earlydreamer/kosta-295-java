package db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {

	/**
	 * 로드
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
	 * 연결
	 * @throws SQLException
	 */
	// 커넥션을 호출하는 DAO에서 예외를 처리하도록 던진다.
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DbProperties.URL, DbProperties.USER_ID, DbProperties.USER_PASS);

	}

	public static Connection getConnection(String url, String id, String password) throws SQLException {
		return DriverManager.getConnection(url, id, password);

	}

	
	
	/**
	 * 닫기 DML,DDL용 SELECT용
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
