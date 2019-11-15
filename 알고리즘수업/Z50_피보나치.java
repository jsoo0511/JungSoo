package 알고리즘수업_Z;
public class Z50_피보나치 {
	public static void main(String[] args) {
		// System.out.println(f(100));
		
		//memo2[0] = 0; // 기본 숫자를 몇개 초기화
		//memo2[1] = 1;
		//System.out.println(f2(100));
		 
		 // 동적 계획법 DP : 작은 해부터 구해서 큰 해를 구한다. 중복연산이 발생 => 메모이제이션으로 해결한다.
		 int[] memo = new int[10];
		 memo[0] = 0;
		 memo[1] = 1;
		 
		 for (int i = 2; i <= 8; i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}
		 System.out.println(memo[8]);
		 
//		 memo[2] = memo[1] + memo[0];
//		 memo[3] = memo[2] + memo[1];
//		 memo[4] = memo[3] + memo[2];
		 
		 
			// 배열을 만들 메모리 공간이 부족할 경우
			int a = 0;
			int b = 1;
			int temp = 0;
			
			for (int i = 2; i <= 8; i++) {
				temp = a + b; // 이전의 2개의 값을 구함
				a = b;
				b = temp;
			}
			
			System.out.println(temp);
		
	} // end of main
	 
	public static int[] memo2 = new int[101]; // 함수의 호출 결과를 저장할 배열
	public static int f2(int n) {
		if(n >= 2 && memo2[n] == 0) {
			memo2[n] = f2(n-1) + f2(n-2);
		}
		return memo2[n];
		
	}
	
	/** 점화식을 재귀 함수로 호출 */
	public static int f(int n) {
		if (n < 2) {
			return n;
		} else {
			return f(n-1) + f(n-2);
		}
		
	}
} // end of class
