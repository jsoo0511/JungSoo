import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_3059 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		int []alpha;
		int result=0;
		for(int i=0;i<t;i++) {
			alpha=new int[91];
			result=0;
			String s=br.readLine();
			char[] ch=s.toCharArray();
			for(int j=0;j<ch.length;j++) {
				alpha[ch[j]-0]++;
			}
			for(int j=65;j<=90;j++) {
				if(alpha[j]==0)
					result+=j;
			}
			System.out.println(result);
		}
		

	}

}
