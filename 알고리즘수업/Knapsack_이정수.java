package 알고리즘수업_Z;
/**
 * 배낭 문제 Knapsack Fractional : Greedy 물건 여러개, 1개씩 0-1 : 완탐, DP, Backtracking 물건
 * 여러개, 1개씩
 */
public class Knapsack_이정수 {

	public static void main(String[] args) {
		
		// DP 동적 계획법
		int n = 10; // 배낭의 총 무게
		int[][] item = { { 10, 5 }, { 40, 4 }, { 30, 6 }, { 50, 3 } }; // {가격(만원), 무게(kg)}
		int[][] K = new int[item.length + 1][n + 1];
		// 최대 가치 저장 배열
		// 행 : 고려할 물건의 개수, 열 : 배낭의 임시 무게
		// 첫 행(물건을 아무것도 고려하지 않은 경우의 가치), 첫열(배낭의 임시무게가 0kg 일 경우의 가치) 0으로 초기화

		for (int i = 0; i < item.length; i++) { // 물건의 개수만큼 반복
			// 물건의 무게보다 베낭의 무게가 작은 경우는 이전 행의 데이터를 그대로 복사 - 담을 수 없기 떄문에
			for (int w = 0; w < K.length; w++) {
				K[i + 1][w] = K[i][w];
			}
			for (int w = item[i][1]; w <= n; w++) {
				int now = K[i][w - item[i][1]] + item[i][0]; // 1번 물건을 고려한 경우
				int pre = K[i][w]; // 1번 물건을 고려하지 않은 경우
				K[i + 1][w] = now >= pre ? now : pre;
			}
		}
		
		System.out.println(K[item.length][n]);
	}

}
