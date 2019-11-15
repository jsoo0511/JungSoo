import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution_3501_순환소수짧게표현하기_이정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int test=1;test<=tc;test++) {
			String s[]=br.readLine().split(" ");
//			int mo=Integer.parseInt(s[0]);
//			int ja=Integer.parseInt(s[1]);
			BigDecimal mo=new BigDecimal(Integer.parseInt(s[0]));
			BigDecimal ja=new BigDecimal(Integer.parseInt(s[1]));
			
			System.out.println(mo.divide(ja,100,RoundingMode.HALF_EVEN));
		}

	}

}
