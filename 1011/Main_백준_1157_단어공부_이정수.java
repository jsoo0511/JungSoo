import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_백준_1157_단어공부_이정수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		s=s.toUpperCase();
		HashMap<Character, Integer> map=new HashMap<>();
		int max=0;
		int ch=1;
		Queue<Character> q=new LinkedList<>();
		
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(map.containsKey(c)) {
				int num=map.get(c);
				map.put(c, num+1);
			} else {
				map.put(c, 1);
			}
		}
		
		Iterator it=map.keySet().iterator();
		
		while(it.hasNext()){
			   char key =(char) it.next();
			   if(map.get(key)>max)
				   max=map.get(key);
		}
		Iterator it2=map.keySet().iterator();
		while(it2.hasNext()){
			   char key =(char) it2.next();
			   if(map.get(key)==max)
				   q.add(key);
			   
			   if(q.size()>1) {
				   ch=-1;
				   break;
			   }
		}
		
		if(ch==1)
			System.out.println(q.poll());
		else
			System.out.println("?");

	}
	
	
}
