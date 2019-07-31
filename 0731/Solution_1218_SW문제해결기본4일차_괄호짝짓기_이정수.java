import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1218_SW문제해결기본4일차_괄호짝짓기_이정수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1;tc<=10;tc++) {
			int num=Integer.parseInt(br.readLine());
			String s[]=br.readLine().split("");
			Stack<String> st= new Stack<>();
			boolean ch=true;
			for(int i=0;i<s.length;i++) {
				if(s[i].equals("(") || s[i].equals("{") || s[i].equals("[") || s[i].equals("<")) {
					st.push(s[i]);
				}
				else if(s[i].equals(")")) {
					if(!st.peek().equals("(")) {
						ch=false;
						break;
					}
					else
						st.pop();
				} else if(s[i].equals("}")) {
					if(!st.peek().equals("{")) {
						ch=false;
						break;
					}
					else
						st.pop();
				} else if(s[i].equals("]")) {
					if(!st.peek().equals("[")) {
						ch=false;
						break;
					}
					else
						st.pop();
				} else if(s[i].equals(">")) {
					if(!st.peek().equals("<")) {
						ch=false;
						break;
					}
					else
						st.pop();
				}
			}
		
			if(!ch) //유효하지않음
				System.out.println("#"+tc+" "+0);
			else //유효함
				System.out.println("#"+tc+" "+1);
		}

	}

}
