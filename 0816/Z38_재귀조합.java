package 알고리즘수업_Z;

import java.util.Arrays;

public class Z38_재귀조합 {
	public static int []arr= {6,7,8,9};
	public static int[] trr;

	public static void main(String[] args) {
		int r=3; //nCr    n:전체개수    r:뽑을 개수
		trr=  new int[r];//뽑은 수를 저장할 배열
		comb(arr.length,r);

	}
	
	public static void comb(int n,int r) {
		if(r==0) {//다 선택한 경우
			System.out.println(Arrays.toString(trr));
		} else if(n<r) {//조합에서 항상 n>=r이어야 한다.
			return; //잘못된 경우는 제거
		}
		else {
			trr[r-1] =arr[n-1];
			System.out.printf("r-1: %d, trr[r-1]:%d, n-1: %d, arr[n-1]:%d\n",r-1,trr[r-1],n-1,arr[n-1]);
			comb(n-1,r-1);//n-1번째 숫자를 사용한 경우
			comb(n-1,r);//n-1번째 숫자를 사용안한 경우
		}
	}

}
