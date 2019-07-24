
import java.util.Scanner;

public class Solution_1210_SW문제해결기본2일차_Ladder1_이정수 {
	static int dx[] = { -1, 0, 1 }; // //좌상우
	static int dy[] = { 0, -1, 0 };
	static int des_r;
	static int arr[][];
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[100][100];
		
		for (int test = 1; test <= 10; test++) {
			int n=sc.nextInt();
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			/*
			 * for(int r=0;r<10;r++) { //배열초기화 확인 for(int c=0;c<10;c++)
			 * System.out.print(arr[c][r]); System.out.println(); }
			 */

			for (int r = 0; r < 100; r++) {
				if (arr[99][r] == 2) {
					des_r = r;// 도착점 복사
					break;
				}
			}
		
            System.out.print("#"+test+" "); 
			Move(99, des_r);
			
		}
	}

	public static void Move(int r, int c) {
		int temp_r = r;
		int temp_c = c;
		
		boolean flag = false;
		//System.out.println(temp_c + " " + temp_r + "에서 탐색시작");
		if (isIn(temp_r + dy[0], temp_c + dx[0]) && arr[temp_r + dy[0]][temp_c + dx[0]] == 1) { // 왼쪽이 1이면
			arr[temp_r][temp_c] = 0; // 지나온곳 0으로 바꿈
		//	System.out.println(temp_c + " " + temp_r + "에서 왼쪽으로 이동해서 " + (temp_c + dx[0]) + ", " + (temp_r + dy[0]));
			Move(temp_r + dy[0], temp_c + dx[0]); // 왼쪽으로 이동
		} else if (isIn(temp_r + dy[2], temp_c + dx[2]) && arr[temp_r + dy[2]][temp_c + dx[2]] == 1) { // 오른쪽이 1이면
			arr[temp_r][temp_c] = 0; // 지나온곳 0으로 바꿈
		//	System.out.println(temp_c + " " + temp_r + "에서 오른쪽으로 이동해서 " + (temp_c + dx[2]) + ", " + (temp_r + dy[2]));
			Move(temp_r + dy[2], temp_c + dx[2]); // 오른쪽으로 이동
		} else if (isIn(temp_r + dy[1], temp_c + dx[1]) && arr[temp_r + dy[1]][temp_c + dx[1]] == 1) { // 위로 이동
		//	System.out.println(temp_c + " " + temp_r + "에서 위쪽으로 이동해서 " + (temp_c + dx[1]) + ", " + (temp_r + dy[1]));
			arr[temp_r][temp_c] = 0; // 지나온곳 0으로 바꿈
			if (temp_r + dy[1] == 0) // 위로갔을때 천장에 다다르면 flag true로 바꿈
			{
				flag = true;
			}
			Move(temp_r + dy[1], temp_c + dx[1]); // 위쪽으로 이동
		}

		if (flag)
			System.out.println(temp_c);

	}

	public static boolean isIn(int x, int y) {
		if (x < 0 || x > 99 || y < 0 || y > 99)
			return false;
		return true;
	}

}
