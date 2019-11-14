import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_7699푸는중 {
	static char srr[][];
	static int n;
	static int m;
    static boolean []alpha;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int test=1;test<=tc;test++) {
			alpha=new boolean[26];
			String []s=br.readLine().split(" ");
			n=Integer.parseInt(s[0]);
			m=Integer.parseInt(s[1]);
			srr=new char[n+1][m+1];
			char[] temp;
			for(int i=1;i<=n;i++) {
				String str=br.readLine();
				temp=str.toCharArray();
				for(int j=1;j<=m;j++) {
					srr[i][j]=temp[j-1];
				}
			}
			
			dfs(1);
			
		}

	}
	
	public static void dfs(int x) {
		
	}

}
