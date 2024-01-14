package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Home_Dto_;

public class _HomeSetUpDao extends BaseDao {

	//layouIdと一致するappを取得
	public List<String> getJspFilesFromDB(int userId, int layoutId) {
		List<String> dbJspFiles = new ArrayList<>();

		try {

			//BaseDao接続
			connect();

			//sql本文 未完成!!!!!!!!!!!!!!!!!!!!!!
			String query = "SELECT jsp_file_name FROM your_table_name WHERE user_id = ? AND layout_id = ? AND app_id = ?";
			try (PreparedStatement statement = con.prepareStatement(query)) {
				statement.setInt(1, userId);
				statement.setInt(2, layoutId);

				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						dbJspFiles.add(resultSet.getString("jsp_file_name"));
					}
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return dbJspFiles;
	}

	//単一userのlayout総数取得
	public int getUserLayoutCount(int userId) {
		int totalLayoutId = 0;

		try {

			//BaseDao接続
			connect();

			//layoutテーブルから同一userIdを持つlayoutIdの合計を取得する
			String query = "SELECT SUM(layout_id) AS UserLayoutCount FROM layout_table WHERE user_id = ?";
			try (PreparedStatement statement = con.prepareStatement(query)) {
				statement.setInt(1, userId);

				try (ResultSet resultSet = statement.executeQuery()) {
					if (resultSet.next()) {
						totalLayoutId = resultSet.getInt("CountLayoutId");
					}
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return totalLayoutId;
	}

	//DBからappjspを取得
	public Home_Dto_ getBlockData(int layoutId) {
		Home_Dto_ homeDto = new Home_Dto_();

		try {
			connect();
			System.out.println("01: getBlockData(int)実行");
			//blockテーブルからoccupied_area,appjspfile_nameを取得
			String query = "SELECT occupied_area, appjspfile_name FROM block_table WHERE layout_id = ?";
			try (PreparedStatement statement = con.prepareStatement(query)) {
				statement.setInt(1, layoutId);

				try (ResultSet resultSet = statement.executeQuery()) {
					while (resultSet.next()) {
						String area = resultSet.getString("occupied_area");
						String appjspfileName = resultSet.getString("appjspfile_name");
						System.out.println("02: getBlockData area: " + area + "\ngetBlockData area: " + appjspfileName);
						homeDto.addToAreaAndAppJspFileName(area, appjspfileName);
						System.out.println("03: getAreaAndAppJspFileNameByKey: " + homeDto.getAreaAndAppJspFileNameByKey("1"));
					}
				}
				
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				disConnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return homeDto;
	}

}
