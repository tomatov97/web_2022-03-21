package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ch06_joinSuccess
 */
@WebServlet(name="Ch06_joinSuccess", urlPatterns="/servlet/member/joinSuccess")
public class Ch06_joinSuccess extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter output = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");									
				
		try {
			
		} catch (NullPointerException e) {
			output.print("<h1> 접근 권한이 없습니다. </h1>");
			output.print("<a href = \"/member/join/join.html\">회원가입 페이지로 이동</a>");
			
			output.close();
			
		}
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies ) {
			String name = cookie.getName();
			
			if (name.equals("isJoin")) {
				String value = cookie.getValue();
				
				if (value.equals("true")) {
					
					output.print("<h1>회원 가입 완료!</h1>");
					output.print("<a href = \"/main/.html\">메인 페이지로 이동</a>");
					
					output.close();
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
