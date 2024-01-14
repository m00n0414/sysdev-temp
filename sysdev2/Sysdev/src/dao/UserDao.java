package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDao extends BaseDao {

	public boolean findByIdAndPassword(User user) {

		boolean isLogin = false;

		try {
			this.connect();
			System.out.println("接続成功");

			String sql = "SELECT user_id, control_id, user_name, password FROM admin_table WHERE user_id = ? AND password = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, user.getUser_id());
			ps.setString(2, user.getPassword());

			ResultSet rs = ps.executeQuery();

			System.out.println("SQL確認後");

			if (rs.next() && rs.getRow() == 1) {
				isLogin = true;
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {

				this.disConnect();

			} catch (SQLException e) {

				e.printStackTrace();

			}
		}
		return isLogin;
	}

	public int insert(User user) {
		try {
			this.connect();
			String sql = "INSERT INTO admin_table (user_id, user_name, password, vital) VALUES (?, ?, ?, 1)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, user.getUser_id());
			ps.setString(2, user.getUser_name());
			ps.setString(3, user.getPassword());

			int rowsAffected = ps.executeUpdate();
			return rowsAffected;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return 0; // またはエラーコードなどを適切に返す
		} finally {
			try {
				this.disConnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}