package 알고리즘수업_Z;
/**
 * 동적 계획법 : 점화식을 찾기, 작은해부터 구해서 작은해를 기반으로 큰 해를 찾는다
 */
public class Z51_막대기 {
	public static void main(String[] args) {
		int[] memo = new int[100];
		memo[1] = 2;
		memo[2] = 5;
		for (int i = 3; i <= 6; i++) {
			memo[i] = memo[i-1] * 2 + memo[i-2];
		}
		
		System.out.println(memo[100]);
		

		
	} // end of main
} // end of class
