import java.util.LinkedList;
import java.util.Queue;

public class 마이쮸 {

	public static void main(String[] args) {
		Queue<Integer> q=new LinkedList<>();
		int mychew=20;
		int check[]=new int[20]; //애들마다 줘야될 개수
		int result=0;
		for(int i=0;i<20;i++) //일단 1개씩
			check[i]=1;
		while(mychew>0) {
			for(int i=1;i<100;i++) {
				q.offer(i); //새로운 애 줄 세우고 
				int p=q.poll();//맨 앞에 있는 애 확인하고
				mychew-=check[p]; //몇개 줘야되는지 확인
				
				if(mychew<=0) {
					result=p;
					break;
				}
				check[p]++; //주고나서 얘한테 줘야될거 1개 늘려주기
				q.offer(p);  //뺏던애 줄세우고
				
			}
		}
		System.out.println("결과: "+result);
	

	}

}
