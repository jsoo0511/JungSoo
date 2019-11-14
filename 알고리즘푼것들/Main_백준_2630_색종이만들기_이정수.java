import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2630_색종이만들기_이정수 {
	static int[][] arr;
	static int white,blue,n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		arr=new int[n][n];
		white=0; //0 
		blue=0;  //1
		for(int i=0;i<n;i++) {//배열초기화
			String s[]=br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(s[j]);
			}
		}
		
		divide(0,0,n);
		
		System.out.println(white);
		System.out.println(blue);
	}
	
	public static void divide(int row, int col,int n) {
		int temp=arr[row][col];
		boolean flag=true;
		outer:for(int i=row;i<row+n;i++) {
			for(int j=col;j<col+n;j++) {
				if(temp!=arr[i][j]) {
					flag=false;
					break outer;
				}
			}
		}
		
		if(flag) {
			if(temp==1)
				blue++;
			else
				white++;
			
			return;
		}
		else {
			divide(row,col,n/2);//1사분면탐색
			divide(row,col+n/2,n/2);//2사분면탐색
			divide(row+n/2,col,n/2);//3사분면탐색
			divide(row+n/2,col+n/2,n/2);//4사분면탐색
		}
	}

}
