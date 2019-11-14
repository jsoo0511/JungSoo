import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_4963_섬의개수_이정수 {
	   static int count;
	   static int dx[]= {1,1,0,-1,-1,-1,0,1};
       static int dy[]= {0,-1,-1,-1,0,1,1,1};
       static boolean visited[][];
       static int w;
       static int h;
       static int arr[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb=new StringBuffer();
		ArrayList<Integer> result=new ArrayList<>();
		while(true) {
	    String s[]=br.readLine().split(" ");
	    w=Integer.parseInt(s[0]);
	    h=Integer.parseInt(s[1]);
	    
	    if(w==0 && h==0)
	    	break;
	    
	    arr=new int[h][w];
	    visited=new boolean[h][w];
	    
	    for(int i=0;i<h;i++) {
	    	String t[]=br.readLine().split(" ");
	    	for(int j=0;j<w;j++)
	    		arr[i][j]=Integer.parseInt(t[j]);
	    }
	    
	    
	    for(int i=0;i<h;i++) {
	    	for(int j=0;j<w;j++) {
	    		if(!visited[i][j] && arr[i][j]==1) {
	    		    dfs(i,j);
	    		    count++;
	    		}
	    	}
	    	
	    }
	    
	    sb.append(Integer.toString(count));
	    sb.append("\n");
	    count=0;
	}
	    
	    System.out.println(sb);
		
	}
	
	public static void dfs(int x, int y) {
		visited[x][y]=true;
		
		for(int i=0;i<8;i++) {
			int ax=x+dx[i];
			int ay=y+dy[i];
			
			if(isRange(ax,ay) && !visited[ax][ay] && arr[ax][ay]==1)
				dfs(ax,ay);
		}
		
	}
	
	public static boolean isRange(int x, int y) {
		if(x>=0 && x<h && y>=0 && y<w)
			return true;
		else
			return false;
	}


}


