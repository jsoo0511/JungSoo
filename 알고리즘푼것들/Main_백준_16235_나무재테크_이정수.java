import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main_백준_16235_나무재테크_이정수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dirj[] = {1, 0, -1, 0, 1, 1, -1, -1};
		int diri[] = {0, 1, 0, -1, 1, -1, 1, -1};
		String str[] = br.readLine().split(" ");
		int N = Integer.valueOf(str[0]);
		int M = Integer.valueOf(str[1]);
		int K = Integer.valueOf(str[2]);
		
		int add[][] = new int[N+1][N+1]; // 추가양분
		int cur[][] = new int[N+1][N+1]; // 현재양분
		
		for(int i=1; i<=N; i++) {
			str = br.readLine().split(" ");
			for(int j=1; j<=N; j++) {
				add[i][j] = Integer.valueOf(str[j-1]);
				cur[i][j] = 5;
			}
		}
		
		ArrayList<Node_16235> list[][] = new ArrayList[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				list[i][j] = new ArrayList<Node_16235>();
			}
		}
		
		for(int m=1; m<=M; m++) {
			str = br.readLine().split(" ");
			int a = Integer.valueOf(str[0]);
			int b = Integer.valueOf(str[1]);
			int age = Integer.valueOf(str[2]);
			list[a][b].add(new Node_16235(age, false));
		}
		
		for(int k=1; k<=K; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(list[i][j].size() == 0)
						continue;
					
					Collections.sort(list[i][j], new Comparator<Node_16235>() {
						@Override
						public int compare(Node_16235 o1, Node_16235 o2) {
							return o1.age - o2.age;
						}
					});
					
					for(int s=0; s<list[i][j].size(); s++) { // 봄
						Node_16235 node = list[i][j].get(s);
						if(cur[i][j] >= node.age) {
							cur[i][j] = cur[i][j] - node.age;
							node.age++;
						} else {
							node.statue = true;
						}
					}
					
					for(int s=list[i][j].size()-1; s>=0; s--) { // 여름
						Node_16235 node = list[i][j].get(s);
						if(node.statue) {
							cur[i][j] = cur[i][j] + node.age/2;
							list[i][j].remove(s);
						} else {
							break;
						}
					}
				}
			}
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(list[i][j].size() == 0)
						continue;
					
					for(int s=0; s<list[i][j].size(); s++) { // 가을
						Node_16235 node = list[i][j].get(s);
						if(node.age%5 == 0) {
							for(int d=0; d<8; d++) {
								int nexti = i+diri[d];
								int nextj = j+dirj[d];
								if(nexti > N || nexti <= 0 || nextj > N || nextj <= 0)
									continue;
								
								list[nexti][nextj].add(new Node_16235(1, false));
							}
						}
					}
				}
			}
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					cur[i][j] = cur[i][j] + add[i][j]; // 겨울
				}
			}
		}
		
		int sum = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				sum = sum + list[i][j].size();
			}
		}
		
		System.out.println(sum);
	}
}

class Node_16235 {
	int age;
	boolean statue; // false => 살아있음, true => 죽음
	public Node_16235(int age, boolean statue) {
		this.age = age;
		this.statue = statue;
	}
}
