package 알고리즘수업_Z;

import java.util.Arrays;

/**
 * 
 * 특정 문자열의 모든 부분문자열을 알고 싶을때 모든 접미사 -> 정렬 -> LCP를 구해놓음 -> 각 접미사의 모든 접두사 -> 유효한
 * 문자열의 개수
 * 
 * 트라이 Trie : 문자열의 집합을 표현하는 트리 Compressed Trie : 문자열의 접미사 트라이의 압축된 표현 접미어
 * 트리(Suffix Trie) : Compressed Trie의 개선된 표현, 문자열 끝에 $표시함 생성 시간복잡도 O[n^2] =>
 * O[nlogn] => O[n] 접미어 배열(Suffix Array) : 접미어들을 사전식으로 나열한 배열 메모리 절약 1/4 (접미어
 * 트리에 비해서), 속도가 느림, 접미어 트리보다 간단하다 생성 시간복잡도 O[nlogn] (정렬을 해야하기 떄문에) LCP 배열 : 최장
 * 공통접두어, 접미어 배열 사용시 보조적으로 사용 두 문자열 사이의 공통 접두어의 길이
 *
 */
public class Z48_SuffixArray {

	public static void main(String[] args) {
		String s = "banana";

		// s 문자열의 모든 접미사를 생성
		int[] sa = new int[s.length()];// Suffix Array: 접미사의 시작하는 index를 저장
		for (int i = 0; i < sa.length; i++) {
			sa[i] = i;
		}

		
		// 모든 접미사를 정렬 => 선택 정렬(O[n^2]) => 퀵정렬(O[nlogn])
		for (int i = 0; i < sa.length; i++) { // 선택정렬
			int minIndex = i;
			for (int j = i + 1; j < sa.length; j++) {
				// minIndex~끝 j~끝
				if (s.substring(sa[minIndex]).compareTo(s.substring(sa[j])) > 0) {
					System.out.println("In: "+s.substring(sa[minIndex])+" , "+s.substring(sa[j]));
					minIndex = j;
					System.out.println("minIndex: "+minIndex);
				}
			}

			// i<->minIndex swap
			int temp = sa[minIndex];
			sa[minIndex] = sa[i];
			sa[i] = temp;
			System.out.println(Arrays.toString(sa));
		}
		// 정렬된 접미사의 LCP를 구함
		int[] LCP = new int[s.length()];// 최장 공통 접두어를 저장할 배열
//		LCP[4]= 3번째로 시작하는 문자열, 4번쨰로 시작하는 문자열의 최장 공통접두어의 개수
		for (int i = 1; i < LCP.length; i++) {
			String s1 = s.substring(sa[i - 1]);
			String s2 = s.substring(sa[i]);
			while (s1.length() > LCP[i] && s2.length() > LCP[i] && s1.charAt(LCP[i]) == s2.charAt(LCP[i])) {
				LCP[i]++;
			}
		}
		System.out.println(Arrays.toString(LCP) + " : LCP");
		// 모든 접미사의 접두사를 생성
		for (int i = 0; i < sa.length; i++) {
			String str = s.substring(sa[i]);
			System.out.println("<<" + str + ">>");// 접미사 출력
			// 각 접미사로 만들 수 있는 모든 접두사
			for (int j = 1; j <= str.length(); j++) {
				System.out.println(str.substring(0, j));
			}
			System.out.println(str.length() + " : 접두사의 개수");// = 해당 접미사의 길이
			System.out.println(LCP[i] + ": 최장공통접두사의 개수");
			System.out.println((str.length() - LCP[i]) + ":유효한 부분 문자열의 개수");
		}
System.out.println();
		// s 문자열에서 만들 수 있는 모든 부분문자열에서 사전식으로 정렬한 상태의 K번째 문자열을 구하라
		int k = 13;
		System.out.println("s 문자열에서 만들 수 있는 모든 부분문자열에서 사전식으로 정렬한 상태의" + k + "번째 문자열을 구하라");
		for (int i = 0; i < sa.length; i++) {
		//	String str = s.substring(sa[i]);// 접미사 임시저장 <= 저장하지 않고 하도록 수정하기
			int len=s.length()-sa[i]; //접미사의 글자 길이 sa[i] ~끝
			
			if (k - (len - LCP[i]) > 0) {
				k = k - (len - LCP[i]);
			} else {
				System.out.println(s.substring(sa[i],sa[i]+LCP[i]+k));
				//System.out.println(str.substring(0,LCP[i]+k));//k번째 접미사
				break;
			}
		}
		// 유효한 문자열

	}// end main

}// end class
