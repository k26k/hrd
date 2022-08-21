package test9_1;

public class Chatting {
	
	void startChat(String chatId) {
	
//		수정 불가, 변수가 상수화됨
//		String nickName = null;
//		nickName = chatId;
		
		String nickName = chatId;

		class Chat{
			
			public void start() {
				
				while(true) {

					String inputData = "ㅎㅇ";
					String message = "["+nickName+"]"+inputData;
					sendMessage(message);
				
				}
				
			}
			
			void sendMessage(String message) {
				System.out.println(message);
			}
			
		}
		
		Chat chat = new Chat();
		chat.start();
		
	}

}
