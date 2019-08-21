import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Solution_1266_SW문제해결응용9일차_소수완제품확률_이정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        
        for(int test=1;test<=tc;test++){
        	String s[]=br.readLine().split(" ");
        	int a=Integer.parseInt(s[0]);
        	int b=Integer.parseInt(s[1]);
        	int arr[]={0,1,4,6,8,9,10,12,14,15,16,18};
        	double sa=a/100.0;
        	double sb=b/100.0;
        	double temp=0.0;
        	double result2=0.0;
        	double result=0.0;
        	BigDecimal Ba=new BigDecimal(String.valueOf(sa));
        	BigDecimal Bb=new BigDecimal(String.valueOf(sb));
        	BigDecimal one=new BigDecimal(String.valueOf(1));
        	sa=Ba.doubleValue();
        	sb=Bb.doubleValue();
        	double one_sa=(one.subtract(Ba)).doubleValue();
        	double one_sb=(one.subtract(Bb)).doubleValue();
        	for(int i=0;i<arr.length;i++){
        		result2=0.0;
        		temp=0.0;
        		temp=combi(18,arr[i])*Math.pow(sa, arr[i])*Math.pow(one_sa, (18-arr[i]));//a(i)가 소수가 아닌 장식 만들 확률
        		for(int j=0;j<arr.length;j++){//a(i)*b(j)확률
        			result2+=(temp*(combi(18,arr[j])*Math.pow(sb, arr[j])*Math.pow(one_sb, (18-arr[j]))));
        		}
        		result+=result2;
        	}
        	System.out.printf("#%d %.6f\n",test,1-result);
        }

	}
	
	public static int combi(int n, int r){
		 if(r==0 || r==n)
		     return 1;
		  else
		      return combi(n-1, r-1) + combi(n-1, r);
		}

}
