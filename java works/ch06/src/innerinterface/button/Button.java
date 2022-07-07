package innerinterface.button;

public class Button {
	
	OnClickListener listener; // 인터페이스형 필드
	
	public void setListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	public OnClickListener getListener() {
		return listener;
	}
	
	public void touch() {
		listener.onClick();
	}
	
	
//	내부 인터페이스
	static interface OnClickListener{
//		추상 메소드
		public void onClick();
		
	}
}
