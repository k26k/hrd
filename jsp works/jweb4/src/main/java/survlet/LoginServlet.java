package survlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		String[] subjects = request.getParameterValues("subject");
		
		System.out.println("id: "+userid);
		System.out.println("pw: "+userpw);
		System.out.print("선택한 과목: ");
		if(subjects == null) {
			System.out.println("없음");
		}else {
			for(String subject:subjects) {System.out.print(subject+" ");}
			System.out.println("");
		}
	}

}
