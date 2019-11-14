import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1225_SW문제해결기본7일차_암호생성기_이정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Queue<Integer> q;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int test=1;test<=10;test++) {
			q=new LinkedList<Integer>();
			int n=Integer.parseInt(br.readLine());//test번호
		    String[]s=br.readLine().split(" ");
		    for(int i=0;i<8;i++) {//큐 초기화
		    	q.add(Integer.parseInt(s[i]));
		    }
		    boolean flag=false;
		    while(true) {
		    	for(int i=1;i<=5;i++) {
		    		int front=q.poll()-i; //앞에서 i만큼 감소시킨후
		    		if(front<=0) {
		    			q.offer(0);
		    			flag=true;
		    			break;
		    		}	
		    		q.offer(front); //뒤에다 삽입
		    	}
		    	if(flag)
		    		break;
		    }
		    
		    System.out.print("#"+test+" ");
			for(int i:q)
				System.out.print(i+" ");
			System.out.println();
		}

	}

}
