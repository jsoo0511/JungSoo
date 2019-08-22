import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2007_패턴마디의길이_이정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		int result=0;
		for(int test=1;test<=tc;test++){
			boolean check=false;
			String s=br.readLine();
			for(int i=1;i<30;i++){
				
				String temp=s.substring(0,i);
				result=temp.length();
				for(int j=0;j<(30/i);j++){
					String temp_s=s.substring(j*result,j*result+result);
					if(temp_s.equals(temp)){
						check=true;
					}
					else{
						check=false;
						break;
					}
				}
				if(check)
					break;
			}
			System.out.println("#"+test+" "+result);
		}

	}

}
