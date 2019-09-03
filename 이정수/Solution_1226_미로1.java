import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1226_미로1 {
    static int arr[][];
    static int start_r,start_c;
    static int dr[]= {0,1,0,-1};
    static int dc[]= {1,0,-1,0};
    static int end_r,end_c;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
	    for(int test=1;test<=10;test++) {
	    	n=Integer.parseInt(br.readLine());
	    	arr=new int[16][16];
	    	
	    	for(int i=0;i<16;i++) {
	    		String []s=br.readLine().split("");
	    		for(int j=0;j<16;j++) {
	    			arr[i][j]=Integer.parseInt(s[j]);
	    			if(arr[i][j]==2)
	    			{
	    				start_r=i;
	    				start_c=j;
	    			}
	    			if(arr[i][j]==3) {
	    				end_r=i;
	    				end_c=j;
	    			}
	    		}
	    	}
	    	
	    	dfs(start_r,start_c);
	    	
	    	if(arr[end_r][end_c]==5)
	    		System.out.println("#"+test+" "+1);
	    	else
	    		System.out.println("#"+test+" "+0);
	    	
	    }

	}
	
	public static void dfs(int r,int c) {
		if(arr[r][c]==3) {
			arr[r][c]=5;
			return;
		}
		arr[r][c]=5;
		
		for(int i=0;i<4;i++) {
			int row=r+dr[i];
			int col=c+dc[i];
			if(row>=0 && row<16 && col>=0 && col<16 && (arr[row][col]==0 || arr[row][col]==3)) {
				dfs(row,col);
			}
		}
	}

}
