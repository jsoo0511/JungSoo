import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_6782_현주가좋아하는제곱근놀이_이정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
	    for(int test=1;test<=tc;test++) {
	    	long n=Long.parseLong(br.readLine());
	    	int cnt=0;
	    	while(n!=2) {
	    		long temp=(long)Math.sqrt(n);
	    		if(Math.pow(temp, 2)==n) {
	    			cnt++;
	    			n=temp;
	    		}else {
	    			long num=(temp+1)*(temp+1);
	    			cnt+=(num-n);
	    			n=num;
	    		}
	    	}
	    	sb.append("#").append(test).append(" ").append(cnt).append("\n");
	    }
	    System.out.println(sb);

	}

}
