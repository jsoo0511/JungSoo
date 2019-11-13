import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_4013_특이한자석_이정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int test = 1; test <= tc; test++) {
			int k = Integer.parseInt(br.readLine());

			int arr[][] = new int[4][8];
			int magnet = 0;
			int d = 0;
			for (int i = 0; i < 4; i++) {// 자석 초기화
				String s[] = br.readLine().split(" ");
				for (int j = 0; j < 8; j++) {
					arr[i][j] = Integer.parseInt(s[j]);
				}
			}
			int sum = 0;
			for (int i = 0; i < k; i++) {
				String str[] = br.readLine().split(" ");
				magnet = Integer.parseInt(str[0]) - 1;// 자석번호
				d = Integer.parseInt(str[1]);// 1 시계, -1 반시계

				if (d == 1) {
					int temp1 = arr[0][2];// 1의 접촉면
					int temp2l = arr[1][6];// 1-2의 접촉면
					int temp2r = arr[1][2];// 2-3의 접촉면
					int temp3l = arr[2][6];// 2-3의 접촉면
					int temp3r = arr[2][2];// 3-4의 접촉면
					int temp4 = arr[3][6];// 3-4의 접촉면

					if (magnet == 0) {
						int temp = arr[0][7];
						for (int a = 0; a < 7; a++) { // 0번 시계방향 이동
							arr[0][a + 1] = arr[0][a];
						}
						arr[0][0] = temp;
						if (temp1 != temp2l) {// 1-2번이 자성이 다른 경우

							temp = arr[1][0];
							for (int a = 7; a > 0; a--) {// 1번 반시계이동
								arr[1][a - 1] = arr[1][a];
							}
							arr[1][7] = temp;

							if (temp2r != temp3l) {// 2-3번이 다른 경우
								temp = arr[2][7];
								for (int a = 0; a < 7; a++) { // 2번 시계방향 이동
									arr[2][a + 1] = arr[2][a];
								}
								arr[2][0] = temp;

								if (temp3r != temp4) {// 3-4번이 다른 경우
									temp = arr[3][0];
									for (int a = 7; a > 0; a--) {// 3번 반시계이동
										arr[3][a - 1] = arr[3][a];
									}
									arr[3][7] = temp;
								}
							}
						}
					} else if (magnet == 1) {
						int temp = arr[1][7];
						for (int a = 0; a < 7; a++) { // 1번 시계방향 이동
							arr[1][a + 1] = arr[1][a];
						}
						arr[1][0] = temp;

						if (temp1 != temp2l) {// 1-2번이 자성이 다른 경우
							temp = arr[0][0];
							for (int a = 7; a > 0; a--) {// 0번 반시계이동
								arr[0][a - 1] = arr[0][a];
							}
							arr[0][7] = temp;
						}
						if (temp2r != temp3l) {// 2-3번이 다른 경우
							temp = arr[2][0];
							for (int a = 7; a > 0; a--) {// 2번 반시계이동
								arr[2][a - 1] = arr[2][a];
							}
							arr[2][7] = temp;
							if (temp3r != temp4) {// 3-4번이 다른 경우
								temp = arr[3][7];
								for (int a = 0; a < 7; a++) { // 3번 시계방향 이동
									arr[3][a + 1] = arr[3][a];
								}
								arr[3][0] = temp;
							}
						}
					} else if (magnet == 2) {
						int temp = arr[2][7];
						for (int a = 0; a < 7; a++) { // 2번 시계방향 이동
							arr[2][a + 1] = arr[2][a];
						}
						arr[2][0] = temp;

						if (temp2r != temp3l) {// 1-2번이 자성이 다른 경우
							temp = arr[1][0];
							for (int a = 7; a > 0; a--) {// 1번 반시계이동
								arr[1][a - 1] = arr[1][a];
							}
							arr[1][7] = temp;
							if (temp1 != temp2l) {
								temp = arr[0][7];
								for (int a = 0; a < 7; a++) { // 0번 시계방향 이동
									arr[0][a + 1] = arr[0][a];
								}
								arr[0][0] = temp;
							}
						}
						if (temp3r != temp4) {// 2-3번이 다른 경우
							temp = arr[3][0];
							for (int a = 7; a > 0; a--) {// 3번 반시계이동
								arr[3][a - 1] = arr[3][a];
							}
							arr[3][7] = temp;
						}
					} else { // 4번 자석 시계방향
						int temp = arr[3][7];
						for (int a = 0; a < 7; a++) { // 3번 시계방향 이동
							arr[3][a + 1] = arr[3][a];
						}
						arr[3][0] = temp;
						if (temp3r != temp4) {// 2-3번이 자성이 다른 경우

							temp = arr[2][0];
							for (int a = 7; a > 0; a--) {// 1번 반시계이동
								arr[2][a - 1] = arr[2][a];
							}
							arr[2][7] = temp;

							if (temp2r != temp3l) {// 1-2번이 다른 경우
								temp = arr[1][7];
								for (int a = 0; a < 7; a++) { // 2번 시계방향 이동
									arr[1][a + 1] = arr[1][a];
								}
								arr[1][0] = temp;

								if (temp != temp2l) {// 0-1번이 다른 경우
									temp = arr[0][0];
									for (int a = 7; a > 0; a--) {// 3번 반시계이동
										arr[0][a - 1] = arr[0][a];
									}
									arr[0][7] = temp;
								}
							}
						}
					}
				} else {// 반시계방향

					int temp1 = arr[0][2];// 1의 접촉면
					int temp2l = arr[1][6];// 1-2의 접촉면
					int temp2r = arr[1][2];// 2-3의 접촉면
					int temp3l = arr[2][6];// 2-3의 접촉면
					int temp3r = arr[2][2];// 3-4의 접촉면
					int temp4 = arr[3][6];// 3-4의 접촉면

					if (magnet == 0) {//
						int temp = arr[0][0];
						for (int a = 7; a > 0; a--) {// 0번 반시계이동
							arr[0][a - 1] = arr[0][a];
						}
						arr[0][7] = temp;
						if (temp1 != temp2l) {// 1-2번이 자성이 다른 경우

							temp = arr[1][7];
							for (int a = 0; a < 7; a++) { // 1번 시계방향 이동
								arr[1][a + 1] = arr[1][a];
							}
							arr[1][0] = temp;

							if (temp2r != temp3l) {// 2-3번이 다른 경우
								temp = arr[2][0];
								for (int a = 7; a > 0; a--) {// 2번 반시계이동
									arr[2][a - 1] = arr[2][a];
								}
								arr[2][7] = temp;

								if (temp3r != temp4) {// 3-4번이 다른 경우
									temp = arr[3][7];
									for (int a = 0; a < 7; a++) { // 3번 시계방향 이동
										arr[3][a + 1] = arr[3][a];
									}
									arr[3][0] = temp;
								}
							}
						}
					} else if (magnet == 1) {
						int temp = arr[1][0];
						for (int a = 7; a > 0; a--) {// 1번 반시계이동
							arr[1][a - 1] = arr[1][a];
						}
						arr[1][7] = temp;

						if (temp1 != temp2l) {// 0-1번이 자성이 다른 경우
							temp = arr[0][7];
							for (int a = 0; a < 7; a++) { // 0번 시계방향 이동
								arr[0][a + 1] = arr[0][a];
							}
							arr[0][0] = temp;
						}
						if (temp2r != temp3l) {// 1-2번이 다른 경우
							temp = arr[2][7];
							for (int a = 0; a < 7; a++) { // 2번 시계방향 이동
								arr[2][a + 1] = arr[2][a];
							}
							arr[2][0] = temp;
							if (temp3r != temp4) {// 3-4번이 다른 경우
								temp = arr[3][0];
								for (int a = 7; a > 0; a--) {// 1번 반시계이동
									arr[3][a - 1] = arr[3][a];
								}
								arr[3][7] = temp;
							}
						}
					} else if (magnet == 2) {
						int temp = arr[2][0];
						for (int a = 7; a > 0; a--) {// 2번 반시계이동
							arr[2][a - 1] = arr[2][a];
						}
						arr[2][7] = temp;

						if (temp2r != temp3l) {// 1-2번이 자성이 다른 경우
							temp = arr[1][7];
							for (int a = 0; a < 7; a++) { // 1번 시계방향 이동
								arr[1][a + 1] = arr[1][a];
							}
							arr[1][0] = temp;
							if (temp1 != temp2l) {
								temp = arr[0][0];
								for (int a = 7; a > 0; a--) {// 0번 반시계이동
									arr[0][a - 1] = arr[0][a];
								}
								arr[0][7] = temp;
							}
						}
						if (temp3r != temp4) {// 2-3번이 다른 경우
							temp = arr[3][7];
							for (int a = 0; a < 7; a++) { // 3번 시계방향 이동
								arr[3][a + 1] = arr[3][a];
							}
							arr[3][0] = temp;
						}
					} else { // 3번 자석 반시계방향
						int temp = arr[3][0];
						for (int a = 7; a > 0; a--) {// 3번 반시계이동
							arr[3][a - 1] = arr[3][a];
						}
						arr[3][7] = temp;
						if (temp3r != temp4) {// 2-3번이 자성이 다른 경우

							temp = arr[2][7];
							for (int a = 0; a < 7; a++) { // 2번 시계방향 이동
								arr[2][a + 1] = arr[2][a];
							}
							arr[2][0] = temp;

							if (temp2r != temp3l) {// 1-2번이 다른 경우
								temp = arr[1][0];
								for (int a = 7; a > 0; a--) {// 1번 반시계이동
									arr[1][a - 1] = arr[1][a];
								}
								arr[1][7] = temp;

								if (temp != temp2l) {// 0-1번이 다른 경우
									temp = arr[0][7];
									for (int a = 0; a < 7; a++) { // 0번 시계방향 이동
										arr[0][a + 1] = arr[0][a];
									}
									arr[0][0] = temp;
								}
							}
						}
					}
				}
				
			  for(int r=0;r<4;r++) {
				  for(int c=0;c<8;c++) {
					  System.out.print(arr[r][c]+" ");
				  }
				  System.out.println();
			  }
			} // 회전

			if (arr[0][0] == 1)
				sum += 1;
			if (arr[1][0] == 1)
				sum += 2;
			if (arr[2][0] == 1)
				sum += 4;
			if (arr[3][0] == 1)
				sum += 8;

			System.out.println("#" + test + " " + sum);

		} // test

	}// main

}
