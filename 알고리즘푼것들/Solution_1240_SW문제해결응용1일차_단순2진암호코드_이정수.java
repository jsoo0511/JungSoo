import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1240_SW문제해결응용1일차_단순2진암호코드_이정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int temp[];
		for (int test = 1; test <= tc; test++) {
			String s1[] = br.readLine().split(" ");
			int n = Integer.parseInt(s1[0]);
			int m = Integer.parseInt(s1[1]);
			int arr[][] = new int[n][m];
			temp=new int[56];
			int row=0,col=0;
            int cnt=0;
            boolean flag=true;
			for (int i = 0; i < n; i++) {
				String[] s = br.readLine().split("");
				for (int j = 0; j < m; j++) {
					arr[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=m-1;j>=0;j--) {//열뒤부터 탐색
					System.out.print(arr[i][j]);
					if(arr[i][j]==1) {
						row=i;
						col=j-56;
						flag=false;
						break; //1찾으면 탈출
					}
				}
				if(!flag)
					break;
				System.out.println();
			}
			System.out.println(row+" "+col);
			 for(int i=col;i<col+56;i++) {
				 temp[cnt++]=arr[row][col];
			 }
			 
			 for(int i:temp)
				 System.out.print(i);

		
		}

	}

}
