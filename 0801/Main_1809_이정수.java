
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1809_이정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		int[]arr=new int[num];
		String []s=br.readLine().split(" ");
		int[] result=new int[num];
		for(int i=0;i<num;i++)
			arr[i]=Integer.parseInt(s[i]);
	
		for(int i=0;i<num;i++) {
			for(int j=i;j>=0;j--) {
				if(arr[j]>arr[i]) {
					result[i]=j+1;
					break;
				}
			}
		}
		
	   for(int i:result)
		   System.out.print(i+" ");

	}

}
=======
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1809_이정수{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < num; i++)
			arr[i] = Integer.parseInt(s[i]);
		boolean flag = false;
		for (int i = 0; i < num; i++) {
			flag = false;
			for (int j = i; j >= 0; j--) {
				if (arr[j] > arr[i]) {
					flag = true;
					sb.append(j + 1).append(" ");
					break;
				}
			}
			if (!flag)
				sb.append("0").append(" ");
		}
		System.out.println(sb);
	}

}

