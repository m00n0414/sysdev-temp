package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {

	private static final String URL = "jdbc:mysql://localhost:3306/dev_test";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	protected Connection con = null;

	protected void connect() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(URL, USER, PASSWORD);
	}

	protected void disConnect() throws SQLException {
		if (con != null) {
			con.close();
		}
	}

}