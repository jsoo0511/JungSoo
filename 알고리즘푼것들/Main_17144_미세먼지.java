import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_17144_미세먼지 {
	public static class Dust{
		int r;
		int c;
		int val;
		public Dust(int r, int c,int val) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Dust [r=" + r + ", c=" + c + "]";
		}
		
	}
	
	public static class Air{
		int r;
		int c;
		public Air(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Air [r=" + r + ", c=" + c + "]";
		}
		
	}

	public static int copy[][];
	public static int dr[]= {0,1,0,-1};
	public static int dc[]= {1,0,-1,0};
	public static ArrayList<Dust> list;
	public static ArrayList<Air> airlist;
	public static Queue<Dust> q;
	public static int [][]arr;
	public static int n,m,t;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[]=br.readLine().split(" ");
        n=Integer.parseInt(s[0]);
        m=Integer.parseInt(s[1]);
        t=Integer.parseInt(s[2]);
        int remain;
        int result=0;
    	remain=0;
    	arr=new int[n][m];
    	copy=new int[n][m];
    	list=new ArrayList<>();
    	airlist=new ArrayList<>();
    	q=new LinkedList<>();
    	for(int i=0;i<n;i++) { //배열 초기화
    		String str[]=br.readLine().split(" ");
    		for(int j=0;j<m;j++) {
    			arr[i][j]=Integer.parseInt(str[j]);
    			if(arr[i][j]!=0) //먼지들 큐에 삽입
    				q.offer(new Dust(i,j,arr[i][j]));
    			if(arr[i][j]==-1)
    				airlist.add(new Air(i,j));
    		}
    	}
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++)
    			copy[i][j]=arr[i][j];
    	}
    	
        ////////////////////
    //	q.offer(new Dust(-2,-2,-2));//구분자
        for(int test=0;test<t;test++) {//t초만큼 반복
        	spread(); //바이러스 퍼트린 후
        	copyArray(); //복사
        	System.out.println("바이러스 퍼진 후=============");
        	for(int i=0;i<n;i++) {
    			for(int j=0;j<m;j++) {
    				System.out.print(arr[i][j]+" ");
    			}
    			System.out.println();
    		}
//        
        	System.out.println(" 이동후 =============");
        	move();//이동
        	for(int i=0;i<n;i++) { //큐에 다값들 삽입
        		for(int j=0;j<m;j++) {
        			if(arr[i][j]!=0) //먼지들 큐에 삽입
        				q.add(new Dust(i,j,arr[i][j]));
        			else
        				continue;
        		}
        	}
        	System.out.println("이동후 복사전copy확인=====");
        	for(int i=0;i<n;i++) {
    			for(int j=0;j<m;j++) {
    				System.out.print(copy[i][j]+" ");
    			}
    			System.out.println();
    		}
        	
        	copyArray();
        	System.out.println("이동후 복사 후copy확인=====");
        	for(int i=0;i<n;i++) {
    			for(int j=0;j<m;j++) {
    				System.out.print(copy[i][j]+" ");
    			}
    			System.out.println();
    		}
        	System.out.println("이동후 arr확인=======");
        	for(int i=0;i<n;i++) {
    			for(int j=0;j<m;j++) {
    				System.out.print(arr[i][j]+" ");
    			}
    			System.out.println();
    		}
//        
        	System.out.println("=============");
        }
        
        for(int i=0;i<n;i++) {
        	for(int j=0;j<m;j++) {
        		if(arr[i][j]==-1 || arr[i][j]==0)
        			continue;
        		result+=arr[i][j];
        	}
        }
        
        System.out.println(result);

	}
	
	public static void move() {
		int hr=airlist.get(0).r;//위로가는 row,col
		int hc=airlist.get(0).c;
		int lr=airlist.get(1).r;//아래로가는 row,col
		int lc=airlist.get(1).c;
		
		arr[hr][1]=0;
		for(int c=1;c<m-1;c++) { //오른쪽이동
			arr[hr][c+1]=copy[hr][c];
		}
		
		for(int r=hr;r>0;r--) {
			arr[r-1][m-1]=copy[r][m-1];
		}
		
		for(int c=m-1;c>0;c--) {
			arr[0][c-1]=copy[0][c];
		}
		
		for(int r=0;r<hr-1;r++) {
			if(copy[r][0]==-1)
				break;
			arr[r+1][0]=copy[r][0];
		}
		
		//////아래쪽 회전
		arr[lr][1]=0;
		for(int c=1;c<m-1;c++) { //오른쪽이동
			arr[lr][c+1]=copy[lr][c];
		}
		
		for(int row=lr;row<n-1;row++) {
			arr[row+1][m-1]=copy[row][m-1];
		}
		
		for(int c=m-1;c>0;c--) {
			arr[n-1][c-1]=copy[n-1][c];
		}
		
		for(int r=n-1;r<lr;r--) {
			if(copy[r][0]==-1)
				break;
			arr[r-1][0]=copy[r][0];
		}
		
	}
	
	public static void spread() {
		Dust dust;
		int remain;
		int count;
		while(!q.isEmpty()) {
			dust=q.poll();
			remain=copy[dust.r][dust.c]/5;//확산되는 양
			count=0;//몇개 확산됬는지
			for(int i=0;i<4;i++) {
				int temp_r=dust.r+dr[i];
				int temp_c=dust.c+dc[i];
				//범위안과 공기청정기가 아니라면
				if(temp_r>=0 && temp_r<n && temp_c>=0 && temp_c<m && copy[temp_r][temp_c]!=-1) {
					    arr[temp_r][temp_c]+=remain;//이미있는 값에 remain더해줌
						count++;
				}
			}
		
			//System.out.println(arr[dust.r][dust.c]);
			//System.out.println(arr[dust.r][dust.c]-(remain*count));
			arr[dust.r][dust.c]-=(remain*count); //양옆으로 확산 된 수만큼 원래값에서 remain을 빼줌
		}
	}
	
	public static void copyArray() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				copy[i][j]=arr[i][j];
			}
		}
	}

}
