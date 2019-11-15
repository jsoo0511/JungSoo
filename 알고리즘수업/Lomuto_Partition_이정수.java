package 알고리즘수업_Z;
import java.util.Arrays;
public class Lomuto_Partition_이정수 {
    static int[] arr;
    public static void main(String[] args) {
        arr = new int[]{3,2,4,6,9,1,8,7,5};
        quickSort(0,arr.length-1);
        for(int i:arr)
        	System.out.print(i+" ");
    }
    public static void quickSort(int l, int r) {
        if(l<r) {
            int s=lomuto_partition(l,r);
            quickSort(l, s-1);
            quickSort(s+1, r);
        }
    }

    public static int lomuto_partition(int p, int r) {
        int x = arr[r];
        int i = p-1;
        
        for(int j=p; j<r; j++) {
            if(arr[j]<=x) {
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }            
        }
        int temp=arr[i+1];
        arr[i+1]=arr[r];
        arr[r]=temp;
        
        return i+1;
    }
}