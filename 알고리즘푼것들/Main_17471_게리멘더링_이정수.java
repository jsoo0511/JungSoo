import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_17471_게리멘더링_이정수 {
	public static int n,sum;
    public static int arr[];
    public static boolean visited[];
    public static ArrayList<Integer> list[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String s[]=br.readLine().split(" ");
		arr=new int[n+1];
		visited=new boolean[n+1];
		list=new ArrayList[n+1];
		sum=0;
		for(int i=1;i<=n;i++) { //각 구역의 인원수
			arr[i]=Integer.parseInt(s[i-1]);
			sum+=arr[i];//인구수 총합
		}
		
		for(int i=1;i<=n;i++)//배열리스트 초기화
			list[i]=new ArrayList<>();
		
	     for(int i=1;i<=n;i++) {//그래프 생성
	    	 String str[]=br.readLine().split(" ");
	    	 for(int j=1;j<=Integer.parseInt(str[0]);j++) {
	    		 list[i].add(Integer.parseInt(str[j]));
	    	 }
	     }
	     
	    
		 
		
		

	}

}
