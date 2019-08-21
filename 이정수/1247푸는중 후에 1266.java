package 알고리즘수업_Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static int x[];
	static int y[];
	static int min;
	static int check[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int cus;
        
        for(int test=1;test<=tc;test++) {
        	cus=Integer.parseInt(br.readLine());
        	check=new int[cus+2];
        	x=new int[cus+2];
        	y=new int[cus+2];
        	String str=br.readLine();
        	StringTokenizer st=new StringTokenizer(str," ");
        	min=Integer.MAX_VALUE;
        	for(int i=0;i<x.length;i++) {//배열초기화
        			x[i]=Integer.parseInt(st.nextToken());
        			y[i]=Integer.parseInt(st.nextToken());
        	}
        //계산상 편의를 위해 집과 회사 위치 변경
        	int temp=x[0];
        	x[0]=x[1];
        	x[1]=temp;
        	
        	temp=y[0];
        	y[0]=y[1];
        	y[1]=temp;
        	perm(x.length-2,0);
        	
        	System.out.println("#"+test+" "+min);
        }
	}
	public static HashSet<String> hash=new HashSet<>();
	
	public static void perm(int n,int k) {
		String str="";
        for(int r=2;r<x.length;r++)
		 str+=x[r]+""+y[r]+k;//만들어진숫자와 교환횟수를 붙여서 문자열로 저장
		
		if(hash.contains(str)) {//중복 체크
			//System.out.println("중복");
			return;
		} else {
		//	System.out.println(str);
		hash.add(str); //사용한 정보를 저장해놓음
		}
		
		if(n==k) {
			int mx=0,my=0;
			for(int i=1;i<x.length-1;i++) { //회사와  손님x,y거리 계산
				
				if(x[i]<x[i+1])
					mx+=x[i+1]-x[i];
				else
					mx+=x[i]-x[i+1];
				
				if(y[i]<y[i+1])
					my+=y[i+1]-y[i];
				else
					my+=y[i]-y[i+1];
				if((mx+my)>min)
					return;
			}
			if(x[0]<x[x.length-1])
				mx+=x[x.length-1]-x[0];
			else
				mx+=x[0]-x[x.length-1];
			
			if(y[0]<y[y.length-1])
				my+=y[y.length-1]-y[0];
			else
				my+=y[0]-y[y.length-1];
			
			if((mx+my)<min)
				min=(mx+my);
		} else {
			for(int i=k+2;i<n;i++) {
				int temp=check[i];
				check[i]=check[i+1];
				check[i+1]=temp;
				perm(n,k+1);
				temp=check[i];
				check[i]=check[i+1];
				check[i+1]=temp;
//				for(int j=i+1;j<x.length;j++) {
//					int temp_x=x[i];
//					x[i]=x[j];
//					x[j]=temp_x;
//					int temp_y=y[i];
//					y[i]=y[j];
//					y[j]=temp_y;
//					
//					
//					perm(n,k+1); //한자리바꾼후 재귀
//					temp_x=x[i];
//					x[i]=x[j];
//					x[j]=temp_x;
//					temp_y=y[i];
//					y[i]=y[j];
//					y[j]=temp_y;
//					
//				}
			}
		}
	}

}
