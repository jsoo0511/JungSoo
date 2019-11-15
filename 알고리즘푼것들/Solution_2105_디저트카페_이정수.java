import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2105_디저트카페_이정수 {

	static int n;
	static int arr[][];
	static boolean visited[][];
	static int val[];
	static int dr[]= {1,1,-1,-1};
	static int dc[]= {1,-1,-1,1};
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		
		for(int test=1;test<=tc;test++) {
			n=Integer.parseInt(br.readLine());
			arr=new int[n][n];
			visited=new boolean[n][n];
			
			for(int i=0;i<n;i++) {//배열 초기화
				String s[]=br.readLine().split(" ");
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(s[j]);
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					visited[i][j]=true;
					val[arr[i][j]]=1;
					dfs(i,j,1,0);
					val[arr[i][j]]=0;
					visited[i][j]=false;
				}
			}
		}

	}
	
	public static void dfs(int row,int col,int cnt,int d) {
		int tempr=row+dr[d];
		int tempc=col+dc[d];
		
		if(tempr>=0 && tempr<n && tempc>=0 && tempc<n && !visited[tempr][tempc] && val[arr[tempr][tempc]]==0) {
			visited[tempr][tempc]=true;
			val[arr[tempr][tempc]]=1;
			dfs(tempr,tempc,cnt+1,d);
			val[arr[tempr][tempc]]=0;
			visited[tempr][tempc]=false;
		} else {
			tempr-=dr[d];
			tempc-=dc[d];
		}
	}
	

}










