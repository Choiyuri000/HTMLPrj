package co.yedam.borad;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@WebServlet("/GetAmtByCountryServ")
public class GetAmtByCountryServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetAmtByCountryServ() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HashMap<String, Integer> map = CommentDAO.getInstance().getAmtByCountry();
		Gson gson = new GsonBuilder().create();

		JsonArray aryOut = new JsonArray();
		Set<String> set = map.keySet();
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			JsonArray aryIn = new JsonArray();

			String key = iter.next();
			Integer val = map.get(key);

			aryIn.add(key);
			aryIn.add(val); // 배열안에 배열
			 
			aryOut.add(aryIn);
			
		}
		// [[k,v], [k,v], [k,v]]
		response.getWriter().print(gson.toJson(aryOut));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
