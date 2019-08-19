import java.io.*;


public class Main_백준_명령프롬프트 {
	 
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		
		String []s=new String[num];
		for(int i=0;i<num;i++) {
			s[i]=br.readLine();
		}
		
		char []temp=s[0].toCharArray();
		for(int i=0;i<s[0].length();i++) {
		    for(int j=1;j<num;j++) {
		    	if(temp[i]!=s[j].charAt(i))
		    	{	temp[i]='?';
		    	    break;
		    	}
		    }
		}
		
		System.out.println(temp);
	
	

	}


}


