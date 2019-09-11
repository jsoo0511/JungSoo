import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_9465_스티커 {
	

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		
		for(int i=0;i<num;i++) {
			int col=Integer.parseInt(br.readLine());
			int arr[][]=new int[2][col];
			
			for(int row=0;row<2;row++) { //배열초기화
				String []s=br.readLine().split(" ");
				for(int j=0;j<col;j++)
					arr[row][j]=Integer.parseInt(s[j]);
			}
			
			int dp[][]=new int[2][col];
			
			dp[0][0]=arr[0][0];
			dp[0][1]=arr[0][1]+arr[1][0];
			dp[1][0]=arr[1][0];
			dp[1][1]=arr[1][1]+arr[0][0];
			
			for(int k=2;k<col;k++) {
				dp[0][k]=Math.max(dp[1][k-1],dp[1][k-2])+arr[0][k];
				dp[1][k]=Math.max(dp[0][k-1],dp[0][k-2])+arr[1][k];
			}
			
			System.out.println(Math.max(dp[0][col-1],dp[1][col-1]));
			
			
		}
		
	}
	


}


