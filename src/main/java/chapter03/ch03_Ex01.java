package chapter03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch03_Ex01")
public class ch03_Ex01 extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter outputstream = response.getWriter();
		
		outputstream.append("<html>");
		outputstream.append("	<head>");
		outputstream.append("		<title>Servlet Response Web Page</title>");
		outputstream.append("	</head>");
		outputstream.append("	<body>");
		outputstream.append("		<h1>Nice to meet you!</h1>");
		outputstream.append("		<h2>만나서 반갑습니다!</h2>");
		outputstream.append("	</body>");
		outputstream.append("</html>");
		
		outputstream.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
