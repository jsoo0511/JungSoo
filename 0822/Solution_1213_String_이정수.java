import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1213_String_이정수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test=1;test<=10;test++){
			int tc=Integer.parseInt(br.readLine());
			String part=br.readLine();
			String s=br.readLine();
			int cnt=0;
			int len=part.length();
			String temp;
			for(int i=0;i<s.length();i++){
				if(s.charAt(i)==part.charAt(0)){
					if(i+len<=s.length())
					    temp=s.substring(i,i+len);
					else
						continue;
					if(temp.equals(part))
						cnt++;
				}
				else
					continue;
			}
			
			System.out.println("#"+test+" "+cnt);
		}

	}

}
