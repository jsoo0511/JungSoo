import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16234_인구이동_이정수 {
	static int n, right, left,cnt,sum;
	static int arr[][];
	static boolean visited[][];
	static boolean calc[][];
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static boolean flag=true;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		left = Integer.parseInt(s[1]);
		right = Integer.parseInt(s[2]);
		arr = new int[n][n];
        int move=0;
		for (int i = 0; i < n; i++) {
			String str[] = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		while (flag) {
			flag = false;
			visited=new boolean[n][n];//한번돌때마다 방문초기화
			calc=new boolean[n][n];//인구이동 계산여부 배열
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						cnt=1;
						sum=arr[i][j];
						visited[i][j] = true;
						dfs(i, j);
						
						if(cnt!=1) {//인구이동 가능한 도시가 2개이상이면
							int avg=sum/cnt;
							
							for(int x=0;x<n;x++) {
								for(int y=0;y<n;y++) {
									if(visited[x][y] && !calc[x][y]) {
										arr[x][y]=avg;
										calc[x][y]=true;
									}
								}
							}
							
						} else
							calc[i][j]=true;
					}
				}
			}
			
			if(!flag) {//더이상 인구이동이 없으면
				break;
			}
			move++;
		}
		System.out.println(move);

	}

	public static void dfs(int r, int c) {

		for (int i = 0; i < 4; i++) {
			int tempr = r + dr[i];
			int tempc = c + dc[i];
			if (isRange(tempr, tempc) && !visited[tempr][tempc] && Math.abs(arr[r][c] - arr[tempr][tempc]) >= left && Math.abs(arr[r][c] - arr[tempr][tempc]) <= right) {			
				flag = true;// 인구이동 가능하면 flag변경
				visited[tempr][tempc] = true;
				sum+=arr[tempr][tempc];//연합의 인구수
				cnt++;//인구이동 가능한 도시개수
				dfs(tempr, tempc);

			}
		}
	}

	public static boolean isRange(int r, int c) {
		if (r >= 0 && r < n && c >= 0 && c < n)
			return true;
		else
			return false;
	}

}