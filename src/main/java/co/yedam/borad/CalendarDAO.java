package co.yedam.borad;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CalendarDAO extends DAO {
	private static CalendarDAO instance;

	private CalendarDAO() {

	}

	static CalendarDAO getInstance() {
		instance = new CalendarDAO();
		return instance;
	}

	// 삽입
	public HashMap<String, Object> insert(Calendar calendar) {
		connect();
		try { // 1. 칼럼2개 2.칼럼3개
			pstmt = conn.prepareStatement("insert into schedule (title,start,end) values (?,?,?)");
			pstmt.setString(1, calendar.getTitle());
			pstmt.setString(2, calendar.getStart());
			pstmt.setString(3, calendar.getEnd());
			int rr = pstmt.executeUpdate();
			System.out.println("입력건수" + rr);
			conn.commit();
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", calendar.getTitle());
			map.put("start", calendar.getStart());
			map.put("end", calendar.getEnd());
			return map;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("mag", e.getMessage());
				return map;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			disconnect();
		}
		return null;
	}

	// 삭제
	public HashMap<String, Object> delete(String title) {
		connect();
		String sql = "delete from schedule where title =?";
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			int r = pstmt.executeUpdate();
			System.out.println("삭제됨:" + r);
			return map;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 조회
	public List<HashMap<String, Object>> selectAll() {
		connect();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		try {
			pstmt = conn.prepareStatement("select * from schedule");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("title", rs.getString("title"));
				map.put("start", rs.getString("start"));
				map.put("end", rs.getString("end"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}
