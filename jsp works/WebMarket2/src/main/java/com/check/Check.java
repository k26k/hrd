package com.check;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;

public class Check {
	
	public static void check(PrintWriter out, Object object, int num) {
		int count = num;
		int len = 0;
		if(object == null) {
			out.println("<pre>"+"\t".repeat(count)+"null</pre>");
			
		}else if(object instanceof MultipartRequest) {
			out.println("<pre>"+"\t".repeat(count++)+"MultipartRequest</pre>");
			MultipartRequest request = (MultipartRequest)object;
			Enumeration<?> eStrP = request.getParameterNames();
			out.println("<pre>"+"\t".repeat(count++)+"getParameter</pre>");
			if(eStrP.hasMoreElements()) {
				while(eStrP.hasMoreElements()) {
					String str = (String)eStrP.nextElement();
					out.println("<pre>"+"\t".repeat(count)+str+"</pre>");
					check(out, request.getParameter(str) , count+1);
				}
				//out.println("<pre> </pre>");
			}else {
				out.println("<pre>"+"\t".repeat(count)+"null</pre>");
			}
			count--;
			
			Enumeration<?> eStrA = request.getFileNames();
			out.println("<pre>"+"\t".repeat(count++)+"getFile</pre>");
			if(eStrA.hasMoreElements()) {
				while(eStrA.hasMoreElements()) {
					String str = (String)eStrA.nextElement();
					out.println("<pre>"+"\t".repeat(count)+str+"</pre>");
					check(out, request.getFile(str) , count+1);
				}
				//out.println("<pre> </pre>");
			}else {
				out.println("<pre>"+"\t".repeat(count)+"null</pre>");
			}
			count--;
			
		}else if(object instanceof HttpServletRequest) {
			out.println("<pre>"+"\t".repeat(count++)+"HttpServletRequest</pre>");
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
			out.println("<pre>"+"\t".repeat(count)+"String: "+(String)object+"</pre>");
			
		}else if(object instanceof String[]) {
			out.println("<pre>"+"\t".repeat(count)+"String[]</pre>");
			for(Object object2:(String[])object) {
				len++;
				check(out,object2,count+1);
			}
			out.println("<pre>"+"\t".repeat(count+1)+"size: "+len+"</pre>");
			
		}else if(object instanceof ArrayList<?>) {
			out.println("<pre>"+"\t".repeat(count)+"ArrayList<?></pre>");
			for(Object object2:(ArrayList<?>)object) {
				len++;
				check(out,object2,count+1);
			}
			out.println("<pre>"+"\t".repeat(count+1)+"size: "+len+"</pre>");
			
		}else if(object instanceof Enumeration<?>) {
			out.println("<pre>"+"\t".repeat(count)+"Enumeration<?></pre>");
			while(((Enumeration<?>)object).hasMoreElements()) {
				len++;
				Object object2 = ((Enumeration<?>)object).nextElement();
				check(out,object2,count+1);
			}
			out.println("<pre>"+"\t".repeat(count+1)+"size: "+len+"</pre>");
		
		}else if(object instanceof Map<?, ?>){
			out.println("<pre>"+"\t".repeat(count)+"Map<?></pre>");
			if(!((Map<?, ?>)object).isEmpty()) {
				for(Object object2:((Map<?, ?>)object).keySet()) {
					check(out,object2,count+1);
					check(out,((Map<?, ?>)object).get(object2),count+1);
					len++;
				}
			}
			out.println("<pre>"+"\t".repeat(count+1)+"size: "+len+"</pre>");
		
		}else if(object instanceof File) {
			out.println("<pre>"+"\t".repeat(count)+"File: "+((File)object).getName()+"</pre>");
			
		}else {
			out.println("<pre>"+"\t".repeat(count)+"can not cast "+object.getClass()+"</pre>");
		}
		//out.println("<pre> </pre>");
	}
}
