import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_정올_1681_해밀턴순환회로_이정수 {
	static int arr[][];
	static int n,min,cnt;
    static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		visited=new boolean[n+1];
		min=Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) { //배열초기화
			String s[]=br.readLine().split(" ");
			for (int j = 1; j <= n; j++) {
				arr[i][j]=Integer.parseInt(s[j-1]);
			}
		}	
			cnt=0;
			visited[1]=true;
			dfs(1,1);
		System.out.println(min);

	}
	
	public static void dfs(int start, int len) {
		
		if(len==n) { //끝까지 감
	        if(arr[start][1]!=0)//끝에서 복귀할 수 있는 경우
			   cnt+=arr[start][1];
	        else //끝에서 복귀할 수 없는 경우
	        	return;
	        
			if(min>cnt) {
				min=cnt;
			}
			cnt-=arr[start][1];
			return;
		}
		
		for(int i=1;i<=n;i++) {
			if(!visited[i] && arr[start][i]!=0) { //길이 없거나 방문한경우 skip
				cnt+=arr[start][i];
				visited[i]=true;
			    dfs(i,len+1);
			    cnt-=arr[start][i];
				visited[i]=false;
			}
		}
	}

}
