package chapter07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/chapter07/ex01")
public class Ch07_ex01 extends HttpServlet {
	private static final long serialVersionUID = 1L;       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("<< Servlet 호출 >> ");
				
		PrintWriter out = response.getWriter();
		out.print("<h1>여기는 Servlet1 입니다</h1>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
