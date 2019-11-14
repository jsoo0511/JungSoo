package 알고리즘수업_Z;

import java.util.Arrays;
​
/**
 * 다익스트라
 * 최단 경로 알고리즘
 * - 선택한 특정정점에서 출발해서 각 정점까지 갈 수 있는 최단 경로를 구하는 알고리즘
 *
 */
public class Z47_Dijkstra {
	public static void main(String[] args) {
		final int M = Integer.MAX_VALUE;
		int[][] G = {
				{0,3,5,M,M,M},
				{M,0,2,6,M,M},
				{M,1,0,4,6,M},
				{M,M,M,0,2,3},
				{3,M,M,M,0,6},
				{M,M,M,M,M,0}
		};
		
		int s = 0; //시작정점
		//가중치 배열(최종 목표), 시작정점에서 각 정점까지 갈 수 있는 최단거리를 저장할 배열
		int[] D = G[s]; // 다시 쓸일 없기에 클론없이 그냥 해도 영향없다.
		boolean[] used = new boolean[G.length];
		for(int i=0;i<G.length;i++) {
			int minIndex = -1;
			int min = M;
			for(int j=0;j<D.length;j++) {
				if(!used[j] && min>D[j]) {
					minIndex = j;
					min = D[j];
				}
			}
			// 선택한 정점을 통해 갈 수 있는 정점의 가중치를 갱신하기.
			used[minIndex] = true;
			// 사용하지 않은 정점 && 인접한 정점 && 가중치가 D배열보다 더 작은 값
			for(int j=0;j<D.length;j++) {
				if(!used[j] && G[minIndex][j]!=M && D[j]>D[minIndex]+G[minIndex][j]) {
					D[j] = D[minIndex] + G[minIndex][j];
				}
			}
			System.out.println(Arrays.toString(D));
		}
	}
}
