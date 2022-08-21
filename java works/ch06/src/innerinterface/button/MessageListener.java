package innerinterface.button;

public class MessageListener implements Button.OnClickListener{ // Button 클래스 내부의 인터페이스에 접근

	@Override
	public void onClick() {
		System.out.println("문자를 보냅니다");
	}

}
