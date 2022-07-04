package text6_4;

public class MemberServiceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberService memberService = new MemberService();
		boolean result = memberService.login("hong","12345");
		
		if(result) {
			System.out.println("로그인 성공");
			memberService.logout("hong");
		}else {
			System.out.println("id 또는 pw 오류");
		}
		
	}

}
