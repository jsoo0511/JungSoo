import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1954_달팽이숫자_이정수 {

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tc=Integer.parseInt(br.readLine());
        
        for (int test = 1; test <= tc; test++) {
			int n=Integer.parseInt(br.readLine());
			int arr[][]=new int[n][n];
			int step=n;
			int r=0;
			int c=-1;
			int num=1;
			while(step>0) {
				for(int i=0;i<step;i++) {
					c++;
					arr[r][c]=num++;
				}
				step--;
				for(int i=0;i<step;i++) {
					r++;
					arr[r][c]=num++;
				}
				
				for(int i=0;i<step;i++) {
					c--;
					arr[r][c]=num++;
				}
				step--;
				for(int i=0;i<step;i++) {
					r--;
					arr[r][c]=num++;
				}
			}
			System.out.println("#"+test);
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++)
					System.out.print(arr[i][j]+" ");
				System.out.println();
			}
        	
		}
	}

}
