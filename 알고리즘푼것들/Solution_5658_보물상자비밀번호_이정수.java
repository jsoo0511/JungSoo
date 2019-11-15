import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution_5658_보물상자비밀번호_이정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		ArrayList<Integer> list;
	    for(int test=1;test<=tc;test++) {
	    	String s[]=br.readLine().split(" ");
	    	int n=Integer.parseInt(s[0]);
	    	int k=Integer.parseInt(s[1]);
	    	int limit=n/4;//한변의 길이, 움직여야 하는 수 12의 경우 3, 16의 경우 4
	    	String num=br.readLine();
	    	String numbers[]=num.split("");
	    	list=new ArrayList<>();
	    	for(int i=0;i<limit;i++) {
	    		String temp;
	    		for(int j=0;j<4;j++) {
	    			temp="";
	    			for(int q=j*limit;q<j*limit+limit;q++)
	    			    temp+=numbers[q];
	    			int dec=Integer.parseInt(temp,16);
	    			boolean flag=true;
	    			for(int t=0;t<list.size();t++) {
	    				if(list.get(t) == dec) {
	    					flag=false;
	    					break;
	    				} 
	    			}
	    			if(flag)
	    				list.add(dec);
	    		}
	    		//1바퀴 회전
	    		String tNum=numbers[0];
	    		for(int d=0;d<numbers.length-1;d++) {
                       numbers[d]=numbers[d+1];	    	
	    		}
	    		numbers[numbers.length-1]=tNum;
	    	}
	    	
	    	Collections.sort(list, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
			});
	    	
	    	System.out.println("#"+test+" "+list.get(k-1));
	    }

	}

}
