

public class Solution_이진검색_이정수 {
	static boolean flagRecur=false;
	public static void main(String[] args) {

		int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int key = 9;

		int left = 0;
		int right = arr.length - 1;
		int pivot;
		boolean flag = false;
		

		// 반복문 이진탐색
		while (right >= left) {
			pivot = (right + left) / 2;

			if (key == arr[pivot]) {
				flag = true;
				break;
			}
			if (key < arr[pivot])
				right = pivot - 1;
			else
				left = pivot + 1;
		}

		if (flag)
			System.out.println(key + "가(이) 배열안에 존재합니다.");
		else
			System.out.println(key + "가(이) 배열안에 없습니다.");

		//재귀탐색
		BSearchRecur(arr, 0, arr.length - 1, key);
		
		if(flagRecur)
			System.out.println(key + "가(이) 배열안에 존재합니다.(재귀함수)");
		else
			System.out.println(key + "가(이) 배열안에 없습니다.(재귀함수)");

	}

	public static void BSearchRecur(int ar[], int left, int right, int target) {
		int pivot = (left + right) / 2;
		if(left>right)
			return;

		if (ar[pivot] == target) {
			flagRecur=true;
			return;
		}
		else {
			if (ar[pivot] > target) {
				right = pivot - 1;
				BSearchRecur(ar, left, right, target);
			} else {
				left = pivot + 1;
				BSearchRecur(ar, left, right, target);
			}
		}
	}
}
