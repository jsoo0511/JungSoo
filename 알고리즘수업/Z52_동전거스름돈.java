package 알고리즘수업_Z;
import java.util.Arrays;

/**
 * 동적 계획법 DP (교재처럼 2차원 배열 사용)
 * @author student
 *
 */
public class Z52_동전거스름돈 {
	public static void main(String[] args) {
		// 2차원 배열
		System.out.println(f(8));
		// 1차원 배열
		System.out.println(f2(8));
		// 동전이 1이 아닐 때
		System.out.println(f3(8));
		// 동전 배열이 변할 때!!
		System.out.println(f4(8));
	} // end of main
	

	public static int f4(int n) {
		int [] C = new int[n+1]; // 동전 거스름돈의 최소 개수(최적의 해)를 저장할 배열
		int [] D = {3,4,6}; // 동전의 종류
		final int M = Integer.MAX_VALUE; // 거슬러주지 못하는 경우 M으로 표현
		
		// 첫번째 동전만 고려
		for (int i = 0; i <= n; i++) {
			if(i%D[0] == 0) { // 거슬러 줄 수 있음
				C[i] = i/D[0];
			} else { // 거슬러 줄 수 없음
				C[i] = M;
			}
		}
		
		for (int k = 1; k < D.length; k++) { // 동전의 종류 만큼 반복
			for (int i = D[k]; i <= n; i++) {
				if(C[i-D[k]] != M && C[i] > C[i-D[k]] + 1) {
					C[i] = C[i-D[k]] + 1;
				}
			}
		}
	
		
		System.out.println(Arrays.toString(C));
		
		return C[n] == M ? -1 : C[n]; // 이따가 바꿈
	}
	
	
	
	public static int f3(int n) {
		int [] C = new int[n+1]; // 동전 거스름돈의 최소 개수(최적의 해)를 저장할 배열
		
		
		// 3,4,6원 이라면? 1원짜리가 없는 경우!!(거슬러 줄 수 없을 때)
// 		0 1 2 3 4 5 6 7 8 9
// 		0 x x 1 x x 2 x x 3
		
		final int M = Integer.MAX_VALUE; // 거슬러주지 못하는 경우 M으로 표현
		for (int i = 0; i < C.length; i++) {
			if(i % 3 == 0) { // 거슬러 줄 수 있음
				C[i] = i/3;
			} else { // 거슬러 줄 수 없음
				C[i] = M;
			}
		}
		System.out.println(Arrays.toString(C));
		// 3, 4원 동전만 고려
		for (int i = 4; i <= n; i++) {
			
			// C[i] = min (C[i], C[i-4] + 1);
//							M 	M  기존값을 그대로 놓기
//							notM M  기존값을 그대로 놓기
//							M 	notM  업데이트 작은 값으로
//							notM notM 업데이트 작은 값으로
			if(C[i-4] != M && C[i] > C[i-4] + 1) {
				C[i] = C[i-4] + 1;
			}
		}
		System.out.println(Arrays.toString(C));
		// 3, 4, 6원 동전만 고려
		for (int i = 6; i <= n; i++) {
			
			// C[i] = min (C[i], C[i-4] + 1);
//							M 	M  기존값을 그대로 놓기
//							notM M  기존값을 그대로 놓기
//							M 	notM  업데이트 작은 값으로
//							notM notM 업데이트 작은 값으로
			if(C[i-6] != M && C[i] > C[i-6] + 1) {
				C[i] = C[i-6] + 1;
			}
		}
		
		System.out.println(Arrays.toString(C));
		
		return C[n] == M ? -1 : C[n]; // 이따가 바꿈
	}
	
	
	/** (더 효율적 : 메모리 절약, 연산(복사하는 작업)) 1차원 배열을 사용하여 동전의 개수의 최소 개수를 리턴 */
	public static int f2(int n) {
		int [] C = new int[n+1]; // 동전 거스름돈의 최소 개수(최적의 해)를 저장할 배열
		
	
		
		// 1원동전만 고려
		for (int i = 1; i <= n; i++) {
			C[i] = i;
			
		}
		System.out.println(Arrays.toString(C));
		
		// 1, 4원 동전만 고려
		for (int i = 4; i <= n; i++) {
			if(C[i] > C[i-4] + 1) {
				C[i] = C[i-4] + 1;
			}
		}
		
		System.out.println(Arrays.toString(C));
		
		// 1, 4, 6원 동전만 고려
		for (int i = 6; i <= n; i++) {
			if(C[i] > C[i-6] + 1) {
				C[i] = C[i-6] + 1;
			}
		}
	
		System.out.println(Arrays.toString(C));
		
		return C[n]; // 마지막 칸을 바꿈

	}
	
	
	
	
	/** (교재처럼) 2차원 배열을 사용하여 동전의 개수의 최소 개수를 리턴 */
	public static int f(int n) {
		int[][] C = new int[3][n+1]; // 동전 거스름돈의 최소 개수(최적의 해)
		
		
		// 1원 동전만 고려
		for (int i = 0; i <= n; i++) {
			C[0][i] = i;
		}
		
		// 1,4원 동전 고려
		for (int i = 0; i <= n; i++) {
			if(i < 4 || C[0][i] < C[1][i-4] + 1) { // 거스름돈이 동전금액보다 작은 경우
				C[1][i] = C[0][i]; // 이전에서 가져 옴
			} else {
				// C[1][i-4] + 1 / C[0][i] 중의 최소값을 저장
				C[1][i] = C[1][i-4] + 1; // 4원 동전을 고려했을 때 최적이면 반영
				
			}
		}
		
		// 1,4,6 동전 고려
		for (int i = 0; i <= n; i++) {
			if(i < 6 || C[1][i] < C[2][i-6] + 1) { // 거스름돈이 동전금액보다 작은 경우
				C[2][i] = C[1][i]; // 이전에서 가져 옴
			} else {
				// C[1][i-6] + 1 / C[0][i] 중의 최소값을 저장
				C[2][i] = C[2][i-6] + 1; // 4원 동전을 고려했을 때 최적이면 반영
				
			}
		}
		
		for (int i = 0; i < C.length; i++) {
			System.out.println(Arrays.toString(C[i]));
		}
		
		return C[2][n]; // 최적해를 return
	}
}
