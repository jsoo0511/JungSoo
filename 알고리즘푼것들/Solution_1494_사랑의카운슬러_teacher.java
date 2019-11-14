import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1494_사랑의카운슬러_teacher {

	private static int R;
	private static int[][] map;
	private static int sumX;
	private static int sumY;
	private static long min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int test=1;test<=tc;test++) {
			int N = Integer.parseInt(br.readLine());
			map=new int[N][2];
			sumX=0;
			sumY=0;
			for(int i=0;i<N;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine()," ");
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
				sumX+=map[i][0];
				sumY+=map[i][1];
			}
			//조합
		min=Long.MAX_VALUE;
		comb(N,N/2,0,0);
		StringBuilder sb=new StringBuilder();
		sb.append('#').append(test).append(' ').append(min);
		System.out.println(sb);
	
		} //end testcase
		
	} //end main
	/** nCr, selX,selY :현재까지 선택한 지렁이의 합 */
	public static void comb(int n,int r,int selX, int selY) {
		if(r==0) {
			long vX=selX*2-sumX;
			long vY=selY*2-sumY;
			long v=vX*vX+vY*vY;
			if(min>v) min=v;
		    return;
		} else if(n<r) {
			return;
		} else { //재귀파트
			comb(n-1,r-1,selX+map[n-1][0],selY+map[n-1][1]);// 현재 뽑은 것을 사용하는 경우
			comb(n-1,r,selX,selY);  // 현재 뽑은 것을 사용안하고 다시 뽑는 경우
		}
	}

}
