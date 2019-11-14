import java.util.Arrays;

/**
 * 이진검색 : 정렬이 된 데이터 군에서 검색하는 방법
 * @author student
 *
 */


public class Z09_BinarySearch {

	public static void main(String[] args) {
		int a[]= {1,2,3,4,5,6,7,8,9};
		int start=0;//검색범위의 첫번째 인덱스임, 값x
		int end=a.length-1;
		//int key=8;
		while(start<=end) {//검색할 범위가 남아있으면 반복
			int mid=(start+end)/2; //중간위치값
			
			if(a[mid]==key)
			{
				System.out.println("찾음");
				break;
			}
			else if(key<a[mid]) {//key가 중간값보다 작은 경우
				end=mid-1;
			}
			else {
				start=mid+1;
			}
		}
		
		if(start>end)
			System.out.println("못찾음");
		int index=Arrays.binarySearch(a, key);
		//System.out.println(index+" "+a[index]);
		
		System.out.println("B "+bs(0,b.length-1));

	}
	static int b[]= {1,2,3,4,5,6,7,8,9}; //정렬이 된 데이터
	static int key=8;
	
	public static int bs(int start, int end) {
		if(start>end) { //종료파트
			return -1;
		} else { //재귀파트
			int mid=(start+end)/2;
			if(key<b[mid]) {//작은 쪽으로
				return bs(start,mid-1);
			} else if(key>b[mid]) { //큰 쪽으로 
				return bs(mid+1,end);
			} else {//같은 경우
				return mid;
			}
				
		}
	}
	


}
