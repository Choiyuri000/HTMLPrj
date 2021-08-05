package co.yedam.borad;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommentDAO extends DAO {
	private static CommentDAO instance;

	private CommentDAO() {

	}

	static CommentDAO getInstance() {
		instance = new CommentDAO();
		return instance;
	}

	public HashMap<String, Integer> getAmtByCountry() {
		connect();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String sql = "select BillingCountry, sum(total) as amt from invoices i group by BillingCountry";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				map.put(rs.getString(1), rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	// 글등록
	public HashMap<String, Object> insert(Comment comment) {
		// id_repository 테이블에서 현재 시퀀스번호
		// comments 테이블에 추가
		// id_repository에 새로운 시퀀스번호로 번경
		int nextId = 0;
		connect();
		try {
			conn.setAutoCommit(false);
			// 1) 현재 시퀀스번호가 가져오기.
			stmt = conn.createStatement(); // pstmt ?? 파라메터
			rs = stmt.executeQuery("select value from id_repository where name='comment'");
			if (rs.next()) {
				nextId = rs.getInt("value");
			}
			// 2) 시퀀스 1증가후 comment 입력
			nextId++;
			pstmt = conn.prepareStatement("insert into comments values(?,?,?)");
			pstmt.setInt(1, nextId);
			pstmt.setString(2, comment.getName());
			pstmt.setString(3, comment.getContent());
			int r = pstmt.executeUpdate(); // 조회: excuteQuery, 입력수정삭제: excuteUpdate
			System.out.println("입력건수" + r);
			// 3) 시퀀스번호를 변경
			pstmt = conn.prepareStatement("update id_repository set value=? where name='comment'");
			pstmt.setInt(1, nextId);
			pstmt.executeUpdate();
			conn.commit();//
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", nextId);
			map.put("name", comment.getName());
			map.put("content", comment.getContent());
			return map;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();//
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("msg", e.getMessage());
				return map;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			disconnect();
		}
		return null;
	}

	// 글 삭제 (매개값: 글번호)
	public HashMap<String, Object> delete(String id) {
		connect();
		String sql = "delete from comments where id=?";
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
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

	// 글내용 수정
	public HashMap<String, Object> update(Comment comment) {
		connect();
		String sql = "update comments set name=?, content=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment.getName());
			pstmt.setString(2, comment.getContent());
			pstmt.setString(3, comment.getId());
			int r = pstmt.executeUpdate();

			System.out.println("수정:" + r);

		} catch (SQLException e) {
			e.printStackTrace();
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("id", comment.getId());
			map.put("name", comment.getName());
			map.put("content", comment.getContent());
			return map;

		}
		return null;
	}

	// 글목록
	public List<HashMap<String, Object>> selectAll() {
		connect();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		try {
			pstmt = conn.prepareStatement("select * from comments");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("id", rs.getString("id"));
				map.put("name", rs.getString("name"));
				map.put("content", rs.getString("content"));
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
