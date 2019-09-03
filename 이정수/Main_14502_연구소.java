import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_14502_연구소 {
	
	public static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int arr[][];
	static int copy[][];
	static int n,m;
    static ArrayList<Point> list;
    static int []dr={0,1,0,-1};
    static int []dc={1,0,-1,0};
    static int max=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]=br.readLine().split(" ");
		
		n=Integer.parseInt(s[0]);
	    m=Integer.parseInt(s[1]);
		list=new ArrayList();
		arr=new int[n][m];
		copy=new int[n][m];
		for(int i=0;i<n;i++){//배열 초기화
			String str[]=br.readLine().split(" ");
			for(int j=0;j<m;j++){
				arr[i][j]=Integer.parseInt(str[j]);
				if(arr[i][j]==2)
					list.add(new Point(i,j));
				
			}
		}
		
		wall(0,0);
		System.out.println(max);
	
	}
	
	public static void wall(int start,int depth){
		if(depth==3){
			copyarr();
			
			for(int i=0;i<list.size();i++){
				virus(list.get(i).x,list.get(i).y);
			}
			max=Math.max(safe(), max);
			return;
		} else{
			for(int i=start;i<n*m;i++){
				int r=i/m;
				int c=i%m;
				if(arr[r][c]==0){
					arr[r][c]=1;
					wall(i+1,depth+1);
					arr[r][c]=0;
				}
			}
		}
	}
	
	public static void copyarr(){
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				copy[i][j]=arr[i][j];
			}
		}
	}
	
	public static void virus(int r,int c){
		
		for(int i=0;i<4;i++){
			int row=r+dr[i];
			int col=c+dc[i];
			if(row>=0 && row<n && col>=0 && col<m){
				if(copy[row][col]==0){
					copy[row][col]=2;
					virus(row,col);
					}
			}
		}
	}
	
	public static int safe(){
		int sa=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(copy[i][j]==0)
					sa++;
			}
		}
		return sa;
	}

}
