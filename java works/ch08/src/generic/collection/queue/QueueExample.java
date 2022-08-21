package generic.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		
		Queue<Message> messagesQueue = new LinkedList<Message>();
		
		messagesQueue.offer(new Message("sendMail", "홍길동"));
		messagesQueue.offer(new Message("sendSMS", "신용권"));
		messagesQueue.offer(new Message("sendKakaotalk", "홍두께"));
		
		while(!messagesQueue.isEmpty()) {
			Message message = messagesQueue.poll();
			
			switch(message.command) {
				case "sendMail":
					System.out.println(message.to+"님에게 메일을 보냅니다.");
					break;
				case "sendSMS":
					System.out.println(message.to+"님에게 SNS를 보냅니다.");
					break;
				case "sendKakaotalk":
					System.out.println(message.to+"님에게 카카오톡을 보냅니다.");
					break;
				default:
					System.out.println("[error] "+message.command+" , "+message.to);
					break;
			}
		}
		
	}
	
}
