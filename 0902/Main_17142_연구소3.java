import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_17142_연구소3 {
	static public class Virus{
		int x,y;
        int val;
		public Virus(int x, int y,int val) {
			this.x = x;
			this.y = y;
			this.val=val;
		}
		@Override
		public String toString() {
			return "Virus [x=" + x + ", y=" + y + ", val=" + val + "]";
		}
		
	}
	static int n,m;
	static int arr[][];
	static int copy[][];
	static int min;
	static int result;
	static Queue<Virus> q;
	static ArrayList<Virus> list;
	static boolean visited[][];
	static int dr[]={0,1,0,-1};
	static int dc[]={1,0,-1,0};
	static int count;
	static int num;
	static Virus v;
	static boolean flag=false;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String []s=br.readLine().split(" ");
		n=Integer.parseInt(s[0]);
		m=Integer.parseInt(s[1]);
		arr=new int[n][n];
		copy=new int[n][n];
		list=new ArrayList<>(); //바이러스 좌표
		q=new LinkedList<>();
		result=Integer.MAX_VALUE;
		for(int i=0;i<n;i++){ //배열초기화
			String []str=br.readLine().split(" ");
			for(int j=0;j<n;j++){
				arr[i][j]=Integer.parseInt(str[j]);
				if(arr[i][j]==2){
					list.add(new Virus(i,j,0));
				}
				
					
			}
		}
		flag=false;
		virus(0,0);
		if(flag)
		   System.out.println(result);
		else
			System.out.println(-1);
		
	}
	
	public static void virus(int start,int depth){ //바이러스 m개 선택후 확산
		if(depth==(list.size()-m)){
		//	System.out.println("enter"+(list.size()-m));
			copyarr();
			count=0;//새로운 바이러스 배열  count초기화
			min=0;
			visited=new boolean[n][n];
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(arr[i][j]==2){
						v=new Virus(i,j,0);
						q.offer(v);//바이러스 큐에 삽입
						visited[i][j]=true;
						count++;//방문한 애들 수, 나중에 방문불가 체크시 n*n과 비교
					}
					if(arr[i][j]==1){
						visited[i][j]=true;//벽은 방문처리 
						count++;
					}
//					if(arr[i][j]==-2) {
//						visited[i][j]=true;//비활성바이러스 방문체크
//					    count++;
//					}
					
				}
			}
			if(count==n*n) { //시작하자마자 다 탐색된 경우
				result=0;
				flag=true;
				return;
			}
			bfs();
		
			
		}else{
			for(int i=start;i<list.size();i++){
				int x=list.get(i).x;
				int y=list.get(i).y;
				arr[x][y]=-2;//'*'대신 -2로 대체
				virus(i+1,depth+1);
				arr[x][y]=2;
				//visited[x][y]=false;
			}
		}
	}
	
	public static void copyarr(){
	//	System.out.println("copy");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				copy[i][j]=arr[i][j];
		}
	}
	
	public static void bfs(){
		
	
//		for(Virus vi:q)
//			System.out.println(vi);
//		System.out.println("````````````````````````");
//		System.out.println("탐색전상태count: "+count);
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.print(copy[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("```````````````````````");
//		System.out.println();
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.print(visited[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		while(!q.isEmpty()){
			Virus vs=q.poll();
			int r=vs.x;
			int c=vs.y;
			int temp_val=vs.val;
			if(copy[r][c]==-2) {
				copy[r][c]=-2;
			}
			else
			   copy[r][c]=temp_val;
		//	System.out.println("start point"+r+", "+c);
			for(int i=0;i<4;i++){
				int temp_r=r+dr[i];
				int temp_c=c+dc[i];
				//System.out.println(temp_r+" , "+temp_c+","+n);
				//System.out.println(visited[temp_r][temp_c] +", "+isRange(temp_r,temp_c));
				if(isRange(temp_r,temp_c) && !visited[temp_r][temp_c]){
//					if(copy[temp_r][temp_c]==-2) {
//						visited[temp_r][temp_c]=true;
//						count++;
//					}
				//	System.out.println("enter"+temp_r+" "+temp_c);
					
					visited[temp_r][temp_c]=true;//방문 후
					q.offer(new Virus(temp_r,temp_c,temp_val+1));
					
					if(copy[temp_r][temp_c]!=-2 && min<temp_val+1)//바이러스 퍼지는 시간
					    min=temp_val+1;
					count++;
					
				}
			}
	//		System.out.println("one more");
		}
		
//		System.out.println("=================바이러스 다 퍼진 후==============================");
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.print(copy[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.print(visited[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("=================================================");
//		
//		System.out.println("퍼지는 최대 시간: "+min);
//		
//		System.out.println(count+" , "+n*n);
		if(count==n*n) {//다 퍼진 후에만 결과 계산
		//	System.out.println("Change!!!!!!!!!!!!!!!!");
			flag=true;
			if(result>min)
				result=min;
		//	System.out.println("result: "+result);
		}
	}
	
	public static boolean isRange(int r,int c){
		if(r>=0 && r<n && c>=0 && c<n)
			return true;
		else
			return false;
	}

}
