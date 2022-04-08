package chapter05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ch05_ex01 extends HttpServlet{
	private int value;
	private String name;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("서블릿 생성");
		
		String value = config.getInitParameter("value");
		Integer intValue = new Integer(value);
		// 요것도 가능 (바로 int로 바꿈)
		Integer.parseInt(value);
		
		System.out.println("value = " + value);
		
		this.value = intValue;
//		this.value = Integer.parseInt(value);     이렇게도 가능하다는 말!
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 호출됨");
		
		req.setCharacterEncoding("UTF-8");
		
		name = req.getParameter("name");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//   ---------- 데이터를 꺼내는 부분 --------------
		
		resp.setContentType("text/plain;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();		
		out.print("당신이 전달한 name 파라미터의 값은 [ "+ name + " ] 입니다.");
//   -------- 클라이언트에게 전달하는 부분 ------------
		
	}

}
