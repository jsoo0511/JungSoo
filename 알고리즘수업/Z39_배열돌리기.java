package 알고리즘수업_Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Z39_배열돌리기 {
	public static int[][] A;
	public static int[][] Acopy;
	public static int[][] cycle;//회전 연산정보
	public static int[] arr; //순열시 사용할 배열
	public static int min=Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken()); //행
		int M=Integer.parseInt(st.nextToken()); //열
		int K=Integer.parseInt(st.nextToken()); //회전 연산개수
		
		A=new int[N+1][M+1];
		Acopy=new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=M;j++) {
				A[i][j]=Integer.parseInt(st.nextToken()); //1<=A[i][j]<=100
			}
		}
		
		cycle=new int[K][3];
		for(int i=0;i<K;i++) {
			st=new StringTokenizer(br.readLine()," ");
			cycle[i][0]=Integer.parseInt(st.nextToken());
			cycle[i][1]=Integer.parseInt(st.nextToken());
			cycle[i][2]=Integer.parseInt(st.nextToken());
		}
		
		
		//순열
		arr=new int[K];//명령문의 개수만큼 배열 크기 지정
		for(int i=0;i<arr.length;i++) {
			arr[i]=i;
		}
		perm(0,K);
		System.out.println(min);
	}//end main
	
	public static void cycleA(int[] cycle) { //3 4 2
		for(int s=cycle[2];s>0;s--) {
			int size=s*2+1;//회전할 사각형의 한변의 길이
			int r=cycle[0]-s;
			int c=cycle[1]-s;
			
			int temp= Acopy[r][c];
			for(int i=1;i<size;i++) {
				//하
				Acopy[r][c]=Acopy[r+1][c];
				r++;
			}
			for(int i=1;i<size;i++) {
				//우
				Acopy[r][c]=Acopy[r][c+1];
				c++;
			}
			for(int i=1;i<size;i++) {
				//상
				Acopy[r][c]=Acopy[r-1][c];
				r--;
			}
			for(int i=1;i<size;i++) {
				//우
				Acopy[r][c]=Acopy[r][c-1];
				c--;
			}
			Acopy[r][c+1]=temp;
			
			
		}
	}
	public static void perm(int step,int K) {
		if(step==K) {
			System.out.println(Arrays.toString(arr));
			//순열
			//회전을 시키기(원본 배열을 하나 복사해서 사용)
			for(int i=0;i<A.length;i++) {
				Acopy[i]=A[i].clone();//clone은 1차원배열만 복사 가능하다.
			}
			
			for(int i=0;i<arr.length;i++) {
				cycleA(cycle[arr[i]]);
			}
			//각 행의 합 구하기
			for(int i=1;i<Acopy.length;i++) {
				int sum=0;
				for(int j=1;j<Acopy[i].length;j++) {
					sum+=Acopy[i][j];
				}
				//각 합중 최소값을 구하기
				if(min>sum)
					min=sum;
			}
			
		} else {
			for(int i=step;i<K;i++) {
				//swap step<->i
				int temp=arr[step];
				arr[step]=arr[i];
				arr[i]=temp;
				
				perm(step+1,K);
				
				//복구
				temp=arr[step];
				arr[step]=arr[i];
				arr[i]=temp;
			}
		}
	}

}
