import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_정올_2283_RGB마을_이정수 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		int arr[][]=new int[n][3];
		
		for(int i=0;i<n;i++) {
			String s[]=br.readLine().split(" ");
			for(int j=0;j<3;j++) {
				arr[i][j]=Integer.parseInt(s[j]);
			}
		}
		
		
		for(int i=0;i<n-1;i++) {
			arr[i+1][0]=Math.min(arr[i][1], arr[i][2])+arr[i+1][0];
			arr[i+1][1]=Math.min(arr[i][0], arr[i][2])+arr[i+1][1];
			arr[i+1][2]=Math.min(arr[i][0], arr[i][1])+arr[i+1][2];
		}
		
		int result=Math.min(arr[n-1][2],Math.min(arr[n-1][0], arr[n-1][1]));
		System.out.println(result);
	}

}
