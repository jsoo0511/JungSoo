package 알고리즘수업_Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Z40_회의실 {
	static class Node{
		int start;
		int end;
		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
	}
    static int arr[][];
    static int cnt;
    static int min;
    static ArrayList<Node> list;
    static ArrayList<Node> result;
    static ArrayList<Node> results;
    static int limit;
	public static void main(String[] args) throws IOException {
		cnt=0;
		min=100;
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		list=new ArrayList<>();
		result=new ArrayList<>();
		results=new ArrayList<>();
		String []s=br.readLine().split(" ");
		arr=new int[num][2];
		Node node;
		for(int i=0;i<s.length/2;i++) { //배열 초기화
		    arr[i][0]=Integer.parseInt(s[i*2]);
		    arr[i][1]=Integer.parseInt(s[i*2+1]);
		    node=new Node(arr[i][0],arr[i][1]);
		    list.add(node);
		}
		
		Collections.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o1.start-o2.start;
			}
		});
		
		
	   for(int i=0;i<list.size();i++)
		   System.out.println(list.get(i).start+" "+list.get(i).end);
		
		for(int i=0;i<list.size();i++) {
			cnt=0;
			limit=0;
			result.add(list.get(i));
			DFS(i);
			if(min>cnt)
			{
				min=cnt;
				for(int j=0;j<result.size();j++)
					results.add(result.get(j));
			}
			result.clear();
		}
		for(int i=0;i<results.size();i++)
			   System.out.println(results.get(i).start+" "+results.get(i).end);
		

	}
	
	public static void DFS(int i) {
		cnt++;
		result.add(list.get(i));
		limit+=list.get(i).end; //회의 시간 더함
		if(limit>24) {
			cnt--;
			limit-=list.get(i).end;//회의시간 감소
			result.remove(i);
			return;
		}else {
			for(int s=list.get(i).start+list.get(i).end;s<10;s++) {
				DFS(s);
			}
			cnt--;
			limit-=list.get(i).end;
			result.remove(i);
		}
	}

}
