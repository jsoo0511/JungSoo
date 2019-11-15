
public class Z23_거듭제곱 {

	public static void main(String[] args) {
		int base=2;  //밑수
		int exp=30; //지수
		int result=1;
		
		for (int i = 0; i < exp; i++) {
			result *= base;
		}

		System.out.println(result);
		System.out.println(power(base,exp));
	}//end main
	
	public static int power2(int base, int exp) {
		if(exp==1) { //종료조건
			return base;
		} else if(exp==0){ //종료조건
			return 1;
		} 
		
		//반복조건
		int temp=power2(base,exp/2);
		temp*=temp;
		if(exp%2==1) { //홀수냐
			temp*=base;
		}
		return temp;
		
		
		
//		if(exp%2==0) {//짝수냐
//			//return power2(base,exp/2) * power2(base,exp/2);
//			int temp=power2(base,exp/2);
//			return temp*temp;
//		} else {//홀수냐
//			int temp= power2(base,exp/2);
//			return temp*temp*base;
//		}
	}
	
	public static int power(int base,int exp) {
		if(exp==0) {
			return 1;
		} else {
			return 2*power(base,exp-1);
		}
	}

}
