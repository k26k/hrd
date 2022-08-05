package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dir/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8;");
		request.setCharacterEncoding("utf-8");
		ArrayList<Object> arr = new ArrayList<>();
		ArrayList<Object> arr2 = new ArrayList<>();
		arr.add(new String[] {"a","b","c"});
		arr2.add(new String[] {"q","w","e","r"});
		arr2.add(new String[] {"q","w","e","r"});
		arr.add(arr2);
		arr.add(arr2);
		request.setAttribute("몰?루1", arr);
		request.setAttribute("몰?루2", arr);
		request.setAttribute("몰?루3", arr);
		PrintWriter out = response.getWriter();
		//System.out.println(request.getParameter("num")==null);
		out.println("<style>*{margin:5px;}</style>");
		check(out, request, 0);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void check(PrintWriter out, Object object, int num) {
		int count = num;
		if(object == null) {
			out.println("<pre>"+"\t".repeat(count)+"null</pre>");
			
		}else if(object instanceof HttpServletRequest) {
			HttpServletRequest request = (HttpServletRequest)object;
			Enumeration<String> eStrP = request.getParameterNames();
			out.println("<pre>"+"\t".repeat(count++)+"getParameter</pre>");
			if(eStrP.hasMoreElements()) {
				while(eStrP.hasMoreElements()) {
					String str = eStrP.nextElement();
					out.println("<pre>"+"\t".repeat(count)+str+"</pre>");
					check(out, request.getParameter(str) , count+1);
				}
				//out.println("<pre> </pre>");
			}else {
				out.println("<pre>"+"\t".repeat(count)+"null</pre>");
			}
			count--;
			
			Enumeration<String> eStrA = request.getAttributeNames();
			out.println("<pre>"+"\t".repeat(count++)+"getAttribute</pre>");
			if(eStrA.hasMoreElements()) {
				while(eStrA.hasMoreElements()) {
					String str = eStrA.nextElement();
					out.println("<pre>"+"\t".repeat(count)+str+"</pre>");
					check(out, request.getAttribute(str) , count+1);
				}
				//out.println("<pre> </pre>");
			}else {
				out.println("<pre>"+"\t".repeat(count)+"null</pre>");
			}
			count--;
			
		}else if(object instanceof String) {
			out.println("<pre>"+"\t".repeat(count)+(String)object+"</pre>");
			
		}else if(object instanceof String[]) {
			out.println("<pre>"+"\t".repeat(count)+"String[]</pre>");
			for(Object object2:(String[])object) {
				check(out,object2,count+1);
			}
			
		}else if(object instanceof ArrayList<?>) {
			out.println("<pre>"+"\t".repeat(count)+"ArrayList<?></pre>");
			for(Object object2:(ArrayList<?>)object) {
				check(out,object2,count+1);
			}
			
		}else {
			out.println("<pre>"+"\t".repeat(count)+"can not cast "+object.getClass()+"</pre>");
		}
		//out.println("<pre> </pre>");
	}
	
}
