import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_3499_퍼펙트셔플_이정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int test=1;test<=tc;test++) {
			sb.setLength(0);
			int n=Integer.parseInt(br.readLine());
			String []s=br.readLine().split(" ");
			int half=s.length/2;
			
			if(s.length%2==0) { //Even
			    for(int i=0;i<half;i++) {
			    	sb.append(s[i]).append(" ");
			    	sb.append(s[half+i]).append(" ");
			    }
			}
			else {
				for(int i=0;i<half;i++) { 
					sb.append(s[i]).append(" ");
			    	sb.append(s[half+i+1]).append(" ");
				}
				sb.append(s[half]);
			}
			System.out.print("#"+test+" ");
			System.out.println(sb);
		}
	}

}
