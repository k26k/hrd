package com.cloud.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class CommentSet {

	private List<String> commentList = new ArrayList<>();
	
	public void addComment(String comment) {
		commentList.add(comment);
		log.info(commentList);
	}
	
	public List<String> getAllComment() {
		return commentList;
	}
	
	public String getAllCommentToHTML() {
		StringBuffer sb = new StringBuffer();
		boolean first = true;
		sb.append("[");
		for(String s:commentList) {
//			sb.append("<div class=\'input-group-text\'>"+s+"</div>");
			if(first) {
				first=false;
				sb.append("\""+s+"\"");
			}else {
				sb.append(",\""+s+"\"");
			}
			
		}
		sb.append("]");
		log.info(sb.toString());
		return sb.toString();
	}
	
}
