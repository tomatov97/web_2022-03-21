package chapter04;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ch04_Ex01
 */
@WebServlet("/ch04_Ex01")
public class ch04_Ex01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ch04_Ex01() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String[] hobbys = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String religion = request.getParameter("religion");
		String intro = request.getParameter("intro");
		
		System.out.println("Post 파라미터 출력");
		System.out.println("id= " + id);
		
		try {
			for(int i=0; i<hobbys.length; i++) {
				System.out.println(hobbys[i]);
			}
		} catch (NullPointerException e) {
			System.out.println("전달된 취미가 없습니다.");
		}
//		System.out.println("hobbys = " + Arrays.toString(hobbys));
		System.out.println("gender = " + gender);
		
		
	}

}
