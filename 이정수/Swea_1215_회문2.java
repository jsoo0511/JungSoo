package aaa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea_1215_회문2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char arr[][];
		int result;
		for (int test = 1; test <= 10; test++) {
			int num=Integer.parseInt(br.readLine());
			arr = new char[100][100];
			result = 0;
			
			for(int i=0;i<100;i++) {
				char[] s = br.readLine().toCharArray();
				for(int j=0;j<100;j++) {
					arr[i][j]=s[j];
				}
			}
boolean flag1=true;
boolean flag2=true;

			for (int len = 100; len > 0; len--) {// 회문의 길이
				for (int start = 0; start <= 100 - len; start++) {//해당 회문길이에서 검사, 97의 경우 시작점을0-2 
					for (int row = 0; row < 100; row++) {
						flag1=true;
						flag2=true;
						for (int i = 0; i < len / 2; i++) {
							if (arr[row][start + i] != arr[row][len - 1 + start - i]) {
								flag1=false;
								break;
							}
						}
						
						for(int i=0;i<len/2;i++) {
							if (arr[start + i][row] != arr[len - 1 + start - i][row]) {
								flag2=false;
								break;
							}
						}
						
						if(flag1 || flag2) {
							result=len;
							break;
						}
					}
					if(flag1 || flag2) {
						break;
					}
				}
				if(flag1 || flag2) {
					result=len;
					break;
				}
			}
			
			System.out.println("#"+test+" "+result);
		}
	}

}
