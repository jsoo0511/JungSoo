import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5550_나는개구리로소이다_이정수 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		char arr[]= {'c','r','o','a','k'};
		boolean visited[];
		for (int test = 1; test <= tc; test++) {
			int result=0;
			int cnt=0;
			
			char ch[]=br.readLine().toCharArray();
			visited=new boolean[ch.length];
//			int alpha[]=new int[26];
//			for(int i=0;i<ch.length;i++) {
//				alpha[ch[i]-'a']++;
//				cnt++;
//			}
			
			if(ch.length%5 !=0) {
				System.out.println("#"+test+" "+-1);
			}else {
				int index=0;
				for(int i=0;i<ch.length;i++) {
					char temp=arr[i%5];
					System.out.println("wanna: "+temp);
					boolean flag=false;
					for(int j=index+1;j<ch.length;j++) {
						if(ch[j]==temp&& !visited[j]) {
							System.out.println(ch[j]+" : "+j);
							visited[j]=true;
							flag=true;
							index=j+1;
							break;
						}
					}
					
					if(!flag)
						break;
					
					if(temp=='k'&& i!=ch.length-1) {
								index=0;
					}
					
				}
			}
			
			System.out.println("#"+test+" "+result);
				
		}
	}

}
