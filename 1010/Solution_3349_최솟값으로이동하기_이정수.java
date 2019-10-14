import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_3349_최솟값으로이동하기_이정수 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		
		for(int test=1;test<=tc;test++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int W=Integer.parseInt(st.nextToken());//열
			int H=Integer.parseInt(st.nextToken());//행
			int N=Integer.parseInt(st.nextToken());//입력좌표개수
			
			int val=0; //이동비용의 최소값
			st=new StringTokenizer(br.readLine()," ");
			int preX=Integer.parseInt(st.nextToken());//첫번째 받은 열
			int preY=Integer.parseInt(st.nextToken());
			
			for(int i=1;i<N;i++) {//좌표의 입력
				st=new StringTokenizer(br.readLine()," ");
				int x=Integer.parseInt(st.nextToken());//첫번째 받은 열
				int y=Integer.parseInt(st.nextToken());
				
				int dx=x-preX;
				int dy=y-preY;
				
				boolean cross=(dx>0 && dy>0) || (dx<0 && dy<0); //우측 상단 방향이면, 대각 경로를 이용할 수 있는 경우
				if(dy<0) dy=-dy; //절대값 구하기
				if(dx<0) dx=-dx;
				
				if(cross) { //대각 경로를 이용할 수 있다면
					val+= dx<=dy ? dy: dx;
				} else {
					val+=dx+dy;
				}
				preX=x;
				preY=y;
			}
			
			System.out.println("#"+test+" "+val);
		}
		
		
		
	   

	}
	
	

}
