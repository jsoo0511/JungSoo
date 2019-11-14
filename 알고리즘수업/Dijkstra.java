
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class Dijkstra {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.valueOf(str[0]);
		int M = Integer.valueOf(str[1]);
		final int MV = Integer.MAX_VALUE;
		
		int array[][] = new int[N][N];
		boolean visited[] = new boolean[N];
		int min[] = new int[N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				array[i][j] = MV;
			}
			min[i] = MV;
		}
		
		for(int m=0; m<M; m++) {
			str = br.readLine().split(" ");
			int a = Integer.valueOf(str[0]);
			int b = Integer.valueOf(str[1]);
			int val = Integer.valueOf(str[2]);
			
			array[a][b] = array[b][a] = val;
		}
		
		int target = 0;
		int minIndex = target;
		min[minIndex] = 0;
		
		while(minIndex != -1) {
			visited[minIndex] = true;
			
			for(int i=0; i<N; i++) {
				if(visited[i] == false && array[i][minIndex] != MV) {
					min[i] = Math.min(min[i], min[minIndex] + array[minIndex][i]);
				}
			}
			
			minIndex = -1;
			
			for(int i=0; i<N; i++) {
				if(visited[i] == false) {
					if(minIndex == -1) {
						minIndex = i;
					} else {
						if(min[minIndex] > min[i]) {
							minIndex = i;
						}
					}
				}
			}
		}
		
		System.out.print(target + "에서 최단 경로들은: ");
		for(int i=0; i<N; i++) {
			System.out.print(target + "->" + i + "(" + min[i] + ") ");
		}
		System.out.println();
	}
}

/*
6 9
1 2 5
2 3 4
1 5 10
4 0 3
3 4 2
3 1 15
5 3 4
5 4 20
0 3 4
*/