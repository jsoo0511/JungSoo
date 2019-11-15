import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3378_스타일리쉬들여쓰기_이정수 {
	static int[][] m;
     static int[][] dap;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int test = 1; test <= tc; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken()); // 스타일리쉬 코드 줄 수 1<= p,q <=10
			int q = Integer.parseInt(st.nextToken()); // 당신의 코드 줄 수
			m = new int[p][4]; // 위에서부터 누적한 괄호의 개수, [0].,[1]소,[2]중,[3]대
			
			for (int i = 0; i < p; i++) {// 스타일러쉬 코드 분석 결과
				String line = br.readLine();

				int index = 0;
				while (line.charAt(index) == '.') {
					index++;
				}
				m[i][0] = index;// .의 개수
				if (i > 0) {// 누적한 괄호의 개수
					m[i][1] = m[i - 1][1];// 소괄호의 개수
					m[i][2] = m[i - 1][2];// 중괄호의 개수
					m[i][3] = m[i - 1][3];// 대괄호의 개수
				}
				
				for(int j=index; j<line.length();j++) {
					switch (line.charAt(j)) {
					case '(': m[i][1]++; break;
					case ')': m[i][1]--; break;
					case '{': m[i][2]++; break;
					case '}': m[i][2]--; break;
					case '[': m[i][3]++; break;
					case ']': m[i][3]--; break;
					}
				}
				
				
			}
			dap = new int[q][4]; // 위에서부터 누적한 괄호의 개수, [0].,[1]소,[2]중,[3]대
			for (int i = 0; i < q; i++) {//당신의 코드 분석 결과
				String line = br.readLine();

				int index = 0;
				
				if (i > 0) {// 누적한 괄호의 개수
				    dap[i][1] = dap[i - 1][1];// 소괄호의 개수
				    dap[i][2] = dap[i - 1][2];// 중괄호의 개수
				    dap[i][3] = dap[i - 1][3];// 대괄호의 개수
				}
				
				for(int j=index; j<line.length();j++) {
					switch (line.charAt(j)) {
					case '(':dap[i][1]++; break;
					case ')':dap[i][1]--; break;
					case '{':dap[i][2]++; break;
					case '}':dap[i][2]--; break;
					case '[':dap[i][3]++; break;
					case ']':dap[i][3]--; break;
					}        
				}
			}
			
			//내 코드를 분석한  dap의 .의 개수 열을 사용하지 않는 값 -2로 초기화 하자
			for(int i=0;i<q;i++) {
				dap[i][0]=-2;//초기화
			}
			
			for(int R=1;R<=20;R++) {
				for(int C=1;C<=20;C++) {
					for(int S=1;S<=20;S++) {
						if(check(R,C,S)) {//마스터 코드에서 답이 맞는지 체크
							cal(R,C,S);//구한 답RCS값을 내 코드에 적용했을때 각줄의 답을 구하기
						}
					}
				}
			}
			
		   
		   System.out.print("#"+test+" 0");
		   for (int i = 1; i < dap.length; i++) {
			System.out.print(" "+dap[i][0]);
		}
		   System.out.println();
			
		}//end if testCase
	}// end of main
	
	/**내 코드에서 RCS 값으로 .의 개수를 구하기*/
    private static void cal(int R, int C, int S) {
		for (int i = 1; i < dap.length; i++) {
			int x = dap[i-1][1] * R + dap[i-1][2] * C + dap[i-1][3] * S;//다음 줄의 .의 개수
			if(dap[i][0]==-2) {//처음 들어온 것이라면
				dap[i][0]=x;//저장
			} else if(dap[i][0]==-1) {//유일한 해가 아니면
				
			} else if(dap[i][0] !=x) {//이전에 답은 구한적 있는데, 현재 계산한 결과와 다르면, 해가 여러개
				dap[i][0]=-1;//유일한 해가 아니다.
			}
			
		}
		
	}


	/**스타일리쉬 코드에서 RCS 값이 맞는지 체크*/
	private static boolean check(int R, int C, int S) {
		for(int i=1;i<m.length;i++) {
			if(m[i][0]!=m[i-1][1]*R+m[i-1][2]*C+m[i-1][3]*S) {
				return false; //한번이라도 틀리면 답이 아니다.
			}
		}
		return true;
	}

}// end of class
