import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1249_보급로_이정수 {
	public static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}
	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int test = 1; test <= tc; test++) {
			n = Integer.parseInt(br.readLine());
			int arr[][] = new int[n][n];
			int weight[][] = new int[n][n];
			Queue<Point> q = new LinkedList<Point>();
			for (int i = 0; i < n; i++) {// 배열초기화
				String s[] = br.readLine().split("");
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(s[j]);
					weight[i][j]=-1;
				}
			}
            
			weight[0][0]=0;
			q.add(new Point(0,0));
			while(!q.isEmpty()) {
				int r=q.peek().r;
				int c=q.poll().c;
				
				for(int i=0;i<4;i++) {
					int tempr=r+dr[i];
					int tempc=c+dc[i];
					if(isRange(tempr,tempc) && (weight[tempr][tempc]==-1 || weight[tempr][tempc]>weight[r][c]+arr[tempr][tempc])) {
						weight[tempr][tempc]=weight[r][c]+arr[tempr][tempc];
						q.add(new Point(tempr,tempc));
					}
				}
			}
			
			System.out.println("#"+test+" "+weight[n-1][n-1]);
            

		}

	}
	public static boolean isRange(int r, int c) {
		if (r >= 0 && r < n && c >= 0 && c < n)
			return true;
		else
			return false;
	}

}
