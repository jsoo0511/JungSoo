package 알고리즘수업_Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Z40_회의실_T {
	/**회의 나라를 추상화 한 클래스*/
	public static class Meet{
		int sTime;
		int eTime;
		public Meet(int sTime, int eTime) {
			this.sTime = sTime;
			this.eTime = eTime;
		}
		@Override
		public String toString() {
			return "[" + sTime + "," + eTime + "]";
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine()); //회의 개수
		Meet[] m=new Meet[N];
		
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			m[i]=new Meet(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		//정렬,기준 : 종료시간
		//빨리끝나는 회의부터 선택, 선택된 회의와 겹치는 시간은 제거
		Arrays.sort(m,new Comparator<Meet>() {

			@Override
			public int compare(Meet o1, Meet o2) {
				return o1.eTime-o2.eTime; //종료시간 기준으로 오름차순 종렬
			}
		});
		
		//회의가 겹치지않도록 : 선택된 회의의 가장 마지막 종료 시간보다 먼저 시작한 회의는 제거, 종료시간 이후에 시작한 회의를 선택한다.
		int end=m[0].eTime;
		System.out.println(m[0]); //가장 빨리 끝나는 회의 선택함
		for(int i=0;i<m.length;i++) {
			if(end<=m[i].sTime) {
				System.out.println(m[i]);
				end=m[i].eTime; //선택한 회의 중 가장 마지막 종료시간 업데이트
			}
		}

	}

}
