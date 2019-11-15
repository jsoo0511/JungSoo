package 알고리즘수업_Z;

import java.util.Arrays;

public class Z36_재귀선택정렬 {
	public static int[] a= {3,6,1,9,4};
	public static int minIndex;

	public static void main(String[] args) {
		for1(0);//범위의 시작위치를 정하는 for
		System.out.println(Arrays.toString(a));

	}//end of main
	
	public static void for1(int i) {
		if(i==a.length) {
			return;
		} else {
			//i~끝 까지 범위, 범위내의 최소값위치 찾기, i<->최소값의 위치
			minIndex=i;
			for(int j=i;j<a.length;j++) {
				if(a[minIndex]>a[j])
					minIndex=j;
			}
			int temp = a[minIndex];
			a[minIndex] = a[i];
			a[i]=temp;
			for1(i+1);
		}
	}
	
	public static void for2(int i) {
		if(i==a.length) {
			return;
		} else {
			if(a[minIndex]>a[i])
				minIndex=i;
				
		}
	}

}
