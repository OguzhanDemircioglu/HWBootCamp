package com.RentACar.RentACar.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T> {

	public SuccessDataResult(T data, String message) {
		super(true, message, data);
	}
	public SuccessDataResult(T data) {
		super(true, data);
	}
	
}
