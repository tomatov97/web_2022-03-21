package chapter06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ch03_join
 */
@WebServlet(name="ch06_join", urlPatterns ="/servlet/member/join")
public class ch06_join extends HttpServlet {
	// 데이터베이스 역할을 할 리스트 생성
	private List<MemberInfo> memberInfoList = new ArrayList<>();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		
		boolean exist = false; //아이디가 중복되지 않았음을 가정
		for(int i=0; i < memberInfoList.size(); i++) {
			String otherid = memberInfoList.get(i).getId();
			if (otherid.equals(id)) {
				exist = true;
				break;
			} 			
		}
		
		if (!exist) {
			// 회원가입 : 새로운 회원의 정보를 이 사이트의 데이터베이스에 저장하는 것
			MemberInfo memberInfo = new MemberInfo (id, pw, name);
			
			// 회원 가입
			memberInfoList.add(memberInfo);
			
			Cookie cookie = new Cookie("isLogin", "true");
			response.addCookie(cookie);
			
			Cookie cookie2 = new Cookie("isJoin", "true");
			response.addCookie(cookie2);
			
			// 회원 가입 완료 페이지로 이동
			response.sendRedirect("/servlet/member/joinSuccess");	
		} else {
			response.sendRedirect("/member/join/joinFail.html");
			
		}
			
		
	}

}
