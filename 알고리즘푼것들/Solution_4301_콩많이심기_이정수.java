import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_4301_콩많이심기_이정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		int arr[][];
		for(int test=1;test<=tc;test++) {
			int result=0;
			String s[]=br.readLine().split(" ");
			int col=Integer.parseInt(s[0]);
			int row=Integer.parseInt(s[1]);
			
			arr=new int[row][col];
			
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++) {
					if(arr[i][j]==2 || arr[i][j]==1)
						continue;
					else {
						arr[i][j]=1;//콩심고
						result++;
						
						if(j+2<col)
							arr[i][j+2]=2;//놓으면 안되는 지역
						if(i+2<row)
							arr[i+2][j]=2;
					}
				}
			}
			
			System.out.println("#"+test+" "+result);
		}

	}

}
