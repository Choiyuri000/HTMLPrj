package co.yedam.borad;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/EmpListServlet.do")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//{"name":"Hong", "age":20, "score":80}
		Gson gson = new GsonBuilder().create();
		
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpList();
		
		response.getWriter().print(gson.toJson(list));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
