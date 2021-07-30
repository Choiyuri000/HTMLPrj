package co.yedam;

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
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");
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
