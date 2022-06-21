package ch01;

public class TypeConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		묵시적 형변환
//		더 큰 자료형에 변수를 넣을때 변수형이 변함
		int iNum = 20;
		float fNum = iNum;
		System.out.println(iNum);
		System.out.println(fNum);
		
		double dNum;
		dNum = iNum + fNum;
		System.out.println(dNum);
		
//		명시적 형변환
//		특정 자료형을 지정해서 변수형을 변형함
		double dNum2 = 1.2;
		float fNum2 = 0.9F;
//		int iNum2 = dNum2+fNum2; int가 작아서 묵시적 형변환이 되지않음
		int iNum2 = (int)dNum2 + (int)fNum2; // int로 전환하는 과정에서 int로 표시할수 없는 소수점 부분은 버려짐 1+0이됨
		System.out.println(iNum2);
		
		int iNum3 = (int)(dNum2+fNum2);// 1.2+0.9 후 int로 변환됨 2.1에서 소수점 이하 부분이 버려짐
		System.out.println(iNum3);
		
	}

}
