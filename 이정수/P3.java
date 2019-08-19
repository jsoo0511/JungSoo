package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P3 {
       static int row,col,n;
       static int [][]arr;
       static int players[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int test=1;test<=tc;test++) {
			String s[]=br.readLine().split(" ");
			row=Integer.parseInt(s[0]);
			col=Integer.parseInt(s[1]);
			n=Integer.parseInt(s[2]); //참가자수
			arr=new int[row+1][col+1];
			
			for(int i=1;i<=row;i++) { //배열 초기화
				String []hang=br.readLine().split(" ");
				for(int j=1;j<=col;j++) {
					arr[i][j]=Integer.parseInt(hang[j-1]); //배열 인덱스가 1부터 시작하므로 맞춰줌
				}
			}
			
			for(int i=0;i<n;i++) {
				String third[]=br.readLine().split(" ");
	/*시작위치*/	players[i]=arr[Integer.parseInt(third[0])-1][Integer.parseInt(third[1])-1];
	/*초기 뛰는 방향*/int loc=arr[Integer.parseInt(third[0])-1][Integer.parseInt(third[1])-1]/10;
	/*점프 횟수*/   int c_jump=arr[Integer.parseInt(third[0])-1][Integer.parseInt(third[1])-1]%10;
				
			}
			
			String[] trap=br.readLine().split(" ");
			for(int i=0;i<=0;i++) {
				int t_row=arr[Integer.parseInt(trap[i])-1][Integer.parseInt(trap[i+1])-1];
				int t_col=arr[Integer.parseInt(trap[i])-1][Integer.parseInt(trap[1])-1];
			}
		}

	}

}
