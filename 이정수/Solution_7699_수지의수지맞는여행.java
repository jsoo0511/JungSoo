import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_7699_수지의수지맞는여행 {
	static char srr[][];
	static int n;
	static int m;
    static int []alpha;
    static int []dr={0,1,0,-1};//행 이동 우하좌상
    static int []dc={1,0,-1,0};//열 이동
    static int cnt;
    static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int test=1;test<=tc;test++) {
			alpha=new int[26];
			String []s=br.readLine().split(" ");
			n=Integer.parseInt(s[0]);
			m=Integer.parseInt(s[1]);
			srr=new char[n+2][m+2];
			char[] temp;
			for(int i=1;i<=n;i++) { //1행1열부터 채움 0행,0열은 무시
				String str=br.readLine();
				temp=str.toCharArray();
				for(int j=1;j<=m;j++) {
					srr[i][j]=temp[j-1];
				}
			}
			for(int i=0;i<n+2;i++){
				for(int j=0;j<m+2;j++){
					if(i==0 || i==n+1 ||j==0 || j==m+1)
						srr[i][j]='0';
				}
			}
			cnt=0;
			max=0;
			dfs(1,1); //1,1부터 시작
			System.out.println("#"+test+" "+max);
		}

	}
	
	public static void dfs(int r,int c) {
		alpha[srr[r][c]-'A']++; //해당 알파벳 방문시 플러스해준다.
		cnt++;
		if(cnt>max)
			max=cnt;
		
		for(int i=0;i<4;i++){
			int temp_r=r+dr[i];//row좌표
			int temp_c=c+dc[i];//col좌표
			if(srr[temp_r][temp_c]!='0' && alpha[srr[temp_r][temp_c]-'A']==0){//한번도 방문하지 않았으면, 주변 빈공간이 아니라면	
				dfs(temp_r,temp_c);//한번더 전진
				//전진후 되돌아옴
				alpha[srr[temp_r][temp_c]-'A']--;
				cnt--;
				}
			}
		}
	

}
