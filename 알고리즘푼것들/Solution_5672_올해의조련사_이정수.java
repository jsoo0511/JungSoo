import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5672_올해의조련사_이정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		int tc = Integer.parseInt(br.readLine());
		char arr[] = {};
		int n = 0;
		for (int test = 1; test <= tc; test++) {
			sb=new StringBuilder();
			n = Integer.parseInt(br.readLine());
			arr = new char[n];
			for (int i = 0; i < n; i++) {
				arr[i] = br.readLine().charAt(0);
			}

			int start = 0;
			int end = n - 1;
			while (start <= end) {
				if (arr[start] != arr[end]) {// 처음과 끝의 문자가 다르면
					if (arr[start] < arr[end]) {
						sb.append(arr[start]);
						start++;
					} else {
						sb.append(arr[end]);
						end--;
					}
				} else {// 처음과 끝의 문자가 같으면
					int temp_start = start + 1;
					int temp_end = end - 1;
					boolean flag = false;
					while (temp_start < temp_end) {
						if (arr[temp_start] != arr[temp_end]) {// cdbc와 같은 경우
							if (arr[temp_start] < arr[temp_end]) {
								flag = true;
								sb.append(arr[start]);
								start++;
								break;
							} else {
								flag = true;
								sb.append(arr[end]);
								end--;
								break;
							}
						} else {
							temp_start++;
							temp_end--;
						}
					}

					if (!flag) {
						sb.append(arr[start]);
						start++;
					} 

				}
			} 
			System.out.print("#" + test + " ");
			System.out.println(sb);
		}
	}

}
