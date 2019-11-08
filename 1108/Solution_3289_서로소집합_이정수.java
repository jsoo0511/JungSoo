import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_3289_서로소집합_이정수 {
	static int rank[];
	static int p[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb;

		for (int test = 1; test <= tc; test++) {
			String s[] = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			sb=new StringBuilder();
			p = new int[n + 1];
			rank = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				p[i] = i;
				rank[i] = 0;
			}

			for (int i = 0; i < m; i++) {// m번의 연산 수행
				String order[] = br.readLine().split(" ");
				if (Integer.parseInt(order[0]) == 0) {
					union(Integer.parseInt(order[1]), Integer.parseInt(order[2]));
				} else {
					int x = find(Integer.parseInt(order[1]));
					int y = find(Integer.parseInt(order[2]));
					if (x == y)
						sb.append(1);
					else
						sb.append(0);
				}
			}

			System.out.println("#" + test + " " + sb);
			
		}

	}// main

	public static int find(int x) {
		if (p[x] == x)
			return p[x];
		else {
			x = find(p[x]);
			return x;
		}
	}

	public static void union(int x, int y) {
		int px = find(x);
		int py = find(y);

		if (px != py) {// 대표자가 다르면
			if (rank[px] >= rank[py]) { // 순위가 px>=py인경우
				p[py] = px;
				rank[px]++;
			} else {
				p[px] = py;
				rank[py]++;
			}
		}
	}
}
