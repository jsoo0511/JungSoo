import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_7584_자가복제문자열_이정수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int test = 1; test <= tc; test++) {
			int k = Integer.parseInt(br.readLine());

			String pF = "0";
			String bitM = "";

			while(true) {
				if(k<pF.length())
					break;
				bitM="";
				for (int i = 1; i <= pF.length(); i++) {
					if (pF.charAt(pF.length() - i) == '0')
						bitM += "1";
					else
						bitM += "0";
				}
				
				pF=pF+"0"+bitM;
			}
			
			
			char result=pF.charAt(k-1);
			
			
			System.out.println("#"+test+" "+result);

		}

	}

}
