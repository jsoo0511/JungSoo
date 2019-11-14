import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_1861_정사각형방_이정수 {
	public static ArrayList<Integer> list[];
	public static int arr[][];
	public static int dr[]= {0,1,0,-1};
	public static int dc[]= {1,0,-1,0};
	public static int max,real;
	public static int min;
	public static int result;
    public static boolean visited[][];
    public static int n,count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		
		for(int test=1;test<=tc;test++) {
			n=Integer.parseInt(br.readLine());
			arr=new int[n][n];
			visited=new boolean[n][n];
			for(int i=0;i<n;i++) {//배열초기화
				String []s=br.readLine().split(" ");
				for(int j=0;j<n;j++)
					arr[i][j]=Integer.parseInt(s[j]);
			}
			max=0;
			result=Integer.MAX_VALUE;
			real=0;
			for(int i=0;i<n;i++) { //탐색시작
				for(int j=0;j<n;j++) {
					count=0;
					max=0;
			           dfs(i,j);
			           if(real<=max) {
			        	   
			        	   if(real<max) //real에 있는 값보다 큰 자리에 있는 애의 경우는 그냥 값 변경
			        		   result=arr[i][j];
			        	   else {
			        		   if(result>arr[i][j])
			        			   result=arr[i][j];
			        	   }
			        	   real=max;
//			        	   real=max;
//			        	   if(result>arr[i][j])
//			        	        result=arr[i][j];
			           }
			          // System.out.println("Real max result"+real+", "+max+", "+result);
				}
			}
			
			System.out.println("#"+test+" "+result+" "+(real+1));
		}

	}
	
	public static void dfs(int row,int col) {
		
		for(int i=0;i<4;i++) {
			int r=row+dr[i];
			int c=col+dc[i];
			if(isRange(r,c) && arr[r][c]-arr[row][col]==1) {
				count+=1;
				dfs(r,c);
				
			}
		}
		if(max<count) {//끝까지 다다르고 뒤로 후진할때
			max=count;
		}
	}
	
	public static boolean isRange(int r,int c) {
		if(r>=0 && r<n && c>=0 && c<n) {
			return true;
		}
		else
			return false;
		
	}

}
