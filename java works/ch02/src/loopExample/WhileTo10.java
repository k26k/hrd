package loopExample;

public class WhileTo10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		while(i<=10) {
			System.out.println(i);
			i++;
		}
		
		System.out.println("========");
		
		i = 1;
		while(true) {
			System.out.println(i);
			i++;
			if(10<i) {
				break;
			}
		}
	}

}
