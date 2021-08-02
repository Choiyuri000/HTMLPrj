package co.yedam.borad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	protected Connection conn;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;

	public void connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			String url = "D:\\sqlite\\db\\chinook\\chinook.db";
			conn = DriverManager.getConnection("jdbc:sqlite:" + url);
			System.out.println("conneted!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//

	public void disconnect() {
		if (conn != null)
			try {
				// 5. 연결종료
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}//

}
