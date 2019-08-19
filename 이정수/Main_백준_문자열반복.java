import java.io.*;


public class Main_백준_문자열반복 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		
		for(int i=0;i<num;i++) {
			String []s=br.readLine().split(" ");
			int r=Integer.parseInt(s[0]);
			
			String []arr=s[1].split("");
			for(String le:arr) {
				for(int j=0;j<r;j++)
					System.out.print(le);
			}
			
			System.out.println(" ");
		}
	
	

	}


}


