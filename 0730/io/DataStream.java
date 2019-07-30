package com.ssafy.io;

import java.io.*;

public class DataStream {

	public static void main(String[] args) throws Exception {
		// c:/Temp/data.txt에 123,true를 저장해보자.
		File file = new File("c:/Temp/data.txt");// 목적지
		// 스트림 구성(file, write, byte, --> 기본형 저장)

		try (DataOutputStream dout = new DataOutputStream(new FileOutputStream(file));
				DataInputStream din = new DataInputStream(new FileInputStream(file));
				) {
			dout.writeInt(123); //file에 쓰기
			dout.writeBoolean(true);
			System.out.println("쓰기완료");
			
			int num=din.readInt();
			boolean bool=din.readBoolean();
			System.out.println(num+" : "+bool);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
