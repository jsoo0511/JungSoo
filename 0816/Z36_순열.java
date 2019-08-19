package 알고리즘수업_Z;

import java.util.Arrays;

/**
 * 순열 알고리즘
 *  1. 반복문으로 작성(6중 for문)
 *  2. Backtracking으로 단원: 후보군 목록 구해옴(사용한 숫자를 체크해서, 사용안한 숫자의 목록을 만듦)
 *  3. swap 방법으로 반복하고, 사용안한 숫자들은 뒷쪽에 남아있도록 배치, 코드 간단(필수로 외워두기)
 *
 */
public class Z36_순열 {
	public static int[] arr = {6,7,8,9};
	
	public static void main(String[] args) {
		perm(arr.length,0);
		
	}//end of main
	
	/**n : 몇개 뽑을지, k: 현재 단계*/
	public static void perm(int n,int k) {
		if(k==n) {
			System.out.println(Arrays.toString(arr));
		} else {
			//현재 0번째 단계칸에 모든 숫자를 채우고, 다음 1번 단계로 사용하지 않은 숫자에 대해 반복
			for(int i=k;i<n;i++) {
				//swap(k위치 <-> i위치)
				int temp=arr[k];
				arr[k]=arr[i];
				arr[i]=temp;
				//System.out.printf("arr[i]: %d, arr[k]: %d, i값: %d, k값: %d\n",arr[i],arr[k],i,k);
				//System.out.println("바뀌는 중: "+Arrays.toString(arr));
				perm(n,k+1);
				
				//swap(k위치 <-> i위치) 원상복귀
				temp=arr[k];
				arr[k]=arr[i];
				arr[i]=temp;
			//	System.out.printf("복구 arr[i]: %d, arr[k]: %d\n",arr[i],arr[k]);
			
			}
		}
	}

}
