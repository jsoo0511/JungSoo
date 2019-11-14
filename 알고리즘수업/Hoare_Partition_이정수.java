package 알고리즘수업_Z;

public class Hoare_Partition_이정수 {
  //  static int arr[];
	public static void main(String[] args) {
		//int []arr= {9,1,7,2,4};
		int []arr= {3,2,4,6,9,1,8,7,5};
		quickSort(arr,0,arr.length-1);
		for(int i:arr)
			System.out.print(i+ " ");

	}
	
	public static void quickSort(int arr[],int left,int right) {
		if(left<right) { 
			int s=partition(arr,left,right);
			quickSort(arr,left,s-1);
			quickSort(arr, s+1, right);
		}
		
		
	}
	
	public static int partition(int arr[],int left,int right) {
		int p=arr[left];
		int i=left+1;
		int j=right;
		
		while(i<=j) {
			while(arr[i]<=p && i<=j) {
				i++;
			}
			while(arr[j]>=p && i<=j) {
				j--;
			}
			if(i<j) {
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		
		int temp=arr[left];
		arr[left]=arr[j];
		arr[j]=temp;
		
		return j;
	}

}
