import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_2617_구슬찾기 {
	static ArrayList<Integer> heavy[];
	static ArrayList<Integer> light[];
	static int cnt_1;
	static int cnt_2;
	static int n;
	static boolean visited[]; //방문체크, 사이클 방지

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		heavy = new ArrayList[n + 1];
		light = new ArrayList[n + 1];

		int result = 0;
		for (int i = 1; i <= n; i++) {
			heavy[i] = new ArrayList<>();
			light[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {// 단방향 그래프 생성
			String a[] = br.readLine().split(" ");
			light[Integer.parseInt(a[0])].add(Integer.parseInt(a[1]));
			heavy[Integer.parseInt(a[1])].add(Integer.parseInt(a[0]));
		}

		for (int i = 1; i <= n; i++) {
			cnt_1 = 0;
			cnt_2 = 0;
			visited = new boolean[n + 1];
			dfs_heavy(i);
			visited = new boolean[n + 1];
			dfs_light(i);
			if (cnt_1 > (n / 2) || cnt_2 > (n / 2)) {
				result++;
			}
		}

		System.out.println(result);

	}// end main

	public static void dfs_heavy(int start) {
		visited[start] = true;// 방문체크
		if (cnt_1 > (n / 2))
			return;

		for (int i = 0; i < heavy[start].size(); i++) {
			int link = heavy[start].get(i);
			if (!visited[link]) {
				dfs_heavy(link);
				cnt_1++;
			}
		}
	}

	public static void dfs_light(int start) {
		visited[start] = true;
		if (cnt_2 > (n / 2))
			return;

		for (int i = 0; i < light[start].size(); i++) {
			int link = light[start].get(i);
			if (!visited[link]) {
				dfs_light(link);
				cnt_2++;
			}
		}
	}

}// end class
