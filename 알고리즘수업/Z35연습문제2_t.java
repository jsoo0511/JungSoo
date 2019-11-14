package 알고리즘수업_Z;

public class Z35연습문제2_t {

	public static void main(String[] args) {
		String[] binString = { 
				"0000", 
				"0001", 
				"0010", 
				"0011",
				"0100",
				"0101",
				"0110", 
				"0111", 
				"1000",
				"1001",
				"1010",
				"1011", 
				"1100", 
				"1101",
				"1110",
				"1111",
		};
		String s = "0F97A3";
		String result = "";// 2진수 결과를 저장할 변수
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ('0' <= c && c <= '9') {
				result += binString[c - '0'];
			} else {
				result += binString[c - 'A' + 10];
			}
		}
		System.out.println(result);

		// 앞에서부터 7개씩 잘라서 숫자로 변환
		int value = 0; // 2진수 7개 비트를 10진수로 변환할 변수
		for (int i = 0; i < result.length(); i++) {
			// value에 값을 누적=이전까지 구한 값*2+새로가져온 값
			value = value*2 + (result.charAt(i)-'0');
			//7비트가 모여진 순간 출력, value초기화
			
			if(i%7==6) {
				System.out.print(value+", ");
				value=0;
			}
		}
		System.out.println(value);

	}
}
