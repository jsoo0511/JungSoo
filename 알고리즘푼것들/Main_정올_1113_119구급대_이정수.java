import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_정올_1113_119구급대_이정수 {
	static class Point {
		int r;
		int c;
		int val;
		int cnt;

		public Point(int r, int c, int val) {
			this.r = r;
			this.c = c;
			this.val = val;
		}

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public Point(int r, int c, int val, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.val = val;
			this.cnt = cnt;
		}

	}

	static int arr[][], copy[][];
	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };
	static int n, m, des_r, des_c, cnt, min;
	static boolean visited[][];
	static Queue<Point> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		String des[] = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		arr = new int[n][m];
		copy = new int[n][m];
		visited = new boolean[n][m];
		des_r = Integer.parseInt(des[0]);
		des_c = Integer.parseInt(des[1]);
		q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String str[] = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
				
				if (arr[i][j] == 0)// 벽은 방문
					visited[i][j] = true;
			}
		}

		min = Integer.MAX_VALUE;
		cnt = 0;
		bfs(0, 0);
		System.out.println();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(copy[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(copy[des_r][des_c]-1);

	}

	public static void bfs(int r, int c) {

		q.add(new Point(0, 0, 100, 0));
		visited[0][0] = true;
		while (!q.isEmpty()) {
			int row = q.peek().r;
			int col = q.peek().c;
			int value = q.peek().val; // 방향
			int count = q.poll().cnt; // 꺾은수
			System.out.println(row+", "+col+" 탐색");

			for (int i = 0; i < 4; i++) {
				
				int tempr = row + dr[i];
				int tempc = col + dc[i];

				if (tempr >= 0 && tempr < n && tempc >= 0 && tempc < m) {

					if (!visited[tempr][tempc]) {// 방문하지 않았다면
						if (value != i) { // 꺾는다면
							if (tempr == des_r && tempc == des_c) {
								System.out.println(tempr + " , " + tempc + " 꺾어서 도착: " + (count + 1));
								cnt = count + 1;
								if (min > cnt)
									min = cnt;
							}
							visited[tempr][tempc] = true;
							q.add(new Point(tempr, tempc, i, count + 1));
							if(count>copy[tempr][tempc] && copy[tempr][tempc]!=0) {
								
							}
							copy[tempr][tempc] = count + 1;
							// cnt++;
							System.out.println(tempr + " , " + tempc + " 방향: " + i + ", 꺽은 수: " + (count + 1));
							System.out.println(copy[tempr][tempc]);
						} else {//안꺾는다면
							if (tempr == des_r && tempc == des_c) {// 목적지 가는 길에 도착
								System.out.println(tempr + " , " + tempc + " 가는길에 도착: ," + "꺽은 수: " + count);
								cnt = count;
								if (min > cnt)
									min = cnt;
							}
							visited[tempr][tempc] = true;
							copy[tempr][tempc] = count;
							System.out.println(tempr + " , " + tempc + " 방향: " + i + ", 꺽은 수: " + (count));
							System.out.println(copy[tempr][tempc]);
							q.add(new Point(tempr, tempc, i, count));
						}
					} else {// 방문했다면
						if (value != i && arr[tempr][tempc]!=0) {
							if(count+1<copy[tempr][tempc]) {
								copy[tempr][tempc]=count+1;
								System.out.println(tempr+", "+tempc+"수 변화");
								System.out.println(copy[tempr][tempc]);
							}
							
							

						} else if(value==i) {
							if(count<copy[tempr][tempc]) {
								copy[tempr][tempc]=count;
								System.out.println(tempr+", "+tempc+"수 변화");
								System.out.println(copy[tempr][tempc]);
							} 
						}

					}


				}
			}
		}

	}

}
