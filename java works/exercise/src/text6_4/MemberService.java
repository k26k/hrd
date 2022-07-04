package text6_4;

public class MemberService {
	
	private String id = "hong";
	private String pw = "12345";
	
	public boolean login(String id, String pw) {
		if(id.equals(this.id) && pw.equals(this.pw)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void logout(String id) {
		if(id.equals(this.id)) {
			System.out.println("로그아웃 되었습니다.");
		}
	}
	
	
}
