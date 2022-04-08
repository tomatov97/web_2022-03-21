package chapter06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ch06_ex04
 */
@WebServlet(name = "Ch06_ex04", urlPatterns = "/chapter06/session/create")
public class Ch06_ex04 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session == null) {
			System.out.println("세션 없음");
		} else {
			System.out.println("세션 있음");
			
			if (session.isNew()) {
				System.out.println("세션이 새로 만들어짐");
				
//				session.setMaxInactiveInterval(86400);
			} else {
				System.out.println("기존에 만들어진 세션");
			}
		}
		session.setMaxInactiveInterval(3);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
