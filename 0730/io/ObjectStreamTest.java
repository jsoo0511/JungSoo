package com.ssafy.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {

	public static void main(String[] args) {
		File file=new File("c:/Temp/object.dat");
		//file에다 저장, byte, write, --> 객체 저장
		Person p = new Person("hong");
		
		try (ObjectOutputStream oout=new ObjectOutputStream(new FileOutputStream(file));
				ObjectInputStream oin= new ObjectInputStream(new FileInputStream(file))
				){
			oout.writeObject(p);
			System.out.println("출력 종료");
			
			Object obj=oin.readObject();
			if(obj instanceof Person) {
				Person restore=(Person)obj;
				System.out.println("읽어드림: "+restore);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e2) {
			e2.printStackTrace();
		}

	}

}
