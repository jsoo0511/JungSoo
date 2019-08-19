import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_퇴사 {
	static int n;
	static int arr[][];
    static int max=0;
    static int temp=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr=new int[n+1][2];
		for(int i=1;i<=n;i++) {
			String s[]=br.readLine().split(" ");
			for(int j=0;j<2;j++) {
				arr[i][j]=Integer.parseInt(s[j]);
			}
		}
		
		for(int i=1;i<=n;i++) {
			temp=0;
			DFS(i);
		}
		
		System.out.println(max);
		max=0;
	}
	
	public static void DFS(int day) {
		int T=arr[day][0];
		int P=arr[day][1];
		temp+=P;//금액더하기
		if((day+T)>n+1) { //현재의 날짜와 상담기간이 퇴사일을 넘어버리면 상담불가
			temp-=P; //줫던금액 빼고 종료
			return;
	    }
		
		for(int i=(day+T);i<=n;i++) {
			DFS(i);
		}
		if(temp>max) {
			max=temp;
		}
		T-=arr[day][0];//뒤로가면서 기간 뺴기
		temp-=arr[day][1];//뒤로가면서 이익빼기
	}

}
