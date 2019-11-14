import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Z28_BFS {

	public static void main(String[] args) {
		int [][]G= {//정점에 연결된 정점 정보를 저장
				{}, //정점0에 연결된 정보를 저장
				{2,3},//정점1에 연결된 정보를 저장
				{1,4,5},//2
				{1,7},//3
				{2,6},//4
				{2,6},//5
				{4,5,7},//6
				{3,6}//7
		};
		
	//	Queue<Integer> Q=new LinkedList<Integer>();
		int []q=new int[100];//큐 생성
		int front=-1;
		int rear=-1;
		boolean visited[]=new boolean[8];//0번 정점은 안씀
		
		//시작정점 지정, 큐에 넣기, 방문표시
		int v=1;
		q[++rear]=v;
		visited[v]=true;
		
		while(front !=rear) {//큐가 비어있을때까지 반복
			//큐에서 꺼내기, 방문
			v=q[++front];
			System.out.print(v+" ");//방문해서 출력하기
			//인접한 정점중 방문하지 않은 정점을 큐에 넣고, 방문한 것으로 표시
			for(int i=0;i<G[v].length;i++) {
				if(!visited[G[v][i]]) {//방문하지 않은 정점이면
					q[++rear]=G[v][i];
					visited[G[v][i]]=true;
				}
			}
		}

	}

}
