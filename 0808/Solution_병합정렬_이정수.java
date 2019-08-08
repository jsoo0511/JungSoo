import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Solution_병합정렬_이정수 {

	public static void main(String[] args) {
		Integer[] arr= {69,10,30,2,16,8,31,22}; //10개, 0~9
		
	
		System.out.println("정렬전: ");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		
		ArrayList<Integer> ll = new ArrayList(Arrays.asList(arr));//배열의 원소들 리스트에 추가
		
		System.out.println();
		System.out.println("정렬 후");
	    System.out.println(mergeSort(ll));
		

	}//end main
    /**두 덩어리의 리스트로 쪼개는 메서드 */
	public static List<Integer> mergeSort(List<Integer> ll){
		if (ll.size()<=1) { //종료파트 : 원소가 1개 이하이면 종료
			return ll;
		} else {
			int m=ll.size()/2;
			List<Integer> left=mergeSort(ll.subList(0,m));
			List<Integer> right=mergeSort(ll.subList(m,ll.size()));
			return merge(left,right);
		}
	}
	
	/** 정복 : 두 덩어리의 리스트를 하나로 합치는 메서드(합치면서 정렬작업함)*/
	public static List<Integer> merge(List<Integer> left, List<Integer> right){
		List<Integer> result = new ArrayList<Integer>(left.size()+right.size());//정렬해서 합친다.
		int l=0; //왼쪽리스트의 인덱스
		int r=0; //오른쪽리스트의 인덱스
		while(l<left.size() && r<right.size()) {//왼쪽,오른쪽 모두 원소가 있을 경우
			if(left.get(l)<=right.get(r)) {
				result.add(left.get(l++));
			} else {
				result.add(right.get(r++));
			}
		}
		
		while(l<left.size()) {//왼쪽만 원소가 있을 경우
			result.add(left.get(l++));
		}
		
		while(r<right.size()) {//오른쪽만 원소가 있을 경우
			result.add(right.get(r++));
		}
		return result;
	}
}//end class
