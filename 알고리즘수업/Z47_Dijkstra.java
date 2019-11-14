package 알고리즘수업_Z;

public class Z47_Dijkstra {

	public static void main(String[] args) {
		final int M=Integer.MAX_VALUE;
		int [][]G= {
				{0,3,5,M,M,M},
				{M,0,2,6,M,M},
				{M,1,0,4,6,M},
				{M,M,M,0,2,3},
				{3,M,M,M,0,6},
				{M,M,M,M,M,0}
		};
		
		int s=0;//시작정점
		//가중치 배열(최종 목표), 시작정점에서 각 정점까지 갈 수 있는 최단 거리를 저장할 배열
		int []D = G[s];//.clone(); 배열을 깊은 복사하는 것이 바람직 하지만, 시작정점의 진출정보는 더 이상 사용하지 않으므로 깊은 복사하지 않아도 됨
		
		boolean []used=new boolean[G.length]; //사용한 정점 저장
		
		for(int i=0;i<G.length;i++) {
			
		}

	}

}
