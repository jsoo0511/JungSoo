import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3074_입국심사_이정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int tc=Integer.parseInt(br.readLine());

		for (int test = 1; test <= tc; test++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int N=Integer.parseInt(st.nextToken());//심사대
			int M=Integer.parseInt(st.nextToken());//입국인원
			
			int []t=new int[N];//심사대의 처리시간
			
			for(int i=0;i<t.length;i++) {
				t[i]=Integer.parseInt(br.readLine());//K번 심사대에서 심사하는데 걸리는 시간, 1 <= t[k] <= 10^9
				
			}
			
			long start=0;
			long end=1000000000L*M;
			long min=Long.MAX_VALUE;//최소시간
			
			//이진탐색
			while(start<=end) {
				long mid=(start+end)/2;
				
				//mid 시간이면 각 심사대에서 몇명씩 통과하는지 구하기(합)
				long sum=0;
				for(int i=0;i<t.length;i++) {
					sum+=mid/t[i];
				}
				
				//M명이 통과하는 최소시간을 찾는
				if(sum>=M) {//mid에 통과인원 >= M이면 범위를 줄여줌 end = mid -1;
                    if(min>mid)
                    	min=mid;
					end = mid -1;
				} else {//      <    이면 범위를 늘려줌 start = mid + 1;
					start = mid +1;
				}
			}
			System.out.println("#"+test+" "+min);
		}
		
	}

}
