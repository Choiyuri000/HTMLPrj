package co.yedam.borad;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@WebServlet("/GetBoradServlet")
public class GetBoradServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetBoradServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		List<HashMap<String, Object>> list = CommentDAO.getInstance().selectAll();
		Gson gson = new GsonBuilder().create();
		//response.getWriter().print(gson.toJson(list));

		JsonArray outAry = new JsonArray();
		for (int i = 0; i < list.size(); i++) {
			HashMap<String, Object> map = list.get(i);
			JsonArray inAry = new JsonArray();
			inAry.add((String) map.get("id"));
			inAry.add((String) map.get("name"));
			inAry.add((String) map.get("content"));

			outAry.add(inAry);
		}
		JsonObject obj = new JsonObject();
		obj.add("dataSet", outAry);
		response.getWriter().print(gson.toJson(obj));;
	}// {"data" : [[1번째], [2번째] ... [마지막]]

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
