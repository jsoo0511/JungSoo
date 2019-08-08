import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1228_SW문제해결기본8일차_암호문1_이정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> arr;
		Queue<String> q;
		int original_len=0;
		int order_len;
		for(int tc=1;tc<=10;tc++) {
			arr=new ArrayList<>();
			q=new LinkedList<String>();
			original_len=Integer.parseInt(br.readLine());//원본길이
			String []s=br.readLine().split(" ");
			for(int i=0;i<original_len;i++) //원본 10개만 집어넣음
				arr.add(s[i]);
			
		    order_len=Integer.parseInt(br.readLine()); //명령어수
		    String[]sq=br.readLine().split(" ");
		    for(String i:sq)
		    	q.offer(i);
		    
		    while(!q.isEmpty()) {
		    	if(q.peek().equals("I")) { //명령어시작점이면
		    		q.poll();//명령어 I버리고
		    		int start=Integer.parseInt(q.poll());//시작점 넣고
		    		int limit=Integer.parseInt(q.poll());
		    		
		    		for(int i=start;i<start+limit;i++) {//1-6
		    			arr.add(i, q.poll());//i번째에 q앞에 값 삽입
		    		}
		    	}
		    }
		    System.out.print("#"+tc+" ");
		    for(int i=0;i<10;i++)
		    	System.out.print(arr.get(i)+" ");
		    System.out.println();
			
		}

	}

}
