import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution_1258_행렬찾기_이정수 {
	public static class Start implements Comparable<Start>{
		int r,c;
		int val;

		public Start(int r, int c) {
			this.r = r;
			this.c = c;
			this.val=r*c;
		}

		@Override
		public int compareTo(Start o) {
			// TODO Auto-generated method stub
			int val1=this.val;
			int val2=o.val;
			if(val1==val2)
				return this.r-o.r;
			return this.val-o.val;
		}
		@Override
		public String toString() {
			return "Start [r=" + r + ", c=" + c + ", val=" + val + "]";
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int arr[][];
		int n;
		int r,rNum;
		int c,cNum;
		int count;
		ArrayList<Start> list;
		boolean visited[][];
		for(int test=1;test<=tc;test++) {
			count=0;
			n=Integer.parseInt(br.readLine());
			arr=new int[n][n];
			list=new ArrayList<>();
			visited=new boolean[n][n];
			r=0;
			c=0;
			for(int i=0;i<n;i++) { //배열초기화
				String []s=br.readLine().split(" ");
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(s[j]);
				}
			}
			
			for(int i=0;i<n;i++) { //탐색시작
				for(int j=0;j<n;j++) {
					rNum=0; //행의길이
					cNum=0; //열의 길이
					if(arr[i][j]!=0 && !visited[i][j]) {
						r=i;
						c=j;
						for(int row=r;row<n;row++) {
							if(arr[row][j]==0)
								break;
							rNum++;
						}
						
						for(int col=j;col<n;col++) {
							if(arr[i][col]==0)
								break;
							cNum++;
						}
						list.add(new Start(rNum,cNum));
						count++;
						for(int row=r;row<r+rNum;row++) {
							for(int col=c;col<c+cNum;col++)
								visited[row][col]=true;
						}
					} 
				}
			}
			
			Collections.sort(list);
			
			System.out.print("#"+test+" "+count+" ");
			for(int i=0;i<list.size();i++) {
				System.out.print(list.get(i).r+" "+list.get(i).c+" ");
			}
			System.out.println();
			
			
		}
		
	}

}
