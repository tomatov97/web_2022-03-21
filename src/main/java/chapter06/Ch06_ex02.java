package chapter06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ch06_ex02")
public class Ch06_ex02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Ch06_ex02() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		try {
			
			for(Cookie cookie : cookies) {
				String name = cookie.getName();
				String value = cookie.getValue();
				
				if (name.equals("id")) {
					System.out.println("이 서비스가 원하는 쿠키가 있음");
				}
				
				System.out.println(name + " = " + value);			
			}
			
		} catch (NullPointerException e) {
			System.out.println("쿠키가 없습니다");
		}
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
