package com.ssafy.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;


public class LastWordGame {
	
	ArrayList<String> wordList;
	File file=new File("c:/Temp/problem.dat");
	Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		LastWordGame lwg=new LastWordGame();
		lwg.init();
		lwg.makeQuestion();
		lwg.close();

		
	}// end main
	
	//store: wordList를 problem.dat에 저장한다. 이때 scanner도 종료시켜주자. 
	
	public void close() {
		try (ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file))){
			oout.writeObject(wordList);
			System.out.println("저장완료");
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void makeQuestion() {
		System.out.println("마지막 문자로 시작하는 단어는?");
		System.out.println(wordList);
		String word=scanner.nextLine();
		wordList.add(word);
		System.out.println(wordList);
	}

	//init: problem.dat에서 객체를 읽어와 wordList를 생성한다.
	//단 이 과정에서 파일이 없다면 새로 생성한다.
	public void init() {
		try (ObjectInputStream oin=new ObjectInputStream(new FileInputStream(file))){
			Object stored=oin.readObject();
			if(stored!=null && stored instanceof ArrayList) {
				wordList = (ArrayList)stored;
				System.out.println("복구 성공");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("파일없음");
			wordList=new ArrayList<>();
		} catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
} //end class
