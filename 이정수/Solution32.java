package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution32 {
	static int T, X, Y, N, A, H;
	static int [][] map, player;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(src);
		T = scanner.nextInt();
		for(int t=1; t<=T; t++) {
			Y = scanner.nextInt()+1;// 1,1 부터 시작
			X = scanner.nextInt()+1;
			map = new int[Y][X];	
			N = scanner.nextInt();
			for(int y=1; y<Y; y++) {
				for(int x=1; x<X; x++) {
					map[y][x]=scanner.nextInt();
				}
			}
			player = new int [N][3];
			for(int n=0; n<N; n++) {
				for(int j=0; j<3; j++) {
					player[n][j]=scanner.nextInt();
				}
			}
			H = scanner.nextInt();// 함정
			for(int h=0; h<H; h++) {
				int r = scanner.nextInt();
				int c = scanner.nextInt();
				map[r][c]=0;
			}
			// map 확인
			//for(int [] row: map) {
			//	System.out.println(Arrays.toString(row));
			//}
			
			// 입력 끝
			int answer = 0;
			for(int n=0; n<N; n++) {
				int pr = player[n][0];		// 플레이어 r
				int pc = player[n][1];		// 플레이어 c
				int pj = player[n][2];		// 점프 회수

				int reward = -1000;			// 참가비
				boolean isDie = false;		// 생존 여부
				
				for(int m=0; m<pj; m++) {		// 점프 회수만큼 점프
					int jd = map[pr][pc]/10;	// 점프 방향
					int jcnt = map[pr][pc]%10;	// 점프 거리	
					if(jd==4) {// 4: 위
						int newR = pr-jcnt;
						if(isIn(newR, pc) && map[newR][pc]!=0) {
							pr = newR;
						}else {
							isDie = true;
							break;
						}
					}else if(jd==2) {// 2: 아래
						int newR = pr+jcnt;
						if(isIn(newR, pc) && map[newR][pc]!=0) {
							pr = newR;
						}else {
							isDie = true;
							break;
						}
					}else if(jd==1) {// 1: 오른
						int newC = pc+jcnt;
						if(isIn(pc, newC) && map[pr][newC]!=0) {
							pc = newC;
						}else {
							isDie = true;
							break;
						}
					}else if(jd==3) {// 3: 왼
						int newC = pc-jcnt;
						if(isIn(pc, newC) && map[pr][newC]!=0) {
							pc = newC;
						}else {
							isDie = true;
							break;
						}
					}
				}
				if(!isDie) {
					reward += map[pr][pc] * 100;
				}
				answer +=reward;
			}
			System.out.printf("# %d %d\n", t, answer);
		}

	}
	public static boolean isIn(int r, int c) {
		return 1<=r && 1<=c && r<Y && c<X;
	}

	static String src = "3\r\n" + 
			"6 6 2\r\n" + 
			"34 42 22 32 21 24\r\n" + 
			"22 32 21 33 33 33\r\n" + 
			"13 11 12 21 43 13\r\n" + 
			"34 23 22 24 32 11\r\n" + 
			"22 24 21 41 41 42\r\n" + 
			"31 42 34 32 15 32\r\n" + 
			"2 3 2\r\n" + 
			"2 6 6\r\n" + 
			"3 3 4 4 2 6 5\r\n" + 
			"2 2 3  \r\n" + 
			"11 21\r\n" + 
			"41 31\r\n" + 
			"1 1 2\r\n" + 
			"2 1 2\r\n" + 
			"1 2 1\r\n" + 
			"1 2 2\r\n" + 
			"5 6 2\r\n" + 
			"22 32 21 33 33 33\r\n" + 
			"13 11 12 21 43 13\r\n" + 
			"34 23 22 24 32 11\r\n" + 
			"22 24 21 41 41 42\r\n" + 
			"31 42 34 32 15 32\r\n" + 
			"5 4 2\r\n" + 
			"1 3 1\r\n" + 
			"2 3 4 4 2"			;
}
