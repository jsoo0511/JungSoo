package 알고리즘수업_Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부분집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int array[] = new int[N];
		
		String str[] = br.readLine().split(" ");
		
		for(int i=0; i<N; i++) {
			array[i] = Integer.valueOf(str[i]);
		}
		
		int result[][] = new int[1<<N][N];
		int index[] = new int[1<<N];
		
		for(int i=0; i<(1<<N); i++) {
			for(int j=0; j<N; j++) {
				if((i & (1<<j)) != 0) {
					result[i][index[i]++] = array[j];
				}
			}
		}
		
		for(int i=0; i<(1<<N); i++) {
			for(int j=0; j<index[i]; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println("총 갯수: " + (1<<N));
	}

}
