package 알고리즘수업_Z;
import java.util.Arrays;

/**
 * 
 * Subset : 부분 집합
 * {1, 2}의 Subset은
 * 	{{},{1},{2},{1,2}}
 * 
 * 	Subset을 구하는 방법
 *  1. 반복문 : 단, 원소의 개수가 많아질수록 시간복잡도가 끝없이 늘어남. 소스코드를 동적으로 변경할 수 없다.
 *  2. 바이너리 카운팅 : 단, 자료형의 한계를 넘어서는 순간 원소의 개수에 제한이 있음.
 *  3. 재귀함수 
 */
public class Z07_Subset {
	public static void main(String[] args) {
		
		// 부분집합 생성하기
		int[] arr = {6, 7, 8};
		
		// 1. 반복문
		
		for (int i = 0; i < 2; i++) { // 첫번째 원소를 사용할 지의 여부
			for (int j = 0; j < 2; j++) { // 두번째 원소 
				for (int k = 0; k < 2; k++) { // 세번째 원소
				//	System.out.println(i + " , " + j + " , "  + k);
					System.out.println(i == 1 ? arr[0] + " " : " ");
					System.out.println(j == 1 ? arr[1] + " " : " ");
					System.out.println(k == 1 ? arr[2] + " " : " ");
					System.out.println();
				}
				
			}
		}
				
		
		// 정수의 진법 표현
		System.out.println(1234);  // 10진수                 0~9
		System.out.println(0b110); // 2진수 0b or 0B  0~1
		System.out.println(0123);  // 8진수 0         0~7
		System.out.println(0x123); // 16진수 0x or 0X 0~9, A~F
		
		System.out.println(100);   							// 10진수 100
		System.out.println(Integer.toBinaryString(100));    // 2진수  
		System.out.println(Integer.toString(100, 2));
		
		// shift 연산 : << = *2, >> = /2
		System.out.println(1 << 2); // 1-> 4
		System.out.println("1 << 0 : " + (1<<0) + " "+Integer.toBinaryString(1<<0));
		System.out.println("1 << 1 : " + (1<<1) + " "+Integer.toBinaryString(1<<1));
		System.out.println("1 << 2 : " + (1<<2) + " "+Integer.toBinaryString(1<<2));
		System.out.println("1 << 3 : " + (1<<3) + " "+Integer.toBinaryString(1<<3));
		System.out.println("1 << 4 : " + (1<<4) + " "+Integer.toBinaryString(1<<4));
		System.out.println("1 << 5 : " + (1<<5) + " "+Integer.toBinaryString(1<<5));
		
		// 비트 마스킹 Bit Masking
		int n = 0b100110111;
		System.out.println((n & 0b1) == 0 ? 0 : 1);
		System.out.println((n & 0b10) == 0 ? 0 : 1);
		System.out.println((n & 0b100) == 0 ? 0 : 1);
		System.out.println((n & 0b1000) == 0 ? 0 : 1);
		System.out.println((n & 0b10000) == 0 ? 0 : 1);
		System.out.println((n & 0b100000) == 0 ? 0 : 1);
		System.out.println((n & 0b1000000) == 0 ? 0 : 1);
		System.out.println((n & 0b10000000) == 0 ? 0 : 1);
		System.out.println((n & 0b100000000) == 0 ? 0 : 1);
		System.out.println((n & 0b1000000000) == 0 ? 0 : 1);
		
		// 반복문 비트마스킹		
		for (int i = 0; i < 9; i++) {
			System.out.println((n & 0b10) == 0 ? 0 : 1);
		}
		System.out.println();
		
		// 2. 바이너리 카운팅 : 부분집합을 모아둔 PowerSet을 구해보자
		// 부분집합의 개수, 비트마스킹, 쉬프트 연산자
		int[] brr = {-7, -3, -2,5 ,8};
		for (int i = 0; i < (1 << brr.length); i++) {
			for (int j = 0; j < brr.length; j++) {
				if((i & (1 << j)) != 0) {
					System.out.print(brr[j] + " ");
				}
			}
			System.out.println();
		}		
		
		// 재귀함수 연습
		// ! 팩토리얼
		int v = 1;
		for (int i = 1; i <= 4; i++) {
			v *= i;
		}
		System.out.println(v);
		
		a(4); // 재귀함수로 팩토리얼 구현
		System.out.println();
		// 1 2 3 4 5 출력
		for (int i = 1; i <= 5; i++) {
			System.out.print(i + " ");
		}
		
		b(1); // 시작 값으로 보내기
		
		// 0 2 4 6 8
		// 5 4 3 2 1
		
		for (int i = 0; i < 10; i++) {
			if(i%2 == 0)
				System.out.print(i + " ");
		}
		
		c(0); // 0 2 4 6 8 재귀함수 출력
		
		System.out.println();
		
		for (int i = 5; i > 0; i--) {
			System.out.print(i + " ");
		}
		
		d(5); // 5 4 3 2 1 재귀함수 출력
		
		// 2 5 8 11
		e(2, 12, 3);
		// 3. 재귀함수로 모든 부분집합(powerSet)을 구해보자.
		f(0);
		
		
	} // end of main
	
	// Factorial Pratice
	public static int a(int n) {
		if(n<=1) { // 종료파트
			return 1;
		} 
		else { // 재귀파트
			return n * a(n-1);
		}
	}
	
	// 1 2 3 4 5 출력
	public static void b(int n) {
		if(n>5) {
			System.out.println();
		}
		else {
			System.out.println(n++ + " ");
			b(n);
		}
	}
	
	// 0 2 4 6 8 출력
	public static void c(int n) {
		if(n > 8) {
			System.out.println();
		}
		else {
			System.out.print(n + " ");
			c(n + 2);
		}
	}
	
	// 5 4 3 2 1 출력
	public static void d(int n) {
		if(n < 1) {
			System.out.println();
		}else {
			System.out.print(n + " ");
			d(n-1);
		}
	}
	
	// 2 5 8 11
	public static void e(int start, int end, int step) {
		if(start >= end) {
			System.out.println();
		}
		else {
			System.out.print(start + " ");
			e(start+step, end, step);
		}
	}
	
	// 3. 재귀함수
	public static int[] crr = {-7, -3, -2, 5, 8};
	//** 매개변수 n번째 인덱스의 배열값을 사용할 지 여부를 지정 후 재귀호출, 마지막에 bit배열을 보고 출력
	public static boolean[] bit = new boolean[crr.length]; // 각 원소를 사용할 지 여부를 판단할 배열
	/*public static void f(int n) {
		if(n == crr.length) { // 종료파트 : bit 배열의 내용을 보고, crr ㅂㅐ열의 원소를 출력
			System.out.println(Arrays.toString(bit));
			for (int i = 0; i < bit.length; i++) {
				System.out.print(bit[i] == true ? crr[i]+" ":" ");
			}
		}
		else { // 재귀파트 : bit 배열의 각 원소를 채우기
			bit[n] = false; // n 번째를 false..
			f(n+1);
			bit[n] = true;
			f(n+1);
		}
	}*/
	public static void f(int n) {
		if(n == crr.length) { // 종료파트 : bit 배열의 내용을 보고, crr ㅂㅐ열의 원소를 출력
			int sum = 0;
			for (int i = 0; i < bit.length; i++) {
				if(bit[i]) sum += crr[i];
//				System.out.println(sum-);
			}
		if( sum == 0) {
			for (int i = 0; i < bit.length; i++) {
				System.out.println(bit[i] ? crr[i] + " " : "");
			}
			System.out.println();
		}
		}
		else { // 재귀파트 : bit 배열의 각 원소를 채우기
			bit[n] = false; // n 번째를 false..
			f(n+1);
			bit[n] = true;
			f(n+1);
		}
	}
} // end of class
