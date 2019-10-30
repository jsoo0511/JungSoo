import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2105_디저트카페_이정수 {

	static int n,sr,sc;
	static int arr[][];
	static boolean visited[][];
	static int val[];
	static int dr[]= {1,1,-1,-1};
	static int dc[]= {1,-1,-1,1};
	static int cnt,result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		
		for(int test=1;test<=tc;test++) {
			n=Integer.parseInt(br.readLine());
			arr=new int[n][n];
			visited=new boolean[n][n];
			val=new int[101];
			result=0;
			for(int i=0;i<n;i++) {//배열초기화
				String s[]=br.readLine().split(" ");
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(s[j]);
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					sr=i;
					sc=j;
					visited[i][j]=true;
					val[arr[i][j]]=1;
					
					dfs(i,j,1,0);
					val[arr[i][j]]=0;
					visited[i][j]=false;
				}
			}
			
			if(result<4)
				System.out.println("#"+test+" "+-1);
			else
				System.out.println("#"+test+" "+result);
		}

	}
	
	public static void dfs(int row,int col,int cnt,int d) {
		if(d==4)
			return;
		
		int tempr=row+dr[d];
		int tempc=col+dc[d];
		
		if(!isRange(tempr,tempc))
			return;
		
		if(visited[tempr][tempc] || val[arr[tempr][tempc]]==1){
			if(tempr==sr && tempc==sc){
				result=Math.max(result, cnt);
			}
			return;
		}
		
		val[arr[tempr][tempc]]=1;
		visited[tempr][tempc]=true;
		dfs(tempr,tempc,cnt+1,d);
		dfs(tempr,tempc,cnt+1,d+1);
		visited[tempr][tempc]=false;
		val[arr[tempr][tempc]]=0;
		
		
	
	}
	
	public static boolean isRange(int r, int c){
		if(r>=0 && r<n && c>=0 && c<n)
			return true;
		else
			return false;
		
	}
	

}










