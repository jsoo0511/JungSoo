package 알고리즘수업_Z;

import java.util.Stack;

public class Z35_연습문제2 {

	public static void main(String[] args) {
		char[] s = { '0', 'F', '9', '7', 'A', '3' };
		int result = 0;
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < s.length; i++) {
			if (s[i] - '0' >= 0 && s[i] - '0' <= 9)
				result += (s[i] - '0') * (int) Math.pow(16, s.length - 1 - i);
			else
				result += (s[i] - 55) * (int) Math.pow(16, s.length - 1 - i);
		}
		int n;
		while (result != 0 && result != 1) {
			n = result % 2;
			result = result / 2;
			st.push(n);
		}
		st.push(result);// 마지막 남은 값 삽입
		while (true) {
			if (st.size() != s.length * 4) {
				st.push(0);
			} else
				break;
		}
		System.out.print("이진수: ");
		while (!st.isEmpty()) {
			System.out.print(st.pop());
		}

	}

}
