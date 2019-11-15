import java.util.Arrays;

/**
 * 선택정렬 : 정렬방법으로는 시간이 많이 걸려서 안쓰임
 *     k번째로 큰(작은)값을 찾을때, 셀렉션 알고리즘을 활용할 가치가 있다. 
 * @author student
 *
 */
public class Z10_SelectionSort {

	public static void main(String[] args) {
		int[] a= {6,4,1,9,2,8,5,7,3}; //9개 0~8
		//0~8에서 최소값: 0<->최소값 교환
		//1~8에서 최소값: 1<->최소값 교환
		
		for (int i = 0; i < a.length; i++) { //검색할 범위의 시작값
			//i~8에서 최소값 방번호 : i<->최소값교환
			int minIndex=i;
			for (int j = 0; j < a.length; j++) {//i~8끝
				if(a[minIndex]>a[j]) {
					minIndex=j; //swap아님, 가장작은방의 번호(index)를 저장
				}
			}
			
			//i<<->최소값 교환
			int temp=a[i];
			a[i]=a[minIndex];
			a[minIndex]=temp;
		}
		
		System.out.println(Arrays.toString(a));

	}

}
