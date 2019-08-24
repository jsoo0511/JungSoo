import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_7963_부먹왕국의차원관문 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int city = 0;
		int n = 0;
		int arr[];
		int cnt;
		for (int test = 1; test <= tc; test++) {
			String[] s = br.readLine().split(" ");
			city = Integer.parseInt(s[0]);
			n = Integer.parseInt(s[1]);
			cnt = 0;
			arr = new int[city + 2];
			arr[0] = arr[city + 1] = 1;// 처음과 마지막은 문이 있다.
			String s1[]=br.readLine().split(" ");
			for(int i=1;i<=city;i++){
				arr[i]=Integer.parseInt(s1[i-1]);
			}
			boolean flag;
			for (int i = 0; i <= city; i++) {
				if(i+n>city)
					break;
				flag = false;
				int temp = 0;
				for (int j = 1; j <= n; j++) {
					if (arr[i + j] == 0)
						flag = false;
					else {
						temp = i + j;
						flag = true;
						break;
					}
				}
				if (!flag) {
					i += n-1;
					cnt++;
					arr[i+1]=1;
				} else {
					i = temp-1;
				}
			}
			
			System.out.println("#"+test+" "+cnt);

		}

	}

}
