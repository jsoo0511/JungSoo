import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main_2217_로프 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int max = 0;
		Arrays.sort(arr);

		for (int i = N - 1; i >= 0; i--) {
			if (max < arr[i] * (N - i))
				max = arr[i] * (N - i);
		}
		System.out.println(max);

	}
}
