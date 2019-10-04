import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_2636_치즈_이정수 {
	    static int cheeze[][];
	    static int row,col;
	    static int ax[]= {1,0,-1,0};
	    static int ay[]= {0,-1,0,1};
	    static boolean visit[][];
	    static int pre,phase,cnt;
	    static Queue<Element> removeQ=new LinkedList<Element>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]=br.readLine().split(" ");
		row=Integer.parseInt(s[0]);
		col=Integer.parseInt(s[1]);
		cnt=0;
		pre=0; phase=0;
		cheeze=new int[row][col];
		
		for(int i=0;i<row;i++) {
			String a[]=br.readLine().split(" ");
			for(int j=0;j<col;j++) {
				cheeze[i][j]=Integer.parseInt(a[j]);
			}
		}
		
		while(true) {
			out_air(); //외부 공기들 -1로 수정
			visit=new boolean[row][col];
			
			
			for(int i=1;i<row-1;i++) {
				for(int j=1;j<col-1;j++) {
					if(cheeze[i][j]==1 &&isEdge(i,j) )
						bfs(i,j);
				}
			}
			
			cnt=removeQ.size();
			if(cnt==0)
				break;
			pre=cnt;
			phase++;
			while(!removeQ.isEmpty()) {
				cheeze[removeQ.peek().x][removeQ.poll().y]=-1;
			}	
		}
		System.out.println(phase);
		System.out.println(pre);
	}
	
	public static void bfs(int x, int y) {
		
		Queue<Element> searchQ=new LinkedList<>();
		
		searchQ.offer(new Element(x,y));
		
		
		while(!searchQ.isEmpty()) {
			
			
			int row_x=searchQ.peek().x;
			int col_y=searchQ.poll().y;
			visit[row_x][col_y]=true;
			
			if(isEdge(row_x,col_y)) {
				cheeze[row_x][col_y]=2;
				removeQ.offer(new Element(row_x,col_y));
			}
			for(int i=0;i<4;i++) {
				int dx=row_x+ax[i];
				int dy=col_y+ay[i];
				
				if(isRange(dx,dy) && !visit[dx][dy] && cheeze[dx][dy]==1) {
					visit[dx][dy]=true;
					searchQ.offer(new Element(dx,dy));
				}
			}
			
		}
		
	}
	
	
	
	
	public static void out_air() {
		boolean visited[][]=new boolean[row][col];
		Queue<Element> out=new LinkedList<>();
		
		visited[0][0]=true;
		out.offer(new Element(0,0));
		
		while(!out.isEmpty()) {
			int x=out.peek().x;
			int y=out.poll().y;
			
			cheeze[x][y]=-1;
			for(int i=0;i<4;i++) {
				int dx=x+ax[i];
				int dy=y+ay[i];
				
				if(isRange(dx,dy) && !visited[dx][dy] && cheeze[dx][dy]<=0) {
					out.offer(new Element(dx,dy));
					visited[dx][dy]=true;
				}
				
				
			}
		}
		
	}
	
	public static boolean isRange(int x, int y) {
		if(x>=0 && x<row && y>=0 && y<col)
			return true;
		else
			return false;
	}
	
	public static boolean isEdge(int x,int y) {
		
		

		for(int i=0;i<4;i++) {
			if(cheeze[x+ax[i]][y+ay[i]]==-1)
				return true;
		}
		return false;
	}

}

class Element{
	int x,y;
	
	public Element(int x,int y) {
		this.x=x;
		this.y=y;
	}
}
