import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_10974 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = i + 1;
		int[] result = new int[n];
		int depth = 0;
		boolean[] visited = new boolean[n];
		perm(arr, result, visited, 0, n, n);

	}

	public static void perm(int[] arr, int[] result, boolean[] visited, int depth, int n, int r) {
		if (depth == r) {
			for (int i = 0; i < r; i++)
				System.out.print(result[i] + " ");
			System.out.println();
			return;

		} else {
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					visited[i] = true;
					result[depth] = arr[i];// depth번째에 arr값을 집어넣는다.
					perm(arr, result, visited, depth + 1, n, r);
					visited[i] = false;
				}
			}

		}
	}
}
