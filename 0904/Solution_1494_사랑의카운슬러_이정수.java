import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_1494_사랑의카운슬러_이정수 {
	public static class Position{
		int r;
		int c;
		public Position(int r, int c) {
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Position [r=" + r + ", c=" + c + "]";
		}
		
	}
	
	public static long min;
	public static int n;
	public static int arr[];
	public static int rSum;
	public static int cSum;
	public static long vector;
	public static long result;
	public static Position pos[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
	    for(int test=1;test<=tc;test++) {
	    	result=0;
			vector=0;
            rSum=0;
            cSum=0;
            min=Long.MAX_VALUE;
	    	n=Integer.parseInt(br.readLine());
	    	String []s;
	    	arr=new int[n];//인덱스들
	    	pos=new Position[n];
	    	for(int i=0;i<n;i++) { //지렁이위치 초기화
	    		s=br.readLine().split(" ");
	    		pos[i]=(new Position(Integer.parseInt(s[0]),Integer.parseInt(s[1]))); //지렁이 포지션 저장
	    		rSum+=Integer.parseInt(s[0]);
	    		cSum+=Integer.parseInt(s[1]);
	    	}
	    	
	    	search(0,0); 
	    	
	    	System.out.println("#"+test+" "+min);
	    	
	    }

	}
	
	
	public static void search(int start,int depth) {
		if(depth==n/2) {
			long tempr=0;
			long tempc=0;
			for(int i=0;i<n;i++) {
				if(arr[i]==1) {
					tempr+=pos[i].r;//절반 더할 애들 총합
					tempc+=pos[i].c;
				//	System.out.println(pos[i].r+" ,"+pos[i].c);
				}
			}
			
			long rv=rSum-tempr*2;//절반 뺄애들 총합
			long cv=cSum-tempc*2;
			//long resultr=tempr+rv;
			//long resultc=tempc+cv;
			//System.out.println(tempr+" "+tempc+" "+rv+" "+cv);
			result=(rv*rv)+(cv*cv);
		//	System.out.println("result: "+result);
			if(min>result)
				min=result;
			
		} else {
			for(int i=start;i<n;i++) {
				arr[i]=1;
				search(i+1,depth+1);
				arr[i]=0;
			}
		}
	}

}
