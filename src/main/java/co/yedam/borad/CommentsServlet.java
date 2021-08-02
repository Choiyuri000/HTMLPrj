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

@WebServlet("/CommentsServlet")
public class CommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommentsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/xml;charset=utf-8");
		response.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		String cmd = request.getParameter("cmd");

		if (cmd == null) {
			StringBuffer sb = new StringBuffer();
			sb.append("<result>");
			sb.append("<code>error</code>");
			sb.append("<data>");
			sb.append("cmd null");
			sb.append("</data>");
			sb.append("</result>");
			out.print(sb.toString());

		} else if (cmd.equals("selectAll")) {
			List<HashMap<String, Object>> list = CommentDAO.getInstance().selectAll();
			
			StringBuffer sb = new StringBuffer();
			sb.append("<result>");
			sb.append("<code>success</code>");
			for(HashMap<String, Object> map : list) {
				sb.append("<data>");
				sb.append("<id>"+map.get("id")+"</id>");
				sb.append("<name>"+map.get("name")+"</name>");
				sb.append("<content>"+map.get("content")+"</content>");
				sb.append("</data>");
			}
			sb.append("</result>");
			System.out.println(sb.toString());
			out.print(sb.toString());
		} else if (cmd.equals("insert")) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
