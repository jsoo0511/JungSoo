import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_정올_2634_사냥꾼_이정수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int M = Integer.parseInt(st.nextToken()); // 발사대 수
		int N = Integer.parseInt(st.nextToken()); // 동물의 수
		int L = Integer.parseInt(st.nextToken()); // 사정거리

		st = new StringTokenizer(br.readLine(), " ");
		int[] shooter = new int[M];
		for (int i = 0; i < M; i++) {
			shooter[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(shooter);
		int[][] arr = new int[N][2];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = L-Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				else
					return o1[0] - o2[0];
			}
		});
		int temp = -1;
		int i = 0;
		outer:for (int j = 0; j < N; j++) {
			for (; i < M-1;) {
				temp = arr[j][1] - Math.abs(shooter[i] - arr[j][0]);
				if (temp >= 0) {
					cnt++;
					continue outer;
				}
				else if(Math.abs(shooter[i]-arr[j][0])>=Math.abs(shooter[i+1]-arr[j][0]) ){
					i++;
				}else {
					continue outer;
				}
			}
			
			temp = arr[j][1] - Math.abs(shooter[i] - arr[j][0]);
			if (temp >= 0) {
				cnt++;
				continue;
			}
		}

		bw.write(cnt + "\n");
		bw.flush();
	}
}