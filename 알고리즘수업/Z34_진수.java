package 알고리즘수업_Z;

import java.util.ArrayList;
import java.util.Stack;

public class Z34_진수 {

	public static void main(String[] args) {
		//311을 2진수로 표현(내 방법)
		int binary=0b100110111;//311을 2진수로 저장해주세요
		Stack<Integer> st=new Stack<>();

		int n;
		int result=311;
		while(result!=1 &&result!=0) {
			n=result%2;
			result=result/2;
			st.push(n);
		}
		st.push(result);//마지막 남은 값 삽입
		System.out.print("311이진수: ");
		while(!st.isEmpty()) {
		    System.out.print(st.pop());
		}
		
		System.out.println();
		
		//저장한 2진수의 값 311을 10진수로 출력하기
		System.out.print("100110111을 10진수로 변환: ");
		System.out.println(binary);
		
		//311을 x진수로 표현(쌤 방법)
		int num=311;
		int x=2;
		String s="";//x진법으로 변환한 문자를 저장
		
		while(num>0) {
			s=num%x + s;//마지막에 구한 문자가 msb가 되도록
			num/=x;
		}
		
		System.out.println(s+ " ("+x+"진수)");
		
		//num을 x진법으로 표현하는 방법을 구현해보기 2;
		num=311;
		s="";
		s=Integer.toString(num,x);
		System.out.println(s+ " ("+x+"진수)");
		
	}

}
