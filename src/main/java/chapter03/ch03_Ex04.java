package chapter03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ch03_Ex04
 */
@WebServlet("/ch03_Ex04")
public class ch03_Ex04 extends HttpServlet {

    public ch03_Ex04() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/plain;charset=UTF-8");
		
		// 클라이언트가 접근할 때 사용한 프로토콜 (http)
		String scheme = request.getScheme();
		
		// 클라이언트의 IP 주소
		String remoteAddr = request.getRemoteAddr();
		
		// 클라이언트가 서버로 접근할 때, 클라이언트도 클라이언트의 문 (포트)을 열고 나옴. 그 문 중 어떤 문(랜덤)인지 알려줌.
		int remotePort = request.getRemotePort();	
		
		PrintWriter out = response.getWriter();
		out.append("<html>");
		out.append("<head>");
		out.append("</head>");
		out.append("<body>");
		out.append("	<h3>클라이언트의 네트워크 관련된 요청 정보</h3>");
		out.append("	<p>사용한 프로토콜 : " + scheme + "</p>");
		out.append("	<p>클라이언트의 IP주소 : " + remoteAddr + "</p>");
		out.append("	<p>클라이언트의 포트 : " + remotePort + "</p>");
		out.append("</body>");
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
