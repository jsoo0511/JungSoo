package 알고리즘수업_Z;

import java.util.Arrays;
import java.util.Scanner;

/**
 *Kruskal알고리즘
 *  간선정보를 가중치 기준으로 오름차순 정렬
 *  최소 가중치의 간선을 선택한다 V-1개
 *  사이클이 생기는 간선은 선택하지 않는다.(서로소 집합)
 * 
 * 
 [input] 정점의 개수V(0~V-1), 간선의 개수 E, 간선정보(정점1, 정점2, 가중치) 
 7 11
 5 3 18
 1 2 21
 2 6 25
 0 2 31
 0 1 32
 3 4 34
 5 4 40
 2 4 46
 0 6 51
 4 6 51
 0 5 60
 
 [아웃풋]
 175
 *
 */

public class Z46_Kruskal {
	/**하나의 간선을 추상화한 클래스*/
	public static class Edge implements Comparable<Edge>{
		int a;//정점 1
		int b;//정점 2
		int val;//가중치
		public Edge(int a, int b, int val) {
			this.a = a;
			this.b = b;
			this.val = val;
		}
		@Override
		public String toString() {
			return "[a=" + a + ", b=" + b + ", val=" + val + "]";
		}
		@Override
		public int compareTo(Edge o) {//가중치를 기준으로 오름차순 정렬
			return this.val-o.val; //오름차순
		}
	} 

	public static int []p; //트리구조를 배열로 저장, 부모의 정보를 저장
	public static int []rank; //깊이 정보 rank저장할 배열
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in); 
		int V=sc.nextInt();//정점의 개수
		int E=sc.nextInt();//간선의 개수
		
		Edge[] G=new Edge[E];//간선 저장할 배열
		for(int i=0;i<E;i++) {
			G[i]=new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
		
		Arrays.sort(G);//정렬
		
		p=new int[V];//부모정점을 저장할 배열
		rank=new int[V];//깊이를 저장할 배열
		for(int i=0;i<V;i++) {
			makeSet(i);//각 정점을 각각 하나의 집합으로 생성
		}
		int MST=0; //가중치의 합
		int cnt=0;
		for(int i=0;i<E;i++) {
			Edge e=G[i];//작은 가중치의 간선부터 꺼낸다.
			int px=findSet(e.a); //대표자를 찾음
			int py=findSet(e.b);
			
			if(px!=py) {//사이클이 생기지 않을 경우만 합치기, 대표자가 같을 경우 사이클이 생긴다., 다른 집합인 경우에만 doing
				union(px,py);
				System.out.println(e.a+"-"+e.b+" "+e.val);//선택한 간선 출력
				MST+=e.val;
				cnt++;
				if(cnt==V-1)
					break;
			}
		}
		System.out.println("KRUSKAL로 구한 MST의 전체 가중치 합: "+MST);
		

	}//end main
	
	/**멤버x를 포함하는 집합을 찾아서 대표자를 리턴*/
	public static int findSet(int x) {
		if(p[x]==x) {//-1일경우 대표자로 할 수도 있음
			return x;
		} else {
			p[x]=findSet(p[x]); //Path Compression
			return p[x];
		}
	}
	/**멤버 x, 멤버 y를 포함하는 두 집합을 통합*/
	public static void union(int x,int y) {
		int px=findSet(x); //대표자를 구해옴
		int py=findSet(y);
		
		//서로 다른 집합일 경우만 합쳐야함, 같은 집합인데 합치면 stackOverflowError발생
		if(px!=py) {
		   link(px,py);
		}
	}
	
	/**x의 대표자 집합과 y의 대표자 집합을 rank값을 기준으로 효율적으로 합침*/
	public static void link(int px,int py) {
		if(rank[px]>rank[py]) {
			p[py]=px; //작은 쪽을 큰 쪽에 붙인다.
		} else {
			p[px]=py;
			if(rank[px]==rank[py]) { //같은 경우는 랭크값이 증가한다.
				rank[py]++;
			}
		}
	}
	
	/** 멤버 x를 포함하는 새로운 집합을 생성 */
	public static void makeSet(int x) {
		p[x]=x;//부모가 자기자신이면 대표자 or 부모가 -1이면 대표자
		rank[x]=0; //초기값 0임
	}
	
	/** 정보를 출력하는 메서드*/
	public static void printSet() {
		System.out.print("index: ");
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%2d ",i);//배열의 인덱스 출력
		}
		System.out.println();
		System.out.print("parent:");
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%2d ",p[i]); //부모 정보를 출력
		}
		System.out.println();
		System.out.print("rank:  ");
		for (int i = 0; i < rank.length; i++) {
			System.out.printf("%2d ",rank[i]);
		}
		
		System.out.println("\n");
	}

}
