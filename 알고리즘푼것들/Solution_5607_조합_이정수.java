import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5607_조합_이정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		
		for(int test=1;test<=tc;test++) {
			String s[]=br.readLine().split(" ");
			long n=Integer.parseInt(s[0]);
			long r=Integer.parseInt(s[1]);
			long p=1234567891;
			long nFac=1;
			long temp=1;
			long nr=n-r;
			//n!
			for(int i=1;i<=n;i++) {
				temp=temp*i;
				if(temp>p)
					temp=temp%p;
			}
			n=temp;
			temp=1;
			System.out.println("n: "+n);
			//r!
			for(int i=1;i<=r;i++) {
				temp=temp*i;
				if(temp>p)
					temp=temp%p;
			}
			r=temp;
			
			//r!^(p-2)
			for(int i=1;i<=p-2;i++) {
				r=r*r;
				if(r>p)
					r=r%p;
			}
			System.out.println("r: "+r);
			temp=1;
			//(n-r)!
			for(int i=1;i<=nr;i++) {
				temp=temp*i;
				if(temp>p)
					temp=temp%p;
			}
			nr=temp;
			temp=1;
			//r!^(p-2)
			for(int i=1;i<=p-2;i++) {
				nr=nr*nr;
				if(nr>p)
					nr=nr%p;
			}
			System.out.println("nr: "+nr);
			long result=(n/(r*nr))%p;
			System.out.println("#"+test+" "+result);
			
		}

	}

}
