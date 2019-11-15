import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Solution_7701_염라대왕의이름정렬_이정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		ArrayList<String> list;
		for (int test = 1; test <= tc; test++) {
			list = new ArrayList<>();
			int n = Integer.parseInt(br.readLine());
			String s[] = new String[n];
			HashMap<String, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				s[i] = br.readLine();
				if (!map.containsKey(s[i])) {
					map.put(s[i], 1);
					list.add(s[i]);
				}
			}
			
			Collections.sort(list, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					if(o1.length()==o2.length())
						return o1.compareTo(o2);
					else
						return o1.length()-o2.length();
						
				}
				
			});
			System.out.println("#"+test);
			for(String i:list)
				System.out.println(i);

		}

	}

}
