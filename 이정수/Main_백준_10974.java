import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_백준_10974 {
       static ArrayList<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int arr[]=new int[n];
		for(int i=1;i<=n;i++)
			arr[i-1]=i;
		perm(n,0);
		

	}
	
	public static void perm(int n,int k) {
		if(n==k) {
		//	list.add
		}
	}

}
