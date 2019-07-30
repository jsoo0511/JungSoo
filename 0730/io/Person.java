package com.ssafy.io;

import java.io.Serializable;

public class Person implements Serializable{
	String name;

	private static final long serialVersoinUID=1;
	
	Userinfo info = new Userinfo();
	
	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", info=" + info + "]";
	}
	


}
