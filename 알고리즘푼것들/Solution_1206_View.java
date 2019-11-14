import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1206_View {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int []arr;
		
		for(int test=1;test<=10;test++) {
			int n=Integer.parseInt(br.readLine());
			String s[]=br.readLine().split(" ");
			int temp;
			int result=0;
			int max=0;
			arr=new int[n+4]; //양 옆의 2개씩 추가
			boolean flag=true;
			for(int i=2;i<arr.length-2;i++)//배열초기화
				arr[i]=Integer.parseInt(s[i-2]);
			
			for(int i=2;i<arr.length-2;i++) {//양옆 2번째 검사
				temp=0;
				flag=true;
				max=0;
				for(int j=1;j<=2;j++) { //양옆 높은 빌딩 있나 검사
					if(arr[i]<arr[i+j] || arr[i]<arr[i-j])
					{
						flag=false;
						break;
					}
					else {
						if(arr[i+j]<arr[i-j]) {
							if(max<arr[i-j])
								max=arr[i-j];
						}
						else {
							if(max<arr[i+j])
								max=arr[i+j];
						}
					}
				}
				if(flag)
					result+=arr[i]-max;
			}
			System.out.println("#"+test+" "+result);
			
		}
	}
}
