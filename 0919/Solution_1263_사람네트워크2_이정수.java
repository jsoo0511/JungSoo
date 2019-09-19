import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1263_사람네트워크2_이정수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int num;
		String s;
		int arr[][];
		for (int test = 1; test <= tc; test++) {
			s = br.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");

			num = Integer.parseInt(st.nextToken());
			arr = new int[num + 1][num + 1];
			for (int col = 1; col <= num; col++) { // 배열초기화
				for (int row = 1; row <= num; row++) {
					arr[row][col] = Integer.parseInt(st.nextToken());
				}
			}

			for (int k = 1; k < arr.length; k++) {// 경유 정점
				for (int i = 1; i < arr.length; i++) {// 출발 정점
					if (k == i)
						continue;
					for (int j = 1; j < arr.length; j++) { // 도착 정점
						if (k == j || i == j)
							continue;

						if (arr[i][k] != 0 && arr[k][j] != 0) {
							if (arr[i][j] == 0)
								arr[i][j] = arr[i][k] + arr[k][j];
							else if (arr[i][j] > arr[i][k] + arr[k][j]) {
								arr[i][j] = arr[i][k] + arr[k][j];
							}
						}
					}
				}
			}

			
			int min=Integer.MAX_VALUE;
			for(int i=1;i<arr.length;i++) {
				int sum=0;
				for(int j=1;j<arr.length;j++) {
					sum+=arr[i][j];
				}
				if(min>sum)
					min=sum;
			}
			
			System.out.println("#"+test+" "+min);

			

		}
	}

}
