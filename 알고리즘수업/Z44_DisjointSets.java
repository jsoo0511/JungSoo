package 알고리즘수업_Z;
/**
 * 서로 소 집합 = 상호 배타 집합 = Disjoint-Sets
 * 각 원소가 같은 집합인지, 다른 집한인지를 쉽게 구분할 수 있다
 *    
 *    구현방법: 연결리스트
 *           트리(연결리스트, 배열) ->트리 중 배열을 쓰는게 좋다. 
 *
 */
public class Z44_DisjointSets {
	
	public static int []p=new int[10]; //트리구조를 배열로 저장, 부모의 정보를 저장
	public static int []rank=new int[p.length]; //깊이 정보 rank저장할 배열
	public static void main(String[] args) {
		for(int i=0;i<p.length;i++)
			makeSet(i);//0~9정점을 각각 하나씩 원소로 하는 집합을 생성
		
		printSet();
		
		union(0,1);printSet();
		union(2,3);printSet();
		union(0,3);printSet();
		union(4,5);printSet();
		union(6,7);printSet();
		union(4,7);printSet();
		union(3,5);printSet();
		union(1,8);printSet();
		union(0,9);printSet();

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

}//end class
