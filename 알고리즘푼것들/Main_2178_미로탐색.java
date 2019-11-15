import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2178_미로탐색 {

	public static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static int arr[][];
	static int n, m;
	static boolean visited[][];
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int result;
	static int cnt;
	static int min;
	static Queue<Point> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		arr = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];
		q = new LinkedList<>();// 큐 생성
		Point p;

		for (int i = 1; i <= n; i++) { // 배열 초기화
			String str[] = br.readLine().split("");
			for (int j = 1; j <= m; j++) {
				{
					arr[i][j] = Integer.parseInt(str[j - 1]);

				}
			}
		}
		min = Integer.MAX_VALUE;
		cnt = 0;
		result = 0;
		bfs(1,1);

		System.out.println(cnt);

	}

	public static void bfs(int x,int y) {
	//	cnt++;
		Point point=new Point(x,y);
		q.add(point);//스타트지점
		int r,c;
		Point pp;
		visited[x][y]=true;
		outer: while(!q.isEmpty()) {
			point=q.poll();
			r=point.r;
			c=point.c;
			int num=0;
			for (int i = 0; i < 4; i++) {
				int tempr=r+dr[i];
				int tempc=c+dc[i];
				
				if(tempr==n && tempc==m) {
					cnt++;
					break outer;
				}
				
				if(isEdge(tempr, tempc) && !visited[tempr][tempc] && arr[tempr][tempc]==1) {
					num++;
					if(num==1) {
						System.out.println("temp=> "+tempr+" : "+tempc);
						System.out.println("num: "+num);
						cnt++;
					}
					visited[tempr][tempc]=true;
					pp=new Point(tempr,tempc);
					q.add(pp);
				}
			}
			System.out.println(r+" : "+c);
			System.out.println("cnt: "+cnt);
			
			
		}
		

	}

	public static boolean isEdge(int r, int c) {
		if (r >= 1 && r <= n && c >= 1 && c <= m) {
			return true;
		} else
			return false;
	}

}
