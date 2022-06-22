package operator;

public class BitOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		비트 논리 연산
		int num1 = 5; // 00000101
		int num2 = 10; //00001010
		int result;
		
//		비트 논리 곱
		result = num1 & num2; // 00000000
		System.out.println(result); // 0
		
//		비트 논리 합
		result = num1 | num2; // 00001111
		System.out.println(result); // 15
		
//		비트 이동 연산
		int val = 2; // 00000010
		System.out.println(val>>1); // 00000001 = 1
		System.out.println(val<<1); // 00000100 = 4
		
//		2진수, 16진수 표기
		int n = 10;
		int bNum = 0b1010;
		int hNum = 0x000a;
		System.out.println(n);
		System.out.println(bNum);
		System.out.println(hNum);
	}

}
