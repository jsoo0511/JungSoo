import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16987_계란으로계란치기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][2];
		boolean visited[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			String s[] = br.readLine().split(" ");
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(s[j]);// s[0]: 내구도 , s[1]: 무게
			}
		}
        int cnt=0;
		for (int i = 0; i < n; i++) {
			int egg_d = arr[i][0];
			int egg_w = arr[i][1];
			int min_d = egg_d;
			int min_w = egg_w;
			int index = i;
			boolean flag=false;
			while (!visited[i]) {
				flag=false;
				for (int j = 0; j < n; j++) {
					if (i == j || visited[j])
						continue;
					if (min_d >= arr[j][0]) {// 내구도가 min보다 작거나 같을 경우
						if (min_d == arr[j][0]) {// 내구도가 같은 경우
							if (min_w > arr[j][1]) {// 무게가 min보다 작으면
								min_w = arr[j][1];
								index = j;
								flag=true;
							} else {// 내구도 무게 둘다 같으면 그냥 진행
index=j; flag=true;
							}
						} else {// 내구도, 무게 모두 min보다 작은 경우
							index = j; flag=true;
						}
					}
				}
             if(flag) {
				arr[i][0] -= arr[index][0];
				arr[i][1] -= arr[index][1];
				arr[index][0] = arr[i][0];
				arr[index][1] = arr[i][1];
             } else {
            	 break;
             }
				if(arr[i][0]<=0 && !visited[i]) {
					visited[i]=true;
					cnt++;
				}
				if(arr[index][0]<=0 && !visited[index]) {
					visited[index]=true;
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);

	}

}
