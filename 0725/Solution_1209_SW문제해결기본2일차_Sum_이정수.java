import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1209_SW문제해결기본2일차_Sum_이정수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test = 1; test <= 10; test++) {
            int n=Integer.parseInt(br.readLine());
			int arr[][] = new int[100][100];
			for (int i = 0; i < 100; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 0; j < 100; j++)
					arr[i][j] = Integer.parseInt(s[j]);

			}

			int max = 0;
			int temp = 0;

			for (int i = 0; i < 100; i++) { // 행합
				temp = 0;
				for (int j = 0; j < 100; j++) {
					temp += arr[i][j];
				}
				if (max < temp)
					max = temp;
			}

			for (int i = 0; i < 100; i++) { // 열합
				temp = 0;
				for (int j = 0; j < 100; j++) {
					temp += arr[j][i];
				}
				if (max < temp)
					max = temp;
			}

			for (int i = 0; i < 100; i++) {
				temp = 0;
				for (int j = 0; j < 100; j++) {
					if (i == j) // 동남향 대각선
						temp += arr[i][j];
				}
				if (max < temp)
					max = temp;
			}

			for (int i = 0; i < 100; i++) {
				temp = 0;
				for (int j = 0; j < 100; j++) {
					if ((i + j) == 4) // 서남향 대각선
						temp += arr[i][j];
				}
				if (max < temp)
					max = temp;
			}

			System.out.println("#"+test+" "+max);

		}
	}

}
