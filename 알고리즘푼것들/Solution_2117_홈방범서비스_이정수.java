import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2117_홈방범서비스_이정수 {
	static int n,m,cnt,max;
	static int arr[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int test=1;test<=tc;test++) {
			String s[]=br.readLine().split(" ");
			n=Integer.parseInt(s[0]);//배열크기
			m=Integer.parseInt(s[1]);//지불 금액
			
			for(int i=0;i<n;i++) {
				String str[]=br.readLine().split(" ");
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(str[j]);
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					
				}
			}
			
			
			
		}

	}

}
