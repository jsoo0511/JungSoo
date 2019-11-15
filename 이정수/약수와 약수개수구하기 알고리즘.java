import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Solution_3501_순환소수짧게표현하기_이정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int tc = Integer.parseInt(br.readLine());
//		
//		for(int test=1;test<=tc;test++) {
//			String s[]=br.readLine().split(" ");
////			int mo=Integer.parseInt(s[0]);
////			int ja=Integer.parseInt(s[1]);
//			BigDecimal mo=new BigDecimal(Integer.parseInt(s[0]));
//			BigDecimal ja=new BigDecimal(Integer.parseInt(s[1]));
//			
//			System.out.println(mo.divide(ja,100,RoundingMode.HALF_EVEN));
//		}
		Scanner sc = new Scanner(System.in);
        System.out.println("약수 구할 숫자 입력");
        int b= sc.nextInt();
        sc.close();
        int mok,nmg,i;
        int c=0, d=-1;
        int[] a = new int[1000];
        while (true){
            c++;
            /*
            나머지를 구하기 위해서 몫이 필요로 함!
            그리고 나머지가 0이면 약수임
             */
            if(c<=b){
                mok = b/c;
                nmg = b- mok*c;
                if(nmg==0){
                    d++;
                    a[d]= c;
                }
            }
            else{  //c>b
                System.out.println("a[d], d="+d);
                for(i = 0; i<=d; i++){
                    System.out.println("약수 배열 a["+i+"]"+"="+a[i]);
                }
                break;
            }
        }// while 

	}

}
