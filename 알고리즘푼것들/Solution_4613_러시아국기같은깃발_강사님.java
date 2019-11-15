import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * DP : 각 단계에서 색상이 될 수 있는 경우를 W, B, R 로 나누어서 변경값의 최적을 구해나간다.
 *
 */
public class Solution_4613_러시아국기같은깃발_강사님 {
	private static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			arr = new int[N][3];

			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < s.length(); j++) {
					if (s.charAt(j) == 'W')
						arr[i][0]++;
					else if (s.charAt(j) == 'B')
						arr[i][1]++;
					else if (s.charAt(j) == 'R')
						arr[i][2]++;
				}
			}
			
			int[][] memo = new int[N][3];
			memo[0][0] = arr[0][1] + arr[0][2]; // 첫번 째 줄을 w만 올 수 있다.
			memo[0][1] = 987654321; // Integer.MAX_VALUE를 하지 않는 이유, + 연산 시에 오버플로우가 발생할 수 있음.
			
			memo[0][2] = 987654321;
			for (int i = 1; i < memo.length; i++) {
				memo[i][0] = memo[i-1][0] + arr[i][1] + arr[i][2];
				memo[i][1] = (memo[i-1][0] <= memo[i-1][1] ? memo[i-1][0] : memo[i-1][1]) + arr[i][0] + arr[i][2];
				memo[i][2] = (memo[i-1][1] <= memo[i-1][2] ? memo[i-1][1] : memo[i-1][2]) + arr[i][0] + arr[i][1];
			}
			
			System.out.println("#" + testCase + " " + memo[N-1][2]);
		}
	} // end of main

	
} // end of class