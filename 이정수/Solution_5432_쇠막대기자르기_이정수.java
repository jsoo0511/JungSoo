import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_5432_쇠막대기자르기_이정수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		Stack<String> st;
		String last = "";// 마지막 pop값
		int sum = 0;
		for (int test = 1; test <= tc; test++) {
			sum=0;
			st = new Stack<>();
			String s[]=br.readLine().split("");
			for(int i=0;i<s.length;i++) {
				if(s[i].equals("(")) {
					st.push("(");
					last="(";
				}
				
				else {
					if(last.equals("(")) {
						st.pop();
						last=")";
						sum+=st.size();
					}
					else {
						sum+=1;
						st.pop();
					}
				}
			}
			System.out.println("#"+test+" "+sum);

		}
	}
}