import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1873_상호의배틀필드_이정수 {
	static char arr[][];
	static int h, w;
	static int po_h, po_w;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int test = 1; test <= tc; test++) {
			int rotate = 0;
			String s[] = br.readLine().split(" ");
			h = Integer.parseInt(s[0]);
			w = Integer.parseInt(s[1]);
			arr = new char[h][w];
			for (int i = 0; i < h; i++) { // 전장초기화
				char[] ch = br.readLine().toCharArray();
				for (int j = 0; j < w; j++) {
					arr[i][j] = ch[j];
				}
			}
			int num_order = Integer.parseInt(br.readLine());
			char[] order = br.readLine().toCharArray();

			for (int i = 0; i < h; i++) { // 전차위치 탐색
				for (int j = 0; j < w; j++) {
					if (arr[i][j] == '<') {// 좌
						po_h = i;
						po_w = j;
						rotate = 4;
						break;
					} else if (arr[i][j] == '>') {// 우
						po_h = i;
						po_w = j;
						rotate = 2;
						break;
					} else if (arr[i][j] == '^') {// 상
						po_h = i;
						po_w = j;
						rotate = 1;
						break;
					} else if (arr[i][j] == 'v') {// 하
						po_h = i;
						po_w = j;
						rotate = 3;
						break;
					}
				}
			}

			for (int i = 0; i < num_order; i++) {
				if (rotate == 1) {
					if (order[i] == 'S') {
						shoot(rotate, po_h, po_w);

					} else if (order[i] == 'D') {
						rotate = 3; // 아래로 방향 바꿈
						arr[po_h][po_w] = 'v';
						if (isRange(po_h + 1, po_w) && arr[po_h + 1][po_w] == '.') {// 아래가 평지라면
							arr[po_h][po_w] = '.';
							po_h += 1;// 아래로 좌표 이동
							arr[po_h][po_w] = 'v';
						}
					} else if (order[i] == 'L') {
						rotate = 4; // 좌로 방향 바꿈
						arr[po_h][po_w] = '<';
						if (isRange(po_h, po_w - 1) && arr[po_h][po_w - 1] == '.') {// 좌가 평지라면
							arr[po_h][po_w] = '.';
							po_w -= 1;// 좌로 좌표 이동
							arr[po_h][po_w] = '<';

						}
					} else if (order[i] == 'R') {
						rotate = 2; // 우로 방향 바꿈
						arr[po_h][po_w] = '>';
						if (isRange(po_h, po_w + 1) && arr[po_h][po_w + 1] == '.') {// 우가 평지라면
							arr[po_h][po_w] = '.';
							po_w += 1;// 우로 좌표 이동
							arr[po_h][po_w] = '>';

						}
					} else {
						rotate = 1;
						arr[po_h][po_w] = '^';
						if (isRange(po_h - 1, po_w) && arr[po_h - 1][po_w] == '.') {
							arr[po_h][po_w] = '.';
							po_h -= 1;
							arr[po_h][po_w] = '^';

						}
					}
				} else if (rotate == 2) {
					if (order[i] == 'S') {
						shoot(rotate, po_h, po_w);

					} else if (order[i] == 'D') {
						rotate = 3; // 아래로 방향 바꿈
						arr[po_h][po_w] = 'v';
						if (isRange(po_h + 1, po_w) && arr[po_h + 1][po_w] == '.') {// 아래가 평지라면
							arr[po_h][po_w] = '.';
							po_h += 1;// 아래로 좌표 이동
							arr[po_h][po_w] = 'v';

						}
					} else if (order[i] == 'L') {
						rotate = 4; // 좌로 방향 바꿈

						arr[po_h][po_w] = '<';
						if (isRange(po_h, po_w - 1) && arr[po_h][po_w - 1] == '.') {// 좌가 평지라면
							arr[po_h][po_w] = '.';
							po_w -= 1;// 좌로 좌표 이동
							arr[po_h][po_w] = '<';
						}
					} else if (order[i] == 'R') {
						rotate = 2; // 우로 방향 바꿈
						arr[po_h][po_w] = '>';
						if (isRange(po_h, po_w + 1) && arr[po_h][po_w + 1] == '.') {// 우가 평지라면
							arr[po_h][po_w] = '.';
							po_w += 1;// 우로 좌표 이동
							arr[po_h][po_w] = '>';

						}
					} else {
						rotate = 1;

						arr[po_h][po_w] = '^';
						if (isRange(po_h - 1, po_w) && arr[po_h - 1][po_w] == '.') {
							arr[po_h][po_w] = '.';
							po_h -= 1;
							arr[po_h][po_w] = '^';

						}
					}
				} else if (rotate == 3) {
					if (order[i] == 'S') {
						shoot(rotate, po_h, po_w);
					} else if (order[i] == 'D') {
						rotate = 3; // 아래로 방향 바꿈

						arr[po_h][po_w] = 'v';
						if (isRange(po_h + 1, po_w) && arr[po_h + 1][po_w] == '.') {// 아래가 평지라면
							arr[po_h][po_w] = '.';
							po_h += 1;// 아래로 좌표 이동
							arr[po_h][po_w] = 'v';

						}
					} else if (order[i] == 'L') {
						rotate = 4; // 좌로 방향 바꿈

						arr[po_h][po_w] = '<';
						if (isRange(po_h, po_w - 1) && arr[po_h][po_w - 1] == '.') {// 좌가 평지라면
							arr[po_h][po_w] = '.';
							po_w -= 1;// 좌로 좌표 이동
							arr[po_h][po_w] = '<';
						}
					} else if (order[i] == 'R') {
						rotate = 2; // 우로 방향 바꿈

						arr[po_h][po_w] = '>';
						if (isRange(po_h, po_w + 1) && arr[po_h][po_w + 1] == '.') {// 우가 평지라면
							arr[po_h][po_w] = '.';
							po_w += 1;// 우로 좌표 이동
							arr[po_h][po_w] = '>';
						}
//						System.out.println("우로이동");
//						for(int k=0;k<h;k++) {
//							for(int j=0;j<w;j++) {
//								System.out.print(arr[k][j]);
//							}
//							System.out.println();
//						}
//						System.out.println();
					} else {
						rotate = 1;

						arr[po_h][po_w] = '^';
						if (isRange(po_h - 1, po_w) && arr[po_h - 1][po_w] == '.') {
							arr[po_h][po_w] = '.';
							po_h -= 1;
							arr[po_h][po_w] = '^';

						}
					}
				} else if (rotate == 4) { // 왼쪽방향
					if (order[i] == 'S') { // 좌로발사
						shoot(4, po_h, po_w);

					} else if (order[i] == 'D') {
						rotate = 3; // 아래로 방향 바꿈

						arr[po_h][po_w] = 'v';
						if (isRange(po_h + 1, po_w) && arr[po_h + 1][po_w] == '.') {// 아래가 평지라면
							arr[po_h][po_w] = '.';
							po_h += 1;// 아래로 좌표 이동
							arr[po_h][po_w] = 'v';

						}
					} else if (order[i] == 'L') {
						rotate = 4; // 좌로 방향 바꿈

						arr[po_h][po_w] = '<';
						if (isRange(po_h, po_w - 1) && arr[po_h][po_w - 1] == '.') {// 좌가 평지라면
							arr[po_h][po_w] = '.';
							po_w -= 1;// 좌로 좌표 이동
							arr[po_h][po_w] = '<';
						}
					} else if (order[i] == 'R') {
						rotate = 2; // 우로 방향 바꿈

						arr[po_h][po_w] = '>';
						if (isRange(po_h, po_w + 1) && arr[po_h][po_w + 1] == '.') {// 우가 평지라면
							arr[po_h][po_w] = '.';
							po_w += 1;// 우로 좌표 이동
							arr[po_h][po_w] = '>';
						}
					} else if (order[i] == 'U') {
						rotate = 1;
						arr[po_h][po_w] = '^';
						if (isRange(po_h - 1, po_w) && arr[po_h - 1][po_w] == '.') {
							arr[po_h][po_w] = '.';
							po_h -= 1;
							arr[po_h][po_w] = '^';
						}
					}
				}

			}
			System.out.print("#" + test + " ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}

		}
	} // end main

	public static void shoot(int rotate, int r, int c) {
		if (rotate == 1) {
			for (int i = r - 1; i >= 0; i--) {// 위로발사
				if (isRange(i, c)) {
					if (arr[i][c] == '#') {// 강철벽이라면
						break; // 아무일도 안일어남
					} else if (arr[i][c] == '*') {// 벽돌벽이라면
						arr[i][c] = '.';// 평지가 됨,계속 진행
						break;
					} else
						continue;

				} else
					break;
			}
		} else if (rotate == 2) {
			for (int i = c + 1; i < w; i++) {// 우로발사
				if (isRange(r, i)) {
					if (arr[r][i] == '#') {// 강철벽이라면
						break; // 아무일도 안일어남
					} else if (arr[r][i] == '*') {// 벽돌벽이라면
						arr[r][i] = '.';// 평지가 됨
						break;
					} else
						continue;

				} else
					break;
			}
		} else if (rotate == 3) {
			for (int i = r + 1; i < h; i++) {// 아래로발사
				if (isRange(i, c)) {
					if (arr[i][c] == '#') {// 강철벽이라면
						break; // 아무일도 안일어남
					} else if (arr[i][c] == '*') {// 벽돌벽이라면
						arr[i][c] = '.';// 평지가 됨
						break;
					} else
						continue;

				} else
					break;
			}
		} else {
			for (int i = c - 1; i >= 0; i--) {// 좌로발사
				if (isRange(r, i)) {
					if (arr[r][i] == '#') {// 강철벽이라면
						break; // 아무일도 안일어남
					} else if (arr[r][i] == '*') {// 벽돌벽이라면
						arr[r][i] = '.';// 평지가 됨
						break;
					} else
						continue;

				} else
					break;
			}
		}

	}

	public static boolean isRange(int r, int c) {
		if (r >= 0 && r < h && c >= 0 && c < w)
			return true;
		else
			return false;
	}

}
