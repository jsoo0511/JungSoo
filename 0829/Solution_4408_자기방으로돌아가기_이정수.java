import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_4408_자기방으로돌아가기_이정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());

		for (int test = 1; test <= tc; test++) {
			int corri[] = new int[201];
			int n = Integer.parseInt(br.readLine().trim());
			int result = 0;
			for (int i = 0; i < n; i++) {
				String[] s = br.readLine().split(" ");
				int start = Integer.parseInt(s[0]);
				int end = Integer.parseInt(s[1]);
				if (start % 2 == 1)
					start++;
				if (end % 2 == 1)
					end++;
				if (start > end) {
					int temp = start;
					start = end;
					end = temp;
				}

				for (int j = start / 2; j <= end / 2; j++)
					corri[j]++;
			}
			for (int i = 0; i < corri.length; i++)
				result = Math.max(result, corri[i]);

			System.out.println("#" + test + " " + result);

		}

	} // end main

}
