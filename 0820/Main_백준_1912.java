import java.io.*;


public class Main_백준_1912 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		String []s=br.readLine().split(" ");
		int arr[]=new int[num];
		for(int i=0;i<num;i++)
			arr[i]=Integer.parseInt(s[i]);
		
		int dp[]=new int[num];
		dp[0]=arr[0];
		int max=arr[0];
		for(int i=1;i<num;i++) {
			dp[i]=Math.max(dp[i-1]+arr[i],arr[i]);
			if(max<dp[i])
				max=dp[i];
		}
	System.out.println(max);

	}


}


