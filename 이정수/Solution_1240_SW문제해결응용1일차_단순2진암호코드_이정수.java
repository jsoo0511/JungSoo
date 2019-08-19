import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1240_SW문제해결응용1일차_단순2진암호코드_이정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int temp[];
		String pw[] = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
				"0110111", "0001011" };
		for (int test = 1; test <= tc; test++) {
			String s1[] = br.readLine().split(" ");
			int n = Integer.parseInt(s1[0]);
			int m = Integer.parseInt(s1[1]);
			int arr[][] = new int[n][m];
			temp = new int[56];
			int answer=0;
			int row = 0, col = 0;
			int cnt = 0;
			int result[] = new int[8];
			boolean flag = true;
			for (int i = 0; i < n; i++) {
				String[] s = br.readLine().split("");
				for (int j = 0; j < m; j++) {
					arr[i][j] = Integer.parseInt(s[j]);
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = m - 1; j >= 0; j--) {// 열뒤부터 탐색
					if (arr[i][j] == 1) {
						row = i;
						col = j - 55;
						flag = false;
						break; // 1찾으면 탈출
					}
				}
				if (!flag)
					break;
			}
			String[] js=new String[8];
			int num=0;
			for(int i=0;i<8;i++) { //한줄씩 저장
				js[i]=new String();
				for(int j=0;j<7;j++) {
					num=arr[row][col++];
					js[i]+=Integer.toString(num);
				}
			}
			boolean check=false;
			for(int i=0;i<8;i++) {
				check=false;
				for(int j=0;j<10;j++) {
					if(js[i].equals(pw[j])) { //7자리 숫자가 pw에 존재한다면
						check=true;
						result[cnt++]=j;
						break; //1자리 pw체크 후 탈출 후 새로운 자리 체크
					}
				}
				if(!check) { //pw에 존재하지 않으면 볼필요 없음
					answer=0;
					break;
				}
			}
			
			answer=(result[0]+result[2]+result[4]+result[6])*3+(result[1]+result[3]+result[5]+result[7]);
			if(answer%10 !=0)
				answer=0;
			else {
				answer=0;
				for(int i=0;i<8;i++)
					answer+=result[i];
			}
			
			System.out.println("#"+test+" "+answer);
		}

	}

}
