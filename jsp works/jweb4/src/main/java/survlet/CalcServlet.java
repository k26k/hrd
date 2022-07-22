package survlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("calc get");
		
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("calc post");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		try {
			long num1 = Long.parseLong(request.getParameter("num1"));
			long num2 = Long.parseLong(request.getParameter("num2"));
			String operator = request.getParameter("op");
			long result = 0L;
			
			switch(operator) {
			case "+":
				result = num1 + num2;
				break;
			case "-":
				result = num1 - num2;
				break;
			case "*":
				result = num1 * num2;
				break;
			case "/":
				result = num1 / num2;
				break;
			default:
				break;
			}
			
			out.append("<html><body>")
			   .append("<h2>계산기 서블릿</h2><hr>")
			   .append("계산결과: "+result)
			   .append("</body></html>");
			
		}catch(Exception e) {
			e.printStackTrace();
			out.append("<html><body>")
			   .append("<h2>계산기 서블릿</h2><hr>")
			   .append("계산 실패")
			   .append("</body></html>");
		}
	}
       
	

}
