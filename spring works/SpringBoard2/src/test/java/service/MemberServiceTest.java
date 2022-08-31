package service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cloud.domain.MemberVO;
import com.cloud.mapper.MemberMapper;
import com.cloud.service.BoardService;
import com.cloud.service.MemberService;

import lombok.extern.log4j.Log4j;

@Log4j
public class MemberServiceTest {

	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void getMember() {
		log.info(memberService);
		log.info(memberMapper);
		MemberVO memberVO = memberService.getMember("user00");
		log.info(memberVO);
	}
}
