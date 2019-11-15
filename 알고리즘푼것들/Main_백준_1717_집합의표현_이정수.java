import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1717_집합의표현_이정수 {
	
	public static int p[];
	public static int rank[];
	public static int arr[],n,m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		
		n=Integer.parseInt(s[0]);
		m=Integer.parseInt(s[1]);
		StringBuilder sb = new StringBuilder();
		arr=new int[n+1]; //0 ~ n까지
		p=new int[n+1];
		rank=new int[n+1];
		for(int i=0;i<p.length;i++) {
			makeSet(i);
		}
		while(m-->0) {
			String order[]=br.readLine().split(" ");
			if(Integer.parseInt(order[0])==0) {
				union(Integer.parseInt(order[1]),Integer.parseInt(order[2]));
			}
			else {
				int a=findSet(Integer.parseInt(order[1]));
				int b=findSet(Integer.parseInt(order[2]));
				if(a==b)
					sb.append("YES\n");
				else
					sb.append("NO\n");
				
			}
			
		}
		System.out.print(sb);
	}
	
	public static void makeSet(int x) {
		p[x]=x;
		rank[x]=0;
	}
	
	public static void union(int x, int y) {
		int px=findSet(x);
		int py=findSet(y);
		
		if(px!=py) {
			link(px,py);
		}
	}
	
	public static int findSet(int x) {
		if(p[x]==x)
			return x;
		else {
			p[x]=findSet(p[x]);
			return p[x];
		}
	}
	
	public static void link(int x,int y) {
		if(rank[x]>rank[y]) {
			p[y]=x;
		}else {
			p[x]=y;
			if(rank[x]==rank[y])
				rank[y]++;
		}
	}

}
