package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution13 {
	static String arr2D[][];
	static int sum = 0;
	static int temp = 0;
	static int max = 0;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int test = 1; test <= tc; test++) {
            max=0;
			N = Integer.parseInt(br.readLine());
			arr2D = new String[N][N];

			for (int row = 0; row < N; row++) { // 배열초기화

				String s[] = br.readLine().split(" ");
				for (int col = 0; col < N; col++) {

					arr2D[row][col] = s[col];
				}

			}

			for (int row = 0; row < N; row++) { // 배열탐색

				for (int col = 0; col < N; col++) {
					temp = 0;
					if (arr2D[row][col].equals("G")) // 배열값이 G면 스킵
						continue;
					temp = getResult(row, col); // 배열값이 B면 탐색시작
					if (max < temp)
						max = temp;
				}
			}

			System.out.println("#" + test + " " + (max + 1));
		}
	}

	// 주어진 위치를 기준을 8방 요소의 합을 리턴하시오
	public static int getResult(int r, int c) {
		int[] dx = { 1, 1, 1, 0, -1, -1, -1, 0 };
		int[] dy = { 1, 0, -1, -1, -1, 0, 1, 1 };
		int[] dx4 = { 0, 1, 0, -1 };// 상하좌우
		int[] dy4 = { 1, 0, -1, 0 };// 상하좌우

		sum = 0;
		boolean ch = true;
		for (int i = 0; i < 8; i++) { // 8번회전
			int t_r = r + dx[i];
			int t_c = c + dy[i];

			if (!isIn(t_r, t_c)) // 범위 확인
				continue;
			if (arr2D[t_r][t_c].equals("G")) // 주변이 G가 있으면 탈출
			{
				sum = 2;
				ch = false;
				break;
			}
		}

		// 주변에 B만 있는 좌표 탐색 완료

		if (ch) { // 주변에 G가 없으면 탐색시작 G가 있는애들은 알아서 sum=2가되고 무시됨
			for (int i = 0; i < 4; i++) {
				int t_r = 0;
				int t_c = 0;
				int tempr = r;
				int tempc = c;
				while (true) { // 이동방향 정한 후 그 방향으로 이동하며 B의 수 탐색
					t_r = tempr + dx4[i]; // 이동방향 선택
					t_c = tempc + dy4[i];
					if (!isIn(t_r, t_c))
						break;

					if (arr2D[t_r][t_c].equals("B")) {
						sum++;
						tempr = t_r;
						tempc = t_c;
					} else { //G일경우 무시하고 다음 탐색
						tempr = t_r;
						tempc = t_c;
					}
				}

			}
		}

		return sum;
	}

	public static boolean isIn(int r, int c) {
		if (r < 0 || r >= arr2D.length || c < 0 || c >= arr2D[r].length)
			return false;
		else
			return true;
	}

}
