package 알고리즘수업_Z;
import java.util.Arrays;
/**
* LIS (Longest Increasing Subsequence) 최장 증가 수열
*  DP + Greedy, O[NlogN]
*      이진 검색 활용
*/
public class Z56_2_LIS3 {
    public static void main(String[] args) {
        int[] a = {8,2,4,3,6,11,7,10,14,5};
        int[] C = new int[a.length];    // LIS로 사용 가능성이 높은 index를 저장(LIS로 사용되지 않을 수도 있음)
        int size=0;    // LIS의 개수를 관리할 index
        // C 배열에서 의미있는 데이터, 마지막 숫자, C 배열에서 저장한 숫자의 개수
        int[]path = new int[a.length];        //LIS 수열을 추적하기 위한 경로 index를 저장
        
        path[size]=-1;    // 첫번째 수열(루트임을 표시)
        C[size++]=0;    // 첫번째 index는 바로 반영
        for(int i=1; i<a.length; i++) {    // 주어진 배열을 순회
            if(a[C[size-1]]<a[i]) {    // LIS 마지막 숫자보다 크면, LIS 뒤에 붙인다.
                path[i]=C[size-1];    // LTS의 마지막 숫자의 index를 나의 부모로 저장
                C[size++]=i;
            }else {    // LIS 마지막 숫자보다 크지 않으면, LIS 값을 업데이트한다.(이진탐색)
                int temp=binarySearch(a,C,0,size,a[i]);
                if(temp<0) {// 음수라면, 동일한 숫자
                    temp=-temp -1;    // 삽입할 위치
                    path[i]=path[C[temp]];
                    C[temp]=i;
                }                
            }
        }
        System.out.println(Arrays.toString(C));
        System.out.println("최장증가수열 : "+size+"개");
        System.out.println(Arrays.toString(path));
        
        String result = "";
        for (int i = C[size-1]; i != -1 ; i=path[i]) {
        	result = a[i]+" "+ result;
        }
        System.out.println("최장증가수열: " + result);
    }// end of main
   private static int binarySearch(int[] a,int[]C, int fromIndex, int toIndex,
                                    long key) {
       int low = fromIndex;
       int high = toIndex - 1;
       while (low <= high) {
           int mid = (low + high) >>> 1;
           long midVal = a[C[mid]];
           if (midVal < key)
               low = mid + 1;
           else if (midVal > key)
               high = mid - 1;
           else
               return mid; // key found
       }
       return -(low + 1);  // key not found.
   }
}// end of class