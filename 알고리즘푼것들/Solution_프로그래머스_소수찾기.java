import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution_프로그래머스_소수찾기 {

	public static void main(String[] args) {
		Solution_프로그래머스_소수찾기 ex = new Solution_프로그래머스_소수찾기();
		String numbers = "011";
		System.out.println(ex.solution("17"));
		System.out.println(ex.solution("011"));
		System.out.println(ex.solution("12"));

	}
	HashMap<String, Integer> map;
	public int solution(String numbers) {
		int answer = 0;
		ArrayList<String> list = new ArrayList<>();
		map=new HashMap<>();
		String arr[] = numbers.split("");
		for (int i = 1; i <= numbers.length(); i++) {
			perm(arr, arr.length, i, 0, list, i);
		}
		
		
		//에라토스테네스의 채 적용
		for(int i=0;i<list.size();i++) {
			int n=Integer.parseInt(list.get(i));
			if(n==1)
				continue;
			boolean flag=false;
			for(int k=2;k<=(int)Math.sqrt(n);k++) {
				if(n%k ==0) {
					flag=true;
					break;
				}
				else {
					flag=false;
				}
			}
			
			if(!flag)
				answer++;
		}
		return answer;
	}
	
	public int perm(String arr[], int n, int r, int size, ArrayList<String> list, int len) {

		if (size == r) {
			String s = "";
			for (int i = 0; i < len; i++) {
				s += arr[i];
			//	System.out.println("s: "+s);
			}
			
			if (s.charAt(0) != '0' && !map.containsKey(s)) {
		//		System.out.println("enter: "+s);
				list.add(s);
				map.put(s, 1);
			}
		} else {
			for (int i = size; i < n; i++) {
				String temp = arr[size];
				arr[size] = arr[i];
				arr[i] = temp;
				perm(arr, n, r, size + 1, list, len);
				temp = arr[size];
				arr[size] = arr[i];
				arr[i] = temp;
			}
		}

		return 0;
	}

}
