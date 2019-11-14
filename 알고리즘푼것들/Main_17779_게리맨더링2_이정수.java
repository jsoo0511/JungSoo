import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17779_게리맨더링2_이정수 {
	static int dr[]= {1,1,-1,-1};
	static int dc[]= {1,-1,-1,1};
	static int arr[][];
	static boolean visited[][];
	static int n,cnt,min,max,des_r,des_c,d1,d2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		
		arr=new int[n][n];
		visited=new boolean[n][n];
		for(int i=0;i<n;i++) {
			String s[]=br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(s[j]);
			}
		}
		
		for(int i=1;i<n-1;i++) {
			for(int j=1;j<n-1;j++) {
				des_r=i;//도착점
				des_c=j;
				d1=0;
				d2=0;
				dfs(i,j,0,1);
			}
		}

	}
	
	public static void dfs(int r, int c, int d, int len) {
		if(d==4)
			return;
		
		int tempr=r+dr[d];//해당 방향으로 이동
		int tempc=c+dc[d];
		
		if(tempr>=0 && tempr<n && tempc>=0 && tempc<n || visited[tempr][tempc]) {
			if(tempr==des_r && tempc==des_c) {//구역 생성
				
			}
			
		}
		
		
		
	}

}
