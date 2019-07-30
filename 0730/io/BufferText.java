package com.ssafy.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BufferText {

	public static void main(String[] args) throws IOException {
		//소스? 타입? 방향? 기능?
		//키보드, byte, input, 속도 향상
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); //키보드 스트림 생성
		br=new BufferedReader(new StringReader(src));
		
		//줄 단위로 데이터 읽기
		String line=br.readLine();
		int t=Integer.parseInt(line);
		//공백 기준으로 token 생성
		StringTokenizer tokens=new StringTokenizer(br.readLine());
		System.out.println(tokens.countTokens());
		String first=tokens.nextToken();
		String second=tokens.nextToken();
		String third=tokens.nextToken();
		System.out.println(first+" "+second+" "+third+" "+t);
		
		String [] splited=br.readLine().split(" ");
		for(String str:splited)
			System.out.println(str);

	}
	static String src="3\r\n" + 
			"6 6 2\r\n" + 
			"34 42 22 32 21 24\r\n" + 
			"22 32 21 33 33 33\r\n" + 
			"13 11 12 21 43 13\r\n" + 
			"34 23 22 24 32 11\r\n" + 
			"22 24 21 41 41 42\r\n" + 
			"31 42 34 32 15 32\r\n" + 
			"2 3 2\r\n" + 
			"2 6 6\r\n" + 
			"3 3 4 4 2 6 5\r\n" + 
			"2 2 3  \r\n" + 
			"11 21\r\n" + 
			"41 31\r\n" + 
			"1 1 2\r\n" + 
			"2 1 2\r\n" + 
			"1 2 1\r\n" + 
			"1 2 2\r\n" + 
			"5 6 2\r\n" + 
			"22 32 21 33 33 33\r\n" + 
			"13 11 12 21 43 13\r\n" + 
			"34 23 22 24 32 11\r\n" + 
			"22 24 21 41 41 42\r\n" + 
			"31 42 34 32 15 32\r\n" + 
			"5 4 2\r\n" + 
			"1 3 1\r\n" + 
			"2 3 4 4 2\r\n" + 
			"\r\n" + 
			"#1 2300\r\n" + 
			"#2 -900\r\n" + 
			"#3 1500";

}
