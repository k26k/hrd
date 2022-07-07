package innerinterface.button;

public class ButtonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Button button = new Button();
		
//		CallListener 객체를 별도로 생성후 대입
		CallListener callListener = new CallListener();
		button.setListener(callListener);
		button.touch();
		
//		MessageListener 객체를 인스턴스로 생성후 즉시 대입
		button.setListener(new MessageListener());
		button.touch();
		
//		재정의된 객체를 선언해서 인스턴스로 생성후 즉시 대입
		button.setListener(new Button.OnClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("사진을 찍습니다.");
			}
			
		});
		button.touch();
	}

}
