import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_14889_스타트와링크_이정수 {
	static int arr[][];
	static int trr[],idx[],re[];
	static int n;
    static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		min=Integer.MAX_VALUE;
		arr=new int[n][n];
		trr=new int[n/2];
		idx=new int[n];
		re=new int[n/2];
		for(int i=0;i<n;i++) {
			idx[i]=i;
		}
		for(int i=0;i<n;i++) {
			String s[]=br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(s[j]);
			}
		}
		
		combi(n,n/2);
		System.out.println(min);

	}
	
	
	public static void combi(int n,int r) {
		if(r==0) {
			int result=0;
			int remain=0;
			int k=0;
			for(int i=0;i<arr.length;i++) {
				boolean flag=false;
				for(int j=0;j<trr.length;j++) {
					if(trr[j]==i) {
						flag=true;
						break;
					}
				}
				if(!flag)
					re[k++]=i;
			}
			for(int i=0;i<trr.length;i++) {
				for(int j=0;j<trr.length;j++) {
					if(i==j)
						continue;
					result+=arr[trr[i]][trr[j]];
					remain+=arr[re[i]][re[j]];
				}
			}
			if(Math.abs(result-remain)<min)
				min=Math.abs(result-remain);
		} else if(n<r) {
			return;
		} else {
			trr[r-1]=idx[n-1];
			combi(n-1,r-1);
			combi(n-1,r);
		}
	}

}
