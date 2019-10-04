import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_3055_탈출_이정수 {
    static int R,C;
    static String arr[][];
    static String water[][];
    static int dr[]= {0,1,0,-1};
    static int dc[]= {1,0,-1,0};
    public static class Point{
    	int r;
    	int c;
    	int val;
		public Point(int r, int c,int val) {
			this.r = r;
			this.c = c;
			this.val=val;
		}
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", val=" + val + "]";
		}
    }
 
    static Point point_s;
    static Queue<Point> q;
    static int result;
    static boolean flag;
    static boolean move=false;
    static boolean visited[][];
    static boolean visited_w[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]=br.readLine().split(" ");
		R=Integer.parseInt(s[0]);
		C=Integer.parseInt(s[1]);
		arr=new String[R][C];
		water=new String[R][C];
		visited=new boolean[R][C];
		visited_w=new boolean[R][C];
		result=0;
		flag=false;
		q=new LinkedList<>();
		for(int i=0;i<R;i++) {//배열초기화
			String str[]=br.readLine().split("");
			for(int j=0;j<C;j++) {
				arr[i][j]=str[j];
				water[i][j]=str[j];
				if(str[j].equals("S")) {
					point_s=new Point(i,j,0);//고슴도치 시작점 위치
					visited[i][j]=true;
				}
				else if(str[j].equals("*")) {
					//물의 위치 큐에 추가, 물먼저 확산 후 고슴도치 이동여부따져야됨-> 물먼저 큐에 추가 
					q.add(new Point(i,j,0));
					visited[i][j]=true;
					visited_w[i][j]=true;
				}
					
			}
		}
		q.add(point_s);
		bfs();
		if(flag)
			System.out.println(result);
		else
			System.out.println("KAKTUS");

	}
	
	public static void bfs() {
		while(!q.isEmpty()) {
			Point p=q.poll();
			int r=p.r;
			int c=p.c;
			int val=p.val;
			visited[r][c]=true;
			if(water[r][c].equals("*")) {//물인경우
				for(int i=0;i<4;i++) {
					int tempr=r+dr[i];
					int tempc=c+dc[i];
					//물배열에 채움
					if(isRange(tempr,tempc) && !visited_w[tempr][tempc] && water[tempr][tempc].equals(".")) {
						water[tempr][tempc]="*";//물채우기
						q.add(new Point(tempr,tempc,0));
						visited[tempr][tempc]=true;
					}
					
				}
			}
			if(arr[r][c].equals("S")){//고슴도치인경우
				move=false;
				for(int i=0;i<4;i++) {//1번이동
					int tempr=r+dr[i];
					int tempc=c+dc[i];
					if(isRange(tempr,tempc) && !visited[tempr][tempc] && !visited_w[tempr][tempc] && arr[tempr][tempc].equals("D")) {//비버 찾으면 탈출
						result=val+1;
						flag=true;
						return;
					}
					if(isRange(tempr,tempc) && !visited[tempr][tempc] && !visited_w[tempr][tempc] && water[tempr][tempc].equals(".")) {
				
						arr[tempr][tempc]="S";//고슴도치 이동
						arr[r][c]=".";
						q.add(new Point(tempr,tempc,val+1));
						visited[tempr][tempc]=true;
						move=true;//이동
					}
				}
			}
			
		}
	}
	
	public static boolean isRange(int r,int c) {
		if(r>=0 && r<R && c>=0 && c<C)
			return true;
		else
			return false;
	}

}
