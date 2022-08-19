package com.check;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class Check {
	
	public static void check(PrintWriter out, Object object, int num) {
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
