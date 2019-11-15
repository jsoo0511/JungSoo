import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_4485_젤다_강사님 {
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int testCase = 1;; testCase++) {
			int N = Integer.parseInt(br.readLine()); // 동굴의 크기
			if (N == 0)
				break;
			int[][] m = new int[N][N];
			int[][] memo = new int[N][N]; // 0,0 ~ r,c 까지의 최소비용을 저장할 배열
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0, index = 0; j < N; j++, index += 2) {
					m[i][j] = str.charAt(index) - '0';
					memo[i][j] = Integer.MAX_VALUE;
				}
			}

//			Queue<int[]> q = new LinkedList<int[]>();
			PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o1[2] - o2[2];
				}
			});
			memo[0][0] = m[0][0];
			q.add(new int[] { 0, 0, memo[0][0] });

			while (!q.isEmpty()) {
				// 큐에서 값 꺼내기
				int[] data = q.poll();
				int r = data[0];
				int c = data[1];
				int cost = data[2]; //

				// 꺼낸 정점에서 인접한 정점들을 방문
				for (int i = 0; i < dr.length; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (0 <= nr && 0 <= nc && nc < N && nr < N && memo[nr][nc] > memo[r][c] + m[nr][nc]) {
						memo[nr][nc] = memo[r][c] + m[nr][nc];
						q.add(new int[] { nr, nc, memo[nr][nc] });
					}
				}
			}
			System.out.println("Problem " + testCase + ": " +memo[N-1][N-1]);
		}

	} // end of main
} // end of class