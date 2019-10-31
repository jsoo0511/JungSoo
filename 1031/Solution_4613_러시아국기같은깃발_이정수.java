import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_4613_러시아국기같은깃발_이정수 {
	static int result,cnt,n,m;
    static char arr[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int test=1;test<=tc;test++) {
			String s[]=br.readLine().split(" ");
			n=Integer.parseInt(s[0]);
			m=Integer.parseInt(s[1]);
			result=Integer.MAX_VALUE;
			arr=new char[n][m];
			for(int i=0;i<n;i++) {
				String str[]=br.readLine().split("");
				for(int j=0;j<m;j++) {
					arr[i][j]=str[j].charAt(0);
				}
			}
			
			for(int w=0;w<n-2;w++) {
				for(int b=w+1;b<n-1;b++) {
					for(int r=b+1;r<n;r++) {
						cnt=0;
						check(w,b,r);
						if(cnt<result)
							result=cnt;
					}
				}
			}
			
			System.out.println("#"+test+" "+result);
		}

	}
	
	
	public static void check(int w, int b, int r) {
		for(int i=0;i<b;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]!='W')
					cnt++;
			}
		}
		for(int i=b;i<r;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]!='B')
					cnt++;
			}
		}
		for(int i=r;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]!='R')
					cnt++;
			}
		}
	}

}
