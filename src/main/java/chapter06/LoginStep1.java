package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 로그인 스텝1
// 파라미터 확인 서블릿
// 로그린을 하기 위해 필요한 파라미터를 전달했는지 확인하는 서블릿

@WebServlet("/chapter06/login/step1")
public class LoginStep1 extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if ((id == null || pw == null) || (id.length() == 0 || pw.length() == 0)) {
			// 로그인에 필요한 파라미터 중 하나 이상을 전달 받지 못 했다.
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();			
			
			out.print("<h1>아이디 혹은 비밀번호를 입력하세요</h1>");
			out.close();
		} else {
			request.setAttribute("step1", "pass");
			RequestDispatcher rd = request.getRequestDispatcher("/chapter06/login/step2");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
