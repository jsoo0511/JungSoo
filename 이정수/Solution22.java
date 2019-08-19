package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution22 {
	static int arr[][];
	static int loc[];
	static int N,num_so;
	static int sum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int test=1;test<=tc;test++) {
			String n[]=br.readLine().split(" ");
			N=Integer.parseInt(n[0]);
			num_so=Integer.parseInt(n[1]);
			sum=0;
			arr=new int[N][N];
			loc=new int[num_so];
			for(int i=1;i<=num_so;i++) { //소금쟁이 위치 초기화
				String s[]=br.readLine().split(" ");
			    arr[Integer.parseInt(s[0])][Integer.parseInt(s[1])]=i;
			    loc[i-1]=Integer.parseInt(s[2]);
				
			}
			
			for(int i=1;i<=num_so;i++) {
				Move(i);
			}
			
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++) {
					if(arr[i][j]!=0)
						sum++;
				}
			}
		
			System.out.println("#"+test+" "+sum);
		}
		
		
	}
	
	public static void Move(int i) {
		int t_r=0;
		int t_c=0;
		for(int r=0;r<N;r++) { //i 번째 소금쟁이위치 추출
			for(int c=0;c<N;c++) {
				if(arr[r][c]==i)
				{
				t_r=r;
				t_c=c;
				}
			}
		}
		
		int jump=loc[i-1]; //방향추출
		
		if(jump==1) { //Up
			for(int j=3;j>0;j--) {
				arr[t_r][t_c]=0; //움직였던 자리 0으로 초기화
				if(!isIn(t_r-j,t_c))//움직였는데 라인 벗어나면
					break;
				if(arr[t_r-j][t_c] ==0)// 뛰었는데 누가 없다면
				{
				 arr[t_r-j][t_c]=i;//정착
				 t_r=t_r-j;//움직인 위치로 위치 초기화
				}
				else
					break;//누가 있다면 arr은 0으로 된채 탈출
			}
		}
		else if(jump==2) { //Down
			for(int j=3;j>0;j--) {
				arr[t_r][t_c]=0; //움직였던 자리 0으로 초기화
				if(!isIn(t_r+j,t_c))//움직였는데 라인 벗어나면
					break;
				if(arr[t_r+j][t_c] ==0)// 뛰었는데 누가 없다면
				{
				 arr[t_r+j][t_c]=i;//정착
				 t_r=t_r+j;
				}
				else
					break;//누가 있다면 arr은 0으로 된채 탈출
			}
		}
		
		else if(jump==3) { //Left
			for(int j=3;j>0;j--) {
				arr[t_r][t_c]=0; //움직였던 자리 0으로 초기화
				if(!isIn(t_r,t_c-j))//움직였는데 라인 벗어나면
					break;
				if(arr[t_r][t_c-j] ==0)// 뛰었는데 누가 없다면
				{
				 arr[t_r][t_c-j]=i;//정착
				 t_c=t_c-j;
				}
				else
					break;//누가 있다면 arr은 0으로 된채 탈출
			}
		}
		else {//Right
			for(int j=3;j>0;j--) {
				arr[t_r][t_c]=0; //움직였던 자리 0으로 초기화
				if(!isIn(t_r,t_c+j))//움직였는데 라인 벗어나면
					break;
				if(arr[t_r][t_c+j] ==0)// 뛰었는데 누가 없다면
				{
				 arr[t_r][t_c+j]=i;//정착
				 t_c=t_c+j;
				}
				else
					break;//누가 있다면 arr은 0으로 된채 탈출
			}
		}
		
	}
	
	public static boolean isIn(int r, int c) {
		if (r < 0 || r >= arr.length || c < 0 || c >= arr[r].length)
			return false;
		else
			return true;
	}

}
