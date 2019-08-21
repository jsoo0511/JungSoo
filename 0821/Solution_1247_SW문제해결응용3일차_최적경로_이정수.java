
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_1247_SW문제해결응용3일차_최적경로_이정수 {
	static int x[];
	static int y[];
	static int min;
	static int check[];
	static int company[]=new int[2];
	static int home[]=new int[2];
	static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int cus;
        
        for(int test=1;test<=tc;test++) {
        	
        	cus=Integer.parseInt(br.readLine());
        	check=new int[cus];
        	for(int i=0;i<check.length;i++)
        		check[i]=i;
        	x=new int[cus];
        	y=new int[cus];
        	String str=br.readLine();
        	StringTokenizer st=new StringTokenizer(str," ");
        	min=Integer.MAX_VALUE;
        	company[0]=Integer.parseInt(st.nextToken());
        	company[1]=Integer.parseInt(st.nextToken());
        	home[0]=Integer.parseInt(st.nextToken());
        	home[1]=Integer.parseInt(st.nextToken());
        	for(int i=0;i<x.length;i++) {//배열초기화
        			x[i]=Integer.parseInt(st.nextToken());
        			y[i]=Integer.parseInt(st.nextToken());
        	}
        	
        	
        	perm(0,cus,cus);
        	
        	System.out.println("#"+test+" "+min);
        }
	}

	
	public static void perm(int size,int n,int k) {
		
		if(size==k){
			sum=0;
			sum+=Math.abs(x[check[0]]-company[0])+Math.abs(y[check[0]]-company[1]);
			for(int i=0;i<check.length-1;i++){
				sum+=Math.abs(x[check[i]]-x[check[i+1]])+Math.abs(y[check[i]]-y[check[i+1]]);
			}
			
			sum+=Math.abs(x[check[check.length-1]]-home[0])+Math.abs(y[check[check.length-1]]-home[1]);
			min=min>sum?sum:min;
		} else{
			for(int i=size;i<n;i++){
				int temp=check[i];
				check[i]=check[size];
				check[size]=temp;
				
				perm(size+1,n,k);
				temp=check[i];
				check[i]=check[size];
				check[size]=temp;
			}
		}
	}

}
