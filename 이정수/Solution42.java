package com.ssafy.algo;

import java.util.Scanner;

public class Solution42 {
       static int[] jumper_r;
       static int[] jumper_c;
       static int[] ins_r;
       static int[] ins_c;
       static int[][] arr;
       static int sRow,sCol;
       static boolean flag=true;
       static int final_r,final_c;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
		for(int test=1;test<=tc;test++) {
			final_r=0;
			final_c=0;
			flag=true;
			int N=sc.nextInt();
			arr=new int[N+1][N+1];
			sRow=sc.nextInt();
			sCol=sc.nextInt();
			arr[sRow][sCol]=1; //출발점좌표
			int jumpers=sc.nextInt();
			jumper_r=new int[jumpers+1];//0~jumpers 점퍼 행 좌표
			jumper_c=new int[jumpers+1]; // 점퍼 열 좌표
		    for(int i=1;i<=jumpers;i++) {
		    	jumper_r[i]=sc.nextInt();
		    	jumper_c[i]=sc.nextInt();
		    	arr[jumper_r[i]][jumper_c[i]]=2; //점퍼는 2로 설정
		    }
		    
		    int ins=sc.nextInt(); // 이동지시 수 
		    ins_r=new int[ins+1]; //이동지시 방향
		    ins_c=new int[ins+1];  //이동지시 점프간수
		    for(int i=1;i<=ins;i++) {
		    	ins_r[i]=sc.nextInt(); //이동지시방향(상우하좌)위부터 시계방향
		    	ins_c[i]=sc.nextInt();//이동지시 점프칸수
		    }
		    
		    
		    for(int i=1;i<=ins;i++) { //명령어수만큼 이동 실행
		    	Move(i);
		    	if(!flag)  //점퍼만나거나 범위 아웃이 바로 탈출
		    		break;
		    }
		    
		    if(!flag) //범위벗어나거나 점퍼로 탈출시 
		    	System.out.println("#"+test+" "+0+" "+0);
		    else //그냥 마지막 도착시
		    	System.out.println("#"+test+" "+final_r+" "+final_c);
		    
		}
	}
	
	static void Move(int i) { //i번째 이동
		
		
		if(ins_r[i]==1) {//상
			for(int k=1;k<=ins_c[i];k++) { //점프수만큼 이동
				if(!isIn(sRow-1,sCol)) {
					flag=false;
					break;
				}
				if(arr[sRow-1][sCol]==2)//만약 점퍼를 만나면 탈출
				{
					flag=false;
					break;
				}
				arr[sRow-1][sCol]=1;//한칸씩 위로 이동
				
				sRow=sRow-1; //이동이 정해지면 sRow를 한칸 위로 올려줌
				
				final_r=sRow; //이동후 정답 행값 수정
				final_c=sCol; //이동후 정답 열값 수정
			}
		}
		else if(ins_r[i]==2) { //우
			for(int k=1;k<=ins_c[i];k++) { //점프수만큼 이동
				if(!isIn(sRow,sCol+1)) {
					flag=false;
					break;
				}
				if(arr[sRow][sCol+1]==2)//만약 점퍼를 만나면 탈출
				{
					flag=false;
					break;
				}
				arr[sRow][sCol+1]=1;//한칸씩 위로 이동
				
				sCol=sCol+1; //이동이 정해지면 sCol를 한칸 오른쪽으로 이동
				final_r=sRow; //이동후 정답 행값 수정
				final_c=sCol; //이동후 정답 열값 수정

			}
		}
		else if(ins_r[i]==3) { //하
			for(int k=1;k<=ins_c[i];k++) { //점프수만큼 이동
				if(!isIn(sRow+1,sCol)) {
					flag=false;
					break;
				}
				if(arr[sRow+1][sCol]==2)//만약 점퍼를 만나면 탈출
				{
					flag=false;
					break;
				}
				arr[sRow+1][sCol]=1;//한칸씩 위로 이동
				
				sRow=sRow+1; //이동이 정해지면 sCol를 한칸 오른쪽으로 이동
				
				final_r=sRow; //이동후 정답 행값 수정
				final_c=sCol; //이동후 정답 열값 수정

			}
		}
		else {//좌
			for(int k=1;k<=ins_c[i];k++) { //점프수만큼 이동
				if(!isIn(sRow,sCol-1)) {
					flag=false;
					break;
				}
				if(arr[sRow][sCol-1]==2)//만약 점퍼를 만나면 탈출
				{
					flag=false;
					break;
				}
				arr[sRow][sCol-1]=1;//한칸씩 위로 이동
				
				sCol=sCol-1; //이동이 정해지면 sCol를 한칸 오른쪽으로 이동
				
				final_r=sRow; //이동후 정답 행값 수정
				final_c=sCol; //이동후 정답 열값 수정

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
