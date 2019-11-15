import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Z17_Calculator {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int []s=new int[9];
		int top=-1;
		
		String[] str=sc.nextLine().split(" ");
		s[++top]=Integer.parseInt(str[0]); //첫번째 피연산자
	
		for(int i=1;i<str.length;i+=2) {//연산자, 피연산자
			char op=str[i].charAt(0);//연산자
			int num=Integer.parseInt(str[i+1]);//숫자
			if(op=='+') { //숫자는 스택에 넣기
				s[++top]=num;
			}else {//"*"스택에서 숫자 꺼내서 곱셈후, 숫자를 스택에 넣기
				int pre=s[top--];
				s[++top]=pre*num;
			}
		}
		
		int result=0;
		for(int i=0;i<=top;i++) {
			result+=s[i];
		}
		System.out.println(result);
	}//end main

}//end class
