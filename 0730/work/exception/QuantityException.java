package com.ssafy.work.exception;

public class QuantityException extends Exception {
	public QuantityException(int sell, int quantity) {
		super(String.format("판매 수량(%d)이 재고 수량(%d)보다 많아요", sell, quantity));
	}
}
