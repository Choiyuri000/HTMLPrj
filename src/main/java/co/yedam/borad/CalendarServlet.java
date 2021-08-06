package co.yedam.borad;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalendarServlet")
public class CalendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CalendarServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/xml;charset=utf-8");
		response.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		String cmd = request.getParameter("cmd");

		if (cmd == null) {
			out.println(errorXML("cmd null"));
		} else if (cmd.equals("selectAll")) { // 조회
			try {
				List<HashMap<String, Object>> list = CalendarDAO.getInstance().selectAll();

				StringBuffer sb = new StringBuffer();
				sb.append("<result>");
				sb.append("<code>success</code>");
				sb.append("<data>");
				for (HashMap<String, Object> map : list) {
					sb.append("<row>");
					sb.append("<title>" + map.get("title") + "</title>");
					sb.append("<start>" + map.get("start") + "</start>");
					sb.append("<end>" + map.get("end") + "</end>");
					sb.append("</row>");
				}
				sb.append("</data>");
				sb.append("</result>");
				System.out.println(sb.toString());
				out.print(sb.toString());

			} catch (Exception e) {
				StringBuffer sb = new StringBuffer();
				sb.append("<result>");
				sb.append("<code>error</error>");
				sb.append("<data>" + e.getMessage() + "</data>");
				sb.append("</result>");
				out.print(sb.toString());
			}
		} else if (cmd.equals("insert")) { // 입력
			try {

				String title = request.getParameter("title");
				String start = request.getParameter("start");
				String end = request.getParameter("end");
				Calendar calendar = new Calendar();
				calendar.setTitle(title);
				calendar.setStart(start);
				HashMap<String, Object> map = CalendarDAO.getInstance().insert(calendar);
				out.println(dataXML(map));

			} catch (Exception e) {
				out.print(errorXML(e.getMessage()));
			}

		} else if (cmd.equals("delete")) { // 삭제
			String title = request.getParameter("title");
			HashMap<String, Object> map = CalendarDAO.getInstance().delete(title);
			out.println(dataXML(map));
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private String dataXML(HashMap<String, Object> map) {
		StringBuffer sb = new StringBuffer();
		sb.append("<result>");
		sb.append("<code>success</code>");
		sb.append("<data>");
		sb.append("<title>" + map.get("title") + "</title>");
		sb.append("<start>" + map.get("start") + "</start>");
		sb.append("<end>" + map.get("end") + "</end>");
		sb.append("</data>");
		sb.append("</result>");
		return sb.toString();
	}

	private String errorXML(String msg) {
		StringBuffer sb = new StringBuffer();
		sb.append("<result>");
		sb.append("<code>error</code>");
		sb.append("<data>" + msg + "</data>");
		sb.append("</result>");
		return sb.toString();
	}
}
