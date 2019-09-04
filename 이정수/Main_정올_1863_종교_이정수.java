import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_정올_1863_종교_이정수 {
	public static ArrayList<Integer> list[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[]=br.readLine().split(" ");
        Queue<Integer> q=new LinkedList<Integer>();
        boolean flag=true;
        int count=0;
        int n=Integer.parseInt(s[0]); //학생수
        int m=Integer.parseInt(s[1]); //학생 쌍의 수
        boolean visited[]=new boolean[n+1];
        list=new ArrayList[n+1];//1부터 n명이므로 n+1
        
        for(int i=1;i<=n;i++) {//list배열 초기화
        	list[i]=new ArrayList<>();
        }
        
        for(int i=0;i<m;i++) {
        	String str[]=br.readLine().split(" ");
        	int one=Integer.parseInt(str[0]);
        	int two=Integer.parseInt(str[1]);
        	
        	list[one].add(two);
        	list[two].add(one);
        }
        
        for(int i=1;i<=n;i++) {
        	
        	if(visited[i])
        		continue;
        	
        	if(list[i].size()!=0) {//리스트가 채워져있으면
        		q.offer(i);
        		visited[i]=true;
        	}
        	
        	while(!q.isEmpty()) {
        		
        		int person=q.poll();
        		visited[person]=true;
        	    for(int j=0;j<list[person].size();j++) {
        	    	
        	    	if(!visited[list[person].get(j)]) {
        	    		visited[list[person].get(j)]=true;
        	    	    q.offer(list[person].get(j));
        	    	}
        	    }
        	}
        	
        	count++;
        	flag=true;
        	for(int k=1;k<=n;k++) {
             	if(!visited[k]) {
             		flag=false;
             		break;
             	}
             }
        	 
        	 if(flag)
        		 break;
        }
        
        System.out.println(count);
       
		
	}

}
