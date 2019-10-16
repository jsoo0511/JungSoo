import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution_7206_숫자게임_이정수 {

	public static HashMap<Integer, Integer> hm;// N숫자, 쪼개진 횟수cnt

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= tc; testCase++) {
			int N = Integer.parseInt(br.readLine());
			hm = new HashMap<Integer, Integer>();

			System.out.println("#" + testCase + " " + f(N));

		}

	}

	public static int f(int N) {
		if (N < 10)
			return 0;
		String s = N + "";// 숫자를 문자열로 변환

		int len = s.length() - 1; // 쪼갤 수 있는 포인트 개수
		int maxCnt = 0;
		for (int i = 1; i < 1 << len; i++) {// 바이너리 카운팅
			int mul = 1;
			int num = s.charAt(0) - '0';

			for (int j = 0; j < len; j++) {

				if ((i & 1 << j) == 0) { // 안쪼갬
					num = num * 10 + s.charAt(j + 1) - '0';
				} else {// 쪼갬
					mul *= num; // 쪼개진 숫자는 누적 곱
					num = s.charAt(j + 1) - '0';

				}
			}

			mul *= num;// 마지막 숫자도 곱함

			int cnt;
			if (hm.containsKey(mul)) { // 구한적이 있음
				cnt = hm.get(mul);
			} else {
				cnt = f(mul);
				hm.put(mul, cnt);
			}
			if (maxCnt < cnt)
				maxCnt = cnt;

		}
		return maxCnt + 1;
	}

}
