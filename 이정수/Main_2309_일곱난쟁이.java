import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main_2309_일곱난쟁이 {
	static int [] arr;
	static int []trr;
	static int result;
	static boolean flag=false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr=new int[9];
		trr=new int[7];//뽑은 수를 저장할 배열
		for(int i=0;i<9;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		int n=9;
		int r=7;
		result=0;
		combi(n,r);
	}
	
	public static void combi(int n,int r) {
		if(flag)
			return;
		
		if(r==0) {
			int temp=0;
			for(int i=0;i<7;i++)
				temp+=trr[i];
			if(temp==100) {
				Arrays.sort(trr);
				for(int i:trr)
					System.out.println(i);
				flag=true;
				return;
			}
		}
		else if(n<r)
			return;
		else {
			trr[r-1]=arr[n-1];
			combi(n-1,r-1);
			combi(n-1,r);
		}
					
	}
	
	
}
