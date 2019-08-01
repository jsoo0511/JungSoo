import java.util.Arrays;
import java.util.Scanner;

public class Solution_1224_SW문제해결기본6일차_계산기3_이정수 {
	static int num[];
	static char[] stackOp;
	static int top;
	static int topNum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int j = 0; j < 10; j++) {
			top=-1;
			topNum=-1;
			int n=Integer.parseInt(sc.nextLine());
			String s =sc.nextLine();
			String[] str = s.split("");
			num = new int[n];
			stackOp = new char[n];
			top = -1;

			for (int i = 0; i < str.length; i++) {
				char c = str[i].charAt(0);
				switch (c) {
				case '(':
					stackOp[++top] = c;
					break;
				case '*':
				case '/':
					if (top > -1 && (stackOp[top] == '*' || stackOp[top] == '/')) {
						while (top > -1 && (stackOp[top] == '*' || stackOp[top] == '/')) {
							operation(stackOp[top--]);
						}
					}
					stackOp[++top] = c;
					break;
				case '+':
				case '-':
					if (top > -1 && !(stackOp[top] == '(')) {
						while (top > -1 && !(stackOp[top] == '(')) {
							operation(stackOp[top--]);
						}
					}
					stackOp[++top] = c;
					break;
				case ')':
					while (top > -1 && !(stackOp[top] == '(')) {
						operation(stackOp[top--]);
					}
					top--;
					break;
				default:
					num[++topNum] = Integer.parseInt(str[i]);
				}
			} // end of for
			while (top > -1) {
				operation(stackOp[top--]);
			}
			System.out.printf("#%d %d\n", j+1,num[0]);
		}
	}// end of main

	public static void operation(char op) {
		switch (op) {
		case '*':
			num[topNum - 1] *= num[topNum];
			topNum--;
			break;
		case '/':
			num[topNum - 1] /= num[topNum];
			topNum--;
			break;
		case '+':
			num[topNum - 1] += num[topNum];
			topNum--;
			break;
		case '-':
			num[topNum - 1] -= num[topNum];
			topNum--;
			break;
		default:
			break;
		}

	}
}// end of class
