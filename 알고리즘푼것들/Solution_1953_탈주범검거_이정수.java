import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1953_탈주범검거_이정수 {
	static class Point {
		int tr;
		int tc;

		public Point(int tr, int tc) {
			this.tr = tr;
			this.tc = tc;
		}
	}

	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };
	static int arr[][], n, m, r, c, l, cnt;
	static boolean visited[][];
	static Queue<Point> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int test = 1; test <= tc; test++) {
			String s[] = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);// 가로
			m = Integer.parseInt(s[1]);// 세로
			r = Integer.parseInt(s[2]);// 맨홀 행 위치
			c = Integer.parseInt(s[3]);// 맨홀 열 위치
			l = Integer.parseInt(s[4]);// 탈주 후 경과된 시간
			arr = new int[n][m];
			visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				String str[] = br.readLine().split(" ");
				for (int j = 0; j < m; j++) {
					arr[i][j] = Integer.parseInt(str[j]);
				}
			}
			q = new LinkedList<Point>();
			cnt = 0;
			bfs(r, c);// 맨홀부터 시작
			System.out.println("#" + test + " " + cnt);
		}
	}

	public static void bfs(int row, int col) {
		q.add(new Point(row, col));
		visited[row][col] = true;
		cnt++;

		if (l == 1)//시간이 1이면 맨홀밖에 못감 바로 탈출
			return;
		int turn = 1;
		int size = q.size();
		while (!q.isEmpty()) {
			size = q.size();
			turn++;

			while (size-- > 0) {
				Point p = q.poll();
				int tempr;
				int tempc;
				if (arr[p.tr][p.tc] == 1) {// 사방으로 갈 수 있는 경우
					for (int i = 0; i < 4; i++) {
						tempr = p.tr + dr[i];
						tempc = p.tc + dc[i];
						if (i == 3) {// 위로 가는 경우
							if (isRange(tempr, tempc) && !visited[tempr][tempc] && (arr[tempr][tempc] == 1
									|| arr[tempr][tempc] == 2 || arr[tempr][tempc] == 5 || arr[tempr][tempc] == 6)) {
								q.add(new Point(tempr, tempc));
								visited[tempr][tempc] = true;
								cnt++;
							}
						} else if (i == 0) { // 우로가는 경우
							if (isRange(tempr, tempc) && !visited[tempr][tempc] && (arr[tempr][tempc] == 1
									|| arr[tempr][tempc] == 3 || arr[tempr][tempc] == 6 || arr[tempr][tempc] == 7)) {
								q.add(new Point(tempr, tempc));
								visited[tempr][tempc] = true;
								cnt++;
							}
						} else if (i == 1) { // 아래로가는 경우
							if (isRange(tempr, tempc) && !visited[tempr][tempc] && (arr[tempr][tempc] == 1
									|| arr[tempr][tempc] == 2 || arr[tempr][tempc] == 4 || arr[tempr][tempc] == 7)) {
								q.add(new Point(tempr, tempc));
								visited[tempr][tempc] = true;
								cnt++;
							}
						} else { // 좌로 가는 경우
							if (isRange(tempr, tempc) && !visited[tempr][tempc] && (arr[tempr][tempc] == 1
									|| arr[tempr][tempc] == 3 || arr[tempr][tempc] == 4 || arr[tempr][tempc] == 5)) {
								q.add(new Point(tempr, tempc));
								visited[tempr][tempc] = true;
								cnt++;
							}
						}

					}
				} else if (arr[p.tr][p.tc] == 2) {
					for (int i = 0; i < 4; i++) {
						if (i == 0 || i == 2)
							continue;
						tempr = p.tr + dr[i];
						tempc = p.tc + dc[i];
						if (i == 3) {// 위로 가는 경우
							if (isRange(tempr, tempc) && !visited[tempr][tempc] && (arr[tempr][tempc] == 1
									|| arr[tempr][tempc] == 2 || arr[tempr][tempc] == 5 || arr[tempr][tempc] == 6)) {
								q.add(new Point(tempr, tempc));
								visited[tempr][tempc] = true;
								cnt++;
							}
						} else if (i == 1) { // 아래로가는 경우
							if (isRange(tempr, tempc) && !visited[tempr][tempc] && (arr[tempr][tempc] == 1
									|| arr[tempr][tempc] == 2 || arr[tempr][tempc] == 4 || arr[tempr][tempc] == 7)) {
								q.add(new Point(tempr, tempc));
								visited[tempr][tempc] = true;
								cnt++;
							}
						}
					}
				} else if (arr[p.tr][p.tc] == 3) {
					for (int i = 0; i < 4; i++) {
						if (i == 1 || i == 3)
							continue;
						tempr = p.tr + dr[i];
						tempc = p.tc + dc[i];
						if (i == 0) { // 우로가는 경우
							if (isRange(tempr, tempc) && !visited[tempr][tempc] && (arr[tempr][tempc] == 1
									|| arr[tempr][tempc] == 3 || arr[tempr][tempc] == 6 || arr[tempr][tempc] == 7)) {
								q.add(new Point(tempr, tempc));
								visited[tempr][tempc] = true;
								cnt++;
							}
						} else { // 좌로 가는 경우
							if (isRange(tempr, tempc) && !visited[tempr][tempc] && (arr[tempr][tempc] == 1
									|| arr[tempr][tempc] == 3 || arr[tempr][tempc] == 4 || arr[tempr][tempc] == 5)) {
								q.add(new Point(tempr, tempc));
								visited[tempr][tempc] = true;
								cnt++;
							}
						}
					}
				} else if (arr[p.tr][p.tc] == 4) {
					for (int i = 0; i < 4; i++) {
						if (i == 1 || i == 2)
							continue;
						tempr = p.tr + dr[i];
						tempc = p.tc + dc[i];
						if (i == 3) {// 위로 가는 경우
							if (isRange(tempr, tempc) && !visited[tempr][tempc] && (arr[tempr][tempc] == 1
									|| arr[tempr][tempc] == 2 || arr[tempr][tempc] == 5 || arr[tempr][tempc] == 6)) {
								q.add(new Point(tempr, tempc));
								visited[tempr][tempc] = true;
								cnt++;
							}
						} else if (i == 0) { // 우로가는 경우
							if (isRange(tempr, tempc) && !visited[tempr][tempc] && (arr[tempr][tempc] == 1
									|| arr[tempr][tempc] == 3 || arr[tempr][tempc] == 6 || arr[tempr][tempc] == 7)) {
								q.add(new Point(tempr, tempc));
								visited[tempr][tempc] = true;
								cnt++;
							}
						}
					}
				} else if (arr[p.tr][p.tc] == 5) {
					for (int i = 0; i < 4; i++) {
						if (i == 2 || i == 3)
							continue;
						tempr = p.tr + dr[i];
						tempc = p.tc + dc[i];
						if (i == 0) { // 우로가는 경우
							if (isRange(tempr, tempc) && !visited[tempr][tempc] && (arr[tempr][tempc] == 1
									|| arr[tempr][tempc] == 3 || arr[tempr][tempc] == 6 || arr[tempr][tempc] == 7)) {
								q.add(new Point(tempr, tempc));
								visited[tempr][tempc] = true;
								cnt++;
							}
						} else if (i == 1) { // 아래로가는 경우
							if (isRange(tempr, tempc) && !visited[tempr][tempc] && (arr[tempr][tempc] == 1
									|| arr[tempr][tempc] == 2 || arr[tempr][tempc] == 4 || arr[tempr][tempc] == 7)) {
								q.add(new Point(tempr, tempc));
								visited[tempr][tempc] = true;
								cnt++;
							}
						}
					}
				} else if (arr[p.tr][p.tc] == 6) {
					for (int i = 0; i < 4; i++) {
						if (i == 0 || i == 3)
							continue;
						tempr = p.tr + dr[i];
						tempc = p.tc + dc[i];
						if (i == 1) { // 아래로가는 경우
							if (isRange(tempr, tempc) && !visited[tempr][tempc] && (arr[tempr][tempc] == 1
									|| arr[tempr][tempc] == 2 || arr[tempr][tempc] == 4 || arr[tempr][tempc] == 7)) {
								q.add(new Point(tempr, tempc));
								visited[tempr][tempc] = true;
								cnt++;
							}
						} else { // 좌로 가는 경우
							if (isRange(tempr, tempc) && !visited[tempr][tempc] && (arr[tempr][tempc] == 1
									|| arr[tempr][tempc] == 3 || arr[tempr][tempc] == 4 || arr[tempr][tempc] == 5)) {
								q.add(new Point(tempr, tempc));
								visited[tempr][tempc] = true;
								cnt++;
							}
						}
					}
				} else {
					for (int i = 0; i < 4; i++) {
						if (i == 0 || i == 1)
							continue;
						tempr = p.tr + dr[i];
						tempc = p.tc + dc[i];
						if (i == 3) {// 위로 가는 경우
							if (isRange(tempr, tempc) && !visited[tempr][tempc] && (arr[tempr][tempc] == 1
									|| arr[tempr][tempc] == 2 || arr[tempr][tempc] == 5 || arr[tempr][tempc] == 6)) {
								q.add(new Point(tempr, tempc));
								visited[tempr][tempc] = true;
								cnt++;
							}
						} else { // 좌로 가는 경우
							if (isRange(tempr, tempc) && !visited[tempr][tempc] && (arr[tempr][tempc] == 1
									|| arr[tempr][tempc] == 3 || arr[tempr][tempc] == 4 || arr[tempr][tempc] == 5)) {
								q.add(new Point(tempr, tempc));
								visited[tempr][tempc] = true;
								cnt++;
							}
						}
					}
				}
			}
			if (turn == l)// 탈주 시간되면 탈출
				break;
		}
	}

	public static boolean isRange(int row, int col) {
		if (row >= 0 && row < n && col >= 0 && col < m)
			return true;
		else
			return false;
	}

}
