package ch01;

public class ByteShort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		정수형 자료형 byte와 short
		
//		byte 범위 : -128 ~ 127 (총 개수 256개[8bit])
//		byte bData = -129; 범위를 초과해서 선언하면 오류가 남
		byte bData = -128;
		System.out.println(bData);
		
//		short 범위 : -32768 ~ 32767 (총 개수 65536개[16bit])
//		short sData  = 32768; 범위를 초과해서 선언하면 오류가 남
		short sData  = 32767;
		System.out.println(sData);
		
		
		
	}

}
