import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1987_알파벳_이정수 {
	 static int R,C;
	 static char arr[][];
	 static int dr[]= {0,1,0,-1};
	 static int dc[]= {1,0,-1,0};
	 static boolean visited[][];
	 static int alpha[];
	 static int result;
	 static int max,cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]=br.readLine().split(" ");
		R=Integer.parseInt(s[0]);
		C=Integer.parseInt(s[1]);
		arr=new char[R+1][C+1];
		visited=new boolean[R+1][C+1];
		alpha=new int[26];
		result=0;
		max=0;
		cnt=0;
		for(int i=1;i<=R;i++) {//배열초기화
			char str[]=br.readLine().toCharArray();
			for(int j=1;j<=C;j++) {
				arr[i][j]=str[j-1];
			}
		}
		visited[1][1]=true;
		alpha[arr[1][1]-'A']++;
		dfs(1,1);
		System.out.println(max+1);
	}
	
	public static void dfs(int r,int c) {
		if(max<cnt)
			max=cnt;
		
		int val=arr[r][c]-'A';
		
		
		for(int i=0;i<4;i++) {
			
			int tempr=r+dr[i];
			int tempc=c+dc[i];
			
			if(isRange(tempr,tempc) && !visited[tempr][tempc] && alpha[arr[tempr][tempc]-'A']==0) {	
				alpha[arr[tempr][tempc]-'A']++;
				cnt++;
				dfs(tempr,tempc);
			}
		}
		cnt--;
		alpha[val]--;
		visited[r][c]=false;
   
	}
	
	public static boolean isRange(int r,int c) {
		if(r>0 && r<=R && c>0 && c<=C)
			return true;
		else
			return false;
	}

}
