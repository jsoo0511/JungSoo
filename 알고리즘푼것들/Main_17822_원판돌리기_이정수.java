import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17822_원판돌리기_이정수 {
	static int arr[][];
    static int check[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);// 원판의 수 1-n
		int m = Integer.parseInt(s[1]);// 원판안의 수의 개수
		int t = Integer.parseInt(s[2]);// 회전수
		arr = new int[n + 1][m + 1];
		int sum=0;
       
		for (int i = 1; i <= n; i++) { // 원판초기화 북->동->남->서
			String str[] = br.readLine().split(" ");
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(str[j - 1]);
			}
		}
		int order[][] = new int[t][3];

		for (int i = 0; i < t; i++) {// 명령초기화
			String orders[] = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				order[i][j] = Integer.parseInt(orders[j]);
			}
		}

		for (int rotate = 0; rotate < t; rotate++) {
			int x = order[rotate][0];// 움직일 원판 번호
			int d = order[rotate][1];// 방향 0-> 시계(col++) , 1->반시계(col--)
			int k = order[rotate][2];// 움직이는 양
             //n=3, m=4   m+1=5
			sum=0;
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=m;j++) {
					sum+=arr[i][j];
				}
			}
			 check = new int[n+1][m+1];
			if (d == 0) { //시계방향
				for (int i = 0; i < k; i++) {
					int last=arr[x][m];
					for (int j = m; j >1; j--) {
						arr[x][j]=arr[x][j-1];
					}
					arr[x][1]=last;
				}
			}
			else {//반시계방향
				for(int i=0;i<k;i++) {
					int first=arr[x][1];
					for(int j=1;j<m;j++) {
						arr[x][j]=arr[x][j+1];
					}
					arr[x][m]=first;
				}
				
			}
			
			System.out.println("회전후");
			
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=m;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
				
			}
			System.out.println();
			
			boolean flag=false; //인접한 수 유무판별
			//인접유무 체크
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=m;j++) {
					//위로 인접하면
					int up=i-1;
					if((i-1)%n==0)
						up=n;
					if(arr[i][j]==arr[up%n][j]) {
						check[i][j]=1;
						check[up][j]=1;
						flag=true;
					}
					
					int down=i+1;
					if((i+1)%(n+1)==0) {
						down=1;
					}
					
					if(arr[i][j]==arr[down%n][j]) {
						check[i][j]=1;
						check[down][j]=1;
						flag=true;
					}
					
					int left=i-1;
					if((i-1)%m==0)
						left=m;
					
					if(arr[i][j]==arr[i][left%m]) {
						check[i][j]=1;
						check[i][left]=1;
						flag=true;
					}
					
					int right=i+1;
					if((i+1)%(m+1)==0)
						right=1;
					
					if(arr[i][j]==arr[i][right%m]) {
						check[i][j]=1;
						check[i][right]=1;
						flag=true;
					}
				}
			}//인접수 판별
			System.out.println("check");
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=m;j++) {
					System.out.print(check[i][j]+" ");
				}
				System.out.println();
				
			}
			System.out.println();
			
			if(flag) {
				for(int i=1;i<=n;i++) {
					for(int j=1;j<=m;j++) {
						if(check[i][j]==1) {
							arr[i][j]=0;
						}
					}
				}
			} else {
				int avg=sum/n*m;
				for(int i=1;i<=n;i++) {
					for(int j=1;j<=m;j++) {
						if(arr[i][j]==0)
							continue;
						else if(arr[i][j]<avg)
							arr[i][j]++;
						else if(arr[i][j]>avg)
							arr[i][j]++;
						else
							continue;
							
					}
				}
				
			}
			
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=m;j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
				
			}
			System.out.println();

		}//1바퀴 회전
		System.out.println(sum);
		

	}

}
