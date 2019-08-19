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
			arr[sRow][sCol]=1; //�������ǥ
			int jumpers=sc.nextInt();
			jumper_r=new int[jumpers+1];//0~jumpers ���� �� ��ǥ
			jumper_c=new int[jumpers+1]; // ���� �� ��ǥ
		    for(int i=1;i<=jumpers;i++) {
		    	jumper_r[i]=sc.nextInt();
		    	jumper_c[i]=sc.nextInt();
		    	arr[jumper_r[i]][jumper_c[i]]=2; //���۴� 2�� ����
		    }
		    
		    int ins=sc.nextInt(); // �̵����� �� 
		    ins_r=new int[ins+1]; //�̵����� ����
		    ins_c=new int[ins+1];  //�̵����� ��������
		    for(int i=1;i<=ins;i++) {
		    	ins_r[i]=sc.nextInt(); //�̵����ù���(�������)������ �ð����
		    	ins_c[i]=sc.nextInt();//�̵����� ����ĭ��
		    }
		    
		    
		    for(int i=1;i<=ins;i++) { //��ɾ����ŭ �̵� ����
		    	Move(i);
		    	if(!flag)  //���۸����ų� ���� �ƿ��� �ٷ� Ż��
		    		break;
		    }
		    
		    if(!flag) //��������ų� ���۷� Ż��� 
		    	System.out.println("#"+test+" "+0+" "+0);
		    else //�׳� ������ ������
		    	System.out.println("#"+test+" "+final_r+" "+final_c);
		    
		}
	}
	
	static void Move(int i) { //i��° �̵�
		
		
		if(ins_r[i]==1) {//��
			for(int k=1;k<=ins_c[i];k++) { //��������ŭ �̵�
				if(!isIn(sRow-1,sCol)) {
					flag=false;
					break;
				}
				if(arr[sRow-1][sCol]==2)//���� ���۸� ������ Ż��
				{
					flag=false;
					break;
				}
				arr[sRow-1][sCol]=1;//��ĭ�� ���� �̵�
				
				sRow=sRow-1; //�̵��� �������� sRow�� ��ĭ ���� �÷���
				
				final_r=sRow; //�̵��� ���� �ప ����
				final_c=sCol; //�̵��� ���� ���� ����
			}
		}
		else if(ins_r[i]==2) { //��
			for(int k=1;k<=ins_c[i];k++) { //��������ŭ �̵�
				if(!isIn(sRow,sCol+1)) {
					flag=false;
					break;
				}
				if(arr[sRow][sCol+1]==2)//���� ���۸� ������ Ż��
				{
					flag=false;
					break;
				}
				arr[sRow][sCol+1]=1;//��ĭ�� ���� �̵�
				
				sCol=sCol+1; //�̵��� �������� sCol�� ��ĭ ���������� �̵�
				final_r=sRow; //�̵��� ���� �ప ����
				final_c=sCol; //�̵��� ���� ���� ����

			}
		}
		else if(ins_r[i]==3) { //��
			for(int k=1;k<=ins_c[i];k++) { //��������ŭ �̵�
				if(!isIn(sRow+1,sCol)) {
					flag=false;
					break;
				}
				if(arr[sRow+1][sCol]==2)//���� ���۸� ������ Ż��
				{
					flag=false;
					break;
				}
				arr[sRow+1][sCol]=1;//��ĭ�� ���� �̵�
				
				sRow=sRow+1; //�̵��� �������� sCol�� ��ĭ ���������� �̵�
				
				final_r=sRow; //�̵��� ���� �ప ����
				final_c=sCol; //�̵��� ���� ���� ����

			}
		}
		else {//��
			for(int k=1;k<=ins_c[i];k++) { //��������ŭ �̵�
				if(!isIn(sRow,sCol-1)) {
					flag=false;
					break;
				}
				if(arr[sRow][sCol-1]==2)//���� ���۸� ������ Ż��
				{
					flag=false;
					break;
				}
				arr[sRow][sCol-1]=1;//��ĭ�� ���� �̵�
				
				sCol=sCol-1; //�̵��� �������� sCol�� ��ĭ ���������� �̵�
				
				final_r=sRow; //�̵��� ���� �ప ����
				final_c=sCol; //�̵��� ���� ���� ����

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
