package loopExample;

public class SumTo10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		int num =0;
		while(i<=10) {
			num+=i;
			i++;
		}
		System.out.println(num);
		
		i = 1;
		num = 0;
		while(true) {
			num+=i;
			i++;
			if(10<i) {
				break;
			}
		}
		System.out.println(num);
	}

}
