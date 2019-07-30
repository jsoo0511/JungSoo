package com.ssafy.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy2 {  //windos/explorer를 dest위치로 옮기기
	File src=new File("c:/windows/explorer.exe"); 
	File dest=new File("c:/Temp/myexplorer.exe");
	int bufferSize=10;
	
	public static void main(String[] args) {
		long start=System.currentTimeMillis();
		FileCopy2 fc=new FileCopy2();
		try(BufferedInputStream fi=new BufferedInputStream(new FileInputStream(fc.src));
				BufferedOutputStream fout=new BufferedOutputStream(new FileOutputStream(fc.dest));){
		
			byte[] buffer=new byte[fc.bufferSize];
			int readed=-1;
			while((readed=fi.read(buffer))>0) { //데이터를 다 읽어들이면 -1 반환
				fout.write(buffer,0,readed);
			}
			System.out.println("done");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			long end=System.currentTimeMillis();
			System.out.println("Time: "+(end-start));
		}
		

	}

}
