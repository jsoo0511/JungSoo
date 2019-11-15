import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_4014_활주로건설_이정수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int test=1;test<=tc;test++) {
			String s[]=br.readLine().split(" ");
			int n=Integer.parseInt(s[0]);
			int x=Integer.parseInt(s[1]);//경사로 길이
			int result=0;
			int arr[][]=new int[n][n];
			boolean garo[][]=new boolean[n][n]; //가로 활주로건설여부
			boolean sero[][]=new boolean[n][n]; //세로 활주로건설여부
			for(int i=0;i<n;i++) {
				String str[]=br.readLine().split(" ");
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(str[j]);
				}
			}
			
			for(int i=0;i<n;i++) { //가로체크
				boolean flag=true;
				outer:for(int j=0;j<n-1;j++) {
					flag=true;
					
					if(arr[i][j]-1==arr[i][j+1]) {//오른쪽이 1만큼 낮다면
						for(int k=j+1;k<=j+x;k++) {
							if(j+x>=n) {//범위를 벗어나버리면
								flag=false;
								break outer;
							}else {
								if(arr[i][j+1]!=arr[i][k] || garo[i][k]) {//만약 경사로의 길이보다 평지가 짧거나 경사로가 지어져있다면
									flag=false;
									break outer;//경사로의 길이보다 평지가 짧다면 활주로 건설 불가
								}
								garo[i][k]=true;
							}
						}
					} else if(arr[i][j]+1 == arr[i][j+1]) {//오른쪽이 1만큼 크다면
						for(int k=j;k>=j-x+1;k--) {
							if(j-x+1<0) { //범위를 벗어나버리면
								flag=false;
								break outer;
							}
							else {
								if(arr[i][j]!=arr[i][k] || garo[i][k]) {
									flag=false;
									break outer;
								}
								garo[i][k]=true;
							}
						}
					} else if(arr[i][j]==arr[i][j+1]) {
						continue;
					} else {//높이차가 2 나는 경우
						flag=false;
						break outer; //그 행은 활주로 건설 불가
					}
				}
				if(flag) {//활주로 건설 가능
					result++;
				}
			}
			for(int j=0;j<n;j++) {
				boolean flag=true;
			outer:for(int i=0;i<n-1;i++) {

					flag=true;
					if(arr[i][j]-1==arr[i+1][j]) {//아래쪽이 1만큼 낮다면
						for(int k=i+1;k<=i+x;k++) {
							if(i+x>=n) {//범위를 벗어나버리면
								flag=false;
								break outer;
							}else {
								if(arr[i+1][j]!=arr[k][j] || sero[k][j]) {//만약 경사로의 길이보다 평지가 짧다면
									flag=false;
									break outer;//경사로의 길이보다 평지가 짧다면 활주로 건설 불가
								}
								sero[k][j]=true;
							}
						}
					} else if(arr[i][j]+1 == arr[i+1][j]) {//아래쪽이 1만큼 크다면
						for(int k=i;k>=i-x+1;k--) {
							if(i-x+1<0) { //범위를 벗어나버리면
								flag=false;
								break outer;
							}
							else {
								if(arr[i][j]!=arr[k][j] || sero[k][j]) {
									flag=false;
									break outer;
								}
								sero[k][j]=true;
							}
						}
					} else if(arr[i][j]==arr[i+1][j]) {
						continue;
					} else {//높이차가 2 나는 경우
						flag=false;
						break outer; //그 행은 활주로 건설 불가
					}
				
				}
				if(flag) {//활주로 건설 가능
					result++;
				}
			}
			
			System.out.println("#"+test+" "+result);
		}//test

	}//main
}