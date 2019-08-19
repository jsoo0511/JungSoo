import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main_백준_6378 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		String[] s1;
		int n = 11;
		int sum;
		while (n >= 10) {
			sum = 0;
			s = br.readLine();
			if (s.equals("0"))
				break;
			while (true) {
				sum=0;
				s1 = s.split("");
				
				for (String i : s1)
					sum += Integer.parseInt(i);
				
				if (sum >= 10)
					s = Integer.toString(sum);
				else {
					s = Integer.toString(sum);
					break;
				}
			}
			System.out.println(s);
		}

	}
}
