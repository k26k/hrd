package builtinclass;

public class MathRandomEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		주사위 10번 던지기
		System.out.println("// 주사위 던지기 10번 //");
		for(int i=0; i<10; i++) {
			int dice = (int)(Math.random()*6+1);
			System.out.print(dice+" ");
		}
		
		System.out.println("\n");
		
		System.out.println("// 문자열 랜덤 출력 10번 //");
		String[] words = {"너", "나", "우리", "우주"}; 
		for(int i=0;i<10;i++) {
			int num = (int)(Math.random()*words.length);
			System.out.print(words[num]+" ");
		}
		
		System.out.println("\n");
	}

}
