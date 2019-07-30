package com.ssafy.io;

import java.io.Serializable;

public class Userinfo implements Serializable{
	String info="중요한 사람";

	@Override
	public String toString() {
		return  info;
	}

}
