package 알고리즘수업_Z;

import java.util.Arrays;

/**
 *LIS(Longest Increasing Subsequence)최장 증가 수열
 *DP 접근 방법, O[n^2]
 *
 *LIS를 구성하는 수열을 출력하고 싶다면, DP외의 별도 작업이 필요하다.
 */

public class Z55_LIS {

	public static void main(String[] args) {
		int a[]= {3,2,6,4,5,1};
		int LIS[]=new int[a.length]; //i번째 숫자를 마지막 글자로 사용할 경우의 최장증가수열의 길이
		int[] path=new int[a.length]; //최장증가수열을 추적할 경로, 부모의 index를 저장
		
		for (int i = 0; i < a.length; i++) {
			LIS[i]=1; //초기값(나 자신 하나의 숫자로 만들 수 있는 수열의 길이)
			path[i]=-1;//부모가 없는 루트를 의미
			for (int j = 0; j < i;j++) {//내 앞쪽의 범위에서
				//나보다 작은 숫자중, 최장증가수열+1의 최대값으로 갱신
			//	System.out.println("체크: "+Arrays.toString(LIS));
				if(a[j]<a[i] && LIS[i]<LIS[j]+1) {
					LIS[i]=LIS[j]+1;//j번째 숫자 다음에 i번째 숫자를 붙여서 수열을 만든다는 의미
					path[i]=j;//누구다음에 붙였는지 저장
				}
			}
		}
		System.out.println(Arrays.toString(path));
		System.out.println(Arrays.toString(LIS));
		int maxLISIndex=0;
		for (int i = 0; i < LIS.length; i++) {
			if(LIS[maxLISIndex]<LIS[i]) {
				maxLISIndex=i;//인덱스만 저장
			}
		}
		
		System.out.println("최장증가수열의 길이: "+LIS[maxLISIndex]+"개");
		System.out.println(Arrays.toString(path));
		String result="";
		for(int i=maxLISIndex;i!=-1;i=path[i]) {
			result = a[i]+" "+result;
		}
		System.out.println("최장증가수열: "+result);
	}

}
