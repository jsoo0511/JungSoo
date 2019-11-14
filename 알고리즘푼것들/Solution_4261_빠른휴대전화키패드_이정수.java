import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_4261_빠른휴대전화키패드_이정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		char arr[][]= {
				{},
				{},
				{'a','b','c'},
				{'d','e','f'},
				{'g','h','i'},
				{'j','k','l'},
				{'m','n','o'},
				{'p','q','r','s'},
				{'t','u','v'},
				{'w','x','y','z'}
		};
		
		for(int test=1;test<=tc;test++) {
			int cnt=0;
			String []str=br.readLine().split(" ");
			String comp[]=br.readLine().split(" ");
			String s=str[0]; //"6666"
			int n=Integer.parseInt(str[1]);
			boolean flag=true;
			for(int i=0;i<n;i++) { //단어들의 개수만큼 비교
				if(comp[i].length()!=s.length())//s와 comp안의 길이가 다르면 비교할 필요가 없다.
					continue;
				
				for(int j=0;j<s.length();j++) {
					int row=s.charAt(j)-'0';
					for(int k=0;k<arr[row].length;k++) {
						if(arr[row][k]==comp[i].charAt(j)) { //같은 값있으면 즉시 탈출
							flag=true;
							break;
						}else {
							flag=false;
						}
					}
					if(!flag)
						break;
				}
				if(flag)
					cnt++;
			}
			
			System.out.println("#"+test+" "+cnt);
		}
	}

}
