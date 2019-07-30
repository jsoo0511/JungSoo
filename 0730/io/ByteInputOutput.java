package com.ssafy.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ByteInputOutput {

	public static void main(String[] args) throws FileNotFoundException {
		fileTest();
		readFile();

	}
	
	//데이터 읽어보기
	public static void readFile() throws FileNotFoundException {
		//FileInputStream fi = null; //읽을때는 있는 파일에서
		//FileOutputStream fout=null;
		FileReader fi=null;
		FileWriter fout=null;
		
		//기본파일 전송버퍼
		try {
			fi=new FileReader("./hello.txt");
			fout=new FileWriter("./output.txt");
			//byte[] buffer=new byte[10];
			char [] buffer=new char[10];
	        int  readed=0;
			while( (readed=fi.read(buffer))>0) // 데이터를 다 읽어들이면 read는 -1을 반환
			{
				System.out.println(new String(buffer,0,readed));
				fout.write(buffer,0,readed);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		} catch(IOException e) {
			System.out.println("읽는 과정에서 오류가 발생");
		} finally {
			if(fi!=null)
			{
				try {
					fi.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
			
		}
	}
	
	//file처리
	public static void fileTest() {
		File file=new File("./hello.txt"); //현재경로 밑에 hello.txt를 나타내는 객체 생성, "."은 현재경로를 의미한다.
		System.out.println(file.getAbsolutePath());
		 //실제 물리적 파일 생성
		try {
			file.createNewFile();
			System.out.println("file생성완료");
		} catch (IOException e) {
			e.printStackTrace();
		}

 }

	
}
