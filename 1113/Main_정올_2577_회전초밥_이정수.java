import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_정올_2577_회전초밥_이정수 {
	static int n, d, k, c;
	static int arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		Queue<Integer> q = new LinkedList<Integer>();
		n = Integer.parseInt(s[0]); // 접시수
		d = Integer.parseInt(s[1]); // 초밥 가짓수
		k = Integer.parseInt(s[2]); // 연속해서 먹는 접시 수
		c = Integer.parseInt(s[3]); // 쿠폰번호
		arr = new int[n];
		int check[] = new int[d + 1];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		int max = 0;
		for (int i = 0; i < n + k - 1; i++) {
			if (i >= n) {//i가 n초과시
				if (check[arr[(i-1)%n]] != 0) {
					check[arr[(i-1)%n]] += 1;
					q.add(arr[(i-1)%n]);
				} else {
					check[arr[(i-1)%n]] += 1;
					q.add(arr[(i-1)%n]);
					cnt++;
				}
			} else {//i가 n보다 아래시
				if (check[arr[i]] != 0) {
					check[arr[i]] += 1;
					q.add(arr[i]);
				} else {
					check[arr[i]] += 1;
					q.add(arr[i]);
					cnt++;
				}
			}

			if (q.size() == k) {
				if(check[c]!=0) {//c가 포함된 경우
					if(max<cnt)
						max=cnt;
				}
				else {//c가 포함되지 않아 추가로 받을 수 있는 경우
					if(max<cnt+1)
						max=cnt+1;
				}
				
				//가장 앞에 있는거 제거
				check[q.peek()]-=1;
				if(check[q.peek()]<=0)
					cnt--;
				q.poll();
				
			}
		}
		System.out.println(max);
	}

}