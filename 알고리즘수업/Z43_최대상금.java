package 알고리즘수업_Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Z43_최대상금 {
	private static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int test = 1; test <= tc; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String s = st.nextToken(); // 숫자판의 숫자들
			int[] num = new int[s.length()];
			for (int i = 0; i < num.length; i++) {
				num[i] = s.charAt(i) - '0';
			}
			int N = Integer.parseInt(st.nextToken());// 교환 횟수
			max = 0;// 만들수있는 숫자판의 최대값을 저장
			find(num, N);
			
			System.out.println("#"+test+" "+max);
		}//end testCase

	}// end main
	public static HashSet<String> s=new HashSet<String>();
    /** num:숫자판 배열, N:교환 횟수*/
	public static void find(int[]num, int N) {
		int val=0;//숫자판 배열을 숫자값을 변환
		
		for(int i=0;i<num.length;i++) {
			val=val*10+num[i];
		}
		
		//가지치기
		String str=""+val+N;//만들어진숫자와 교환횟수를 붙여서 문자열로 저장
		
		if(s.contains(str)) {//중복 체크
			return;
		} else {
		s.add(str); //사용한 정보를 저장해놓음
		}
		
		if(N==0) {//종료파트, 최대값이 되었는지 확인
			if(max<val)
				max=val;
		} else {//교환을 1번 바꿀 수 있는 모든 경우를 만들어서 재귀 호출
			for(int i=0;i<num.length;i++) {
				for(int j=i+1;j<num.length;j++) {
					//i<->j swap
					int temp=num[i];
					num[i]=num[j];
					num[j]=temp;
					
					
					find(num,N-1);//재귀호출
					//i<->j 원상복구
					temp=num[i];
					num[i]=num[j];
					num[j]=temp;
				}
			}
			
		}
	}
}// end class
