import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_4050_재관이의대량할인_이정수 {
	static int arr[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		for(int test=1;test<=tc;test++) {
			int n=Integer.parseInt(br.readLine());
			String s[]=br.readLine().split(" ");
			arr=new int[s.length];
			for(int i=0;i<arr.length;i++) { //옷가격 배열 초기화
				arr[i]=Integer.parseInt(s[i]);
			}
			Arrays.sort(arr);
			int sum=0;
			int k=1;
			for(int i=arr.length-1;i>=0;i--) {
				if(k%3==0) {
					k=1;
					continue;
				} else {
					sum+=arr[i];
					k++;
				}
			}
			
			System.out.println("#"+test+" "+sum);
			
		}

	}

}
