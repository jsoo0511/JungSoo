import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 그냥 코딩 204ms
 * 한명을 고정 180ms
 * 한명을 고정, if(min==0) 가지치기  96ms
 * @author student
 *
 */
public class Main_백준_14889_스타트와링크_강사님 {

	private static int N;
	private static int[][] m;
	private static int[] trr;
	private static int min;
	private static int[] orr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		m=new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				m[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		min=Integer.MAX_VALUE;
		
		trr=new int[N/2]; //스타트 팀
		orr=new int[N/2]; //링크팀
		trr[N/2-1]=N-1;//한 명 스타트팀에 고정
		comb(N-1,N/2-1);
		System.out.println(min);//두 팀의 능력치 차의 최소값

	}
	
	public static void comb(int n, int r) {
		if(min==0) //최소값은 0보다 낮을 수 없으므로 0되면 바로 return
			return;
		if(r==0) {
			//선택되지 않은 배열 orr을 구하는 작업
			for(int i=0, tIndex=0, oIndex=0;i<N;i++) {
				if(i==trr[tIndex]) {
					tIndex++;
				} else {
					orr[oIndex++]=i;
				}
			}
			check();//trr,orr팀의 능력치 합을 구해서 차이 => 최소값
		} else if(n<r){
			return;
		} else {
			trr[r-1]=n-1;
			comb(n-1,r-1);
			comb(n-1,r);
		}
	}
    /** trr팀과 orr팀의 능력치 합 구해서 차의 최소값을 업데이트*/
	private static void check() {
		int t=0; //trr팀의 능력치 합
		for(int i=0;i<trr.length;i++) {
			for(int j=0;j<trr.length;j++) {
				t+=m[trr[i]][trr[j]];
			}
		}
		
		int o=0; //trr팀의 능력치 합
		for(int i=0;i<orr.length;i++) {
			for(int j=0;j<orr.length;j++) {
				o+=m[orr[i]][orr[j]];
			}
		}
		
		int diff=t-o;
		if(diff<0)
			diff= -diff;
		if(min>diff)
			min=diff;
		
	}

}
