import java.util.Arrays;

/**
 * Backtracking 가지치기
 * @author student
 *
 */
public class Z22_Backtracking {
	public static int[] arr= {6,7,8,9}; //순열을 구할 원래배열
	
	public static void main(String[] args) {
		//arr의 순열을 모두 구해보자(멱집합: powerset)!!!
		
		int []a= new int[arr.length]; //순열의 index순번을 저장할 배열, 0번째 원소도 사용 
		backtrack(a,0,a.length); //순열로 표현할 개수

	}//end main
	/**
	 * @param a: 순열의 index순번을 저장할 배열
	 * @param k: 현재 단계, input과 같아질때까지 반복
	 * @param input: 순열로 표현할 개수
	 * 
	 */
	public static void backtrack(int[] a, int k, int input) {
		if(k==input) { //종료파트(해인가?) isSolution()
			process_solution(a,k); //각 완성단계에서 하고싶은 작업(출력)
		}else { //재귀파트
			int[] c = new int[a.length]; //후보군을 저장할 배열
			int ncands = make_candidates(a,k,input,c); //후보군을 만든어오는 메서드, ncands리턴
			System.out.println("ncands: "+ncands);
			for(int i=0;i<ncands;i++) {
				a[k]=c[i];
				System.out.println("a배열(index저장)상태: "+Arrays.toString(a));
				backtrack(a,k+1,input); //다음 단계를 재귀호출
			}
		}
	}
	
	public static int make_candidates(int[] a, int k, int input, int[] c) {
	    boolean[] in_perm = new boolean[a.length]; //각 index가 사용했었는지 여부를 체크할 flag
	    for (int i = 0; i < k; i++) {//현재 단계 전까지 사용한 숫자들을 체크
	    	System.out.println(i+" "+Arrays.toString(in_perm));
			in_perm[a[i]] = true; //사용함체크
		}
	    
	    //in_perm 배열에 false 인 index는 사용안한 숫자임 => 후보군으로 담아서 보냄
	    int ncands=0; //후보군의 개수를 카운팅할 변수
	    for (int i = 0; i < in_perm.length; i++) {
			if(!in_perm[i]) { //사용하지 않은 숫자라면
				c[ncands++]=i;
			}
		}	
		return ncands;//후보군의 개수 리턴
	}
	
	/**각 완성단계에서 하고싶은 작업(출력) */
	public static void process_solution(int[] a,int k) {
		for (int i = 0; i < k; i++) {
			//System.out.print(a[i]+" "); //저장된 순번index을 출력해보기
			System.out.print(arr[a[i]]+" ");
		}
		System.out.println();
		System.out.println();
	}
	

}// end class
