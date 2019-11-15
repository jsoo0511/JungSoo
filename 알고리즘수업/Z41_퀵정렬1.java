package 알고리즘수업_Z;

public class Z41_퀵정렬1 {
	public static int[]a={3,2,4,6,9,1,8,7,5};
	public static void main(String[] args) {
		//int []arr= {9,1,7,2,4};
	
		quickSort(0,a.length-1);
		for(int i:a)
			System.out.print(i+ " ");

	}
	//피봇을 기준으로 분할하는 메서드, 피봇은 정렬된 위치로 옮겨진다.
	public static void quickSort(int l,int r) {
		if(l>=r) {//종료파트, 원소가 2개 이상일때만 정렬을 진행
			return;
		}
		
		//재귀파트
		//int pivot=hoarePartition(l,r);
		int pivot=lomutoPartition(l,r);
		quickSort(l,pivot-1);
		quickSort(pivot+1,r);
	}
	/**피봇을 기준으로 작거나 같은 값을 좌측,큰 값을 우측에 i~j 인덱스 범위안으로 지정,
	 * i위치는 큰값 범위의 1칸 전 인덱스, j위치는 큰 값 범위의 마지막 인덱스, a[i]<큰값들  <=a[j] */
	public static int lomutoPartition(int l, int r) {
		int pivot = a[r];//피봇을 우측 끝으로 지정
		int i =l-1; //큰 값 범위의 1칸 전 인덱스
		
		for(int j=l;j<r;j++) {
			if(a[j]<=pivot) {
				i++;
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		int temp=a[i+1];//큰 영역의 첫번째 숫자와 피봇을 교환
		a[i+1]=a[r];
		a[r]=temp;
		return i+1;//피봇의 위치
		
	}
	
	
	
	/**
	 * l-r범위에서 피봇을 기준으로 작거나 같은 값은 좌측, 큰 값은 우측으로 배치, 피봇의 위치를 리턴
	 */
	public static int hoarePartition(int l, int r) {
		int pivot=l; //피봇을 좌측 끝으로 지정
		while(l<=r) {//원소가 있으면 진행하기, l<r도 가능함
			//반드시 배열의 인덱스를 벗어나지 않는지 체크 필요
			while(l<a.length && a[l]<=a[pivot]) l++; //좌측은 작거나 같은 값
			while(0<=r && a[pivot]<a[r]) r--; //우측은 큰 값
			if(l<r) {//인덱스가 교차했으면 반복을 종료, 교차하지 않았으면 swap후 다시 반복
				int temp = a[l];
				a[l]=a[r];
				a[r]=temp;
				
			}
		}
		
		int temp=a[r];
		a[r]=a[pivot];
		a[pivot]=temp;
		
		return r;//임시로 써놓음
	}

}
