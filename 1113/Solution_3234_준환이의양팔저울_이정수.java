import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_3234_준환이의양팔저울_이정수 {
	static int n,arr[],cnt,sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int test=1;test<=tc;test++) {
			n=Integer.parseInt(br.readLine());
			arr=new int[n];
			String s[]=br.readLine().split(" ");
			cnt=0;
			sum=0;
			for(int i=0;i<n;i++)
				arr[i]=Integer.parseInt(s[i]);
			
			    perm(arr.length,arr.length,0);
			    
			    System.out.println("#"+test+" "+cnt);
		}

	}
	
	public static void perm(int n, int r, int size) {
		if(size==r) {
			System.out.println(Arrays.toString(arr));
			dfs(0,0,0);
			return;
		}
		
		
		for(int i=size;i<r;i++) {
			int temp=arr[size];
			arr[size]=arr[i];
			arr[i]=temp;
			perm(n,r,size+1);
			temp=arr[size];
			arr[size]=arr[i];
			arr[i]=temp;
		}
	}
	
	public static void dfs(int depth,int left, int right) {
		if(depth==n) {
			cnt++;
			return;
		}
		sum=left+arr[depth];
		System.out.println("sum: "+sum);
		dfs(depth+1,sum,right);
		sum=right+arr[depth];
		System.out.println("sum, left, right: "+sum+", "+left+", "+right);
		if(sum<=left)
			dfs(depth+1,left,sum);
		
	}

}
