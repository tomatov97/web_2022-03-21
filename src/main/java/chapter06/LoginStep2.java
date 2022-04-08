package chapter06;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 로그인 스텝2
// 회원정보 조회 서블릿
// 사용자가 입력한 아이디로 회원정보를 확인하는 서블릿

@WebServlet("/chapter06/login/step2")
public class LoginStep2 extends HttpServlet {

	public static List<MemberInfo> database;
	
	@Override
	public void init() throws ServletException {
		database = new ArrayList<>();
		
		// 회원가입 역할을 하는 코드
		MemberInfo memberInfo = new MemberInfo("id1", "pw1", "name1");
		
		database.add(memberInfo);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String step1Pass = (String) request.getAttribute("step1");
		
		if (step1Pass == null) {
			// step1을 통과하지 않고 바로 step2로 접근한 경우
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();	
			
			out.print("<h1>접근 권한이 없습니다.</h1>");
			out.close();
			
			return;
		} 
		
		String id = request.getParameter("id");
		MemberInfo memberInfo = null;
		
		for (MemberInfo nthMember : database) {
			String nthMemberId = nthMember.getId();
			if (nthMemberId.equals(id)) {
				memberInfo = nthMember;
			}
		}
		
		if(memberInfo == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();	
			
			out.print("<h1>일치하는 회원 정보가 없습니다.</h1>");
			out.close();
		} else {
			// 스텝2에서 조회한 정보를 스텝3로 넘겨줌
			request.setAttribute("step2", "pass");
			request.setAttribute("memberInfo", memberInfo);
			
			RequestDispatcher rd = request.getRequestDispatcher("/chapter06/login/step3");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
