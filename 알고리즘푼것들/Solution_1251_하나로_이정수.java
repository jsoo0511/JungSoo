import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1251_하나로_이정수 {
	public static class Edge implements Comparable<Edge>{
		int x,y;
		long dis;

		public Edge(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Edge o) {
			
			return Long.compare(this.dis, o.dis);
		}
		
		
	}
	
	static int n;
	static Edge edge[]; //간선
	static Edge node[]; //정점
    static int p[];
    static int rank[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int test=1;test<=tc;test++){
			n=Integer.parseInt(br.readLine());//섬의 개수
			String []sx=br.readLine().split(" ");
			String []sy=br.readLine().split(" ");
			double e=Double.parseDouble(br.readLine());
			double result=0;
			node=new Edge[n];
			edge=new Edge[n*n];
			for(int i=0;i<n;i++){ //정점 생성
				int x=Integer.parseInt(sx[i]);
				int y=Integer.parseInt(sy[i]);
			    node[i]=new Edge(x,y);
			}
			int cnt=0;
			for(int i=0;i<n;i++){//간선 생성
				for(int j=0;j<n;j++){
					edge[cnt]=new Edge(i,j);//edge i는 node[i]와 node[j]를 연결한다
					long dis=(long)(node[i].x-node[j].x)*(node[i].x-node[j].x) + (long)(node[i].y-node[j].y)*(node[i].y-node[j].y);
					edge[cnt++].dis=dis; //거리값
				}
			}
			
			Arrays.sort(edge);
			p=new int[n];//대표자 배열
			rank=new int[n];
		    for(int i=0;i<n;i++){//각 정점을 하나의 집합으로 생성
		    	makeSet(i);
		    }
		    int num=0;
		    for(int i=0;i<cnt;i++){
		    	Edge temp=edge[i]; //가장 작은 거리값부터 꺼냄
		    	int px=findSet(temp.x);//대표자 찾기
		    	int py=findSet(temp.y);
		    	
		    	if(px!=py){//사이클이 생기지 않을 경우만 합치기, 대표자가 같을 경우 사이클이 생긴다
		    		union(px,py);
		    		result+=temp.dis;
		    		num++;
		    		if(num==n-1)
		    			break;
		    	}
		    	
		    }
		    result*=e;
		    System.out.println("#"+test+" "+Math.round(result));
			
		}

	}
	
	
	public static void makeSet(int x){
		p[x]=x;
		rank[x]=0;
	}
	
	public static int findSet(int x){
		
		if(p[x]==x)
			return p[x];
		else
		{
			p[x]=findSet(p[x]);
			return p[x];
		}
	}
	
	public static void union(int x, int y){
		int px=findSet(x);
		int py=findSet(y);
		
		if(px!=py){
			link(px,py);
		}
	}
	
	public static void link(int x, int y){
		if(rank[x]>rank[y]){
			p[y]=x; //작은 쪽을 큰 쪽에 붙인다.
		}
		else{
			p[x]=y;
			if(rank[x]==rank[y]) //같으면 rank값이 증가
				rank[y]++;
		}
	}

}
