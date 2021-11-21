package com.RentACar.RentACar.core.utilities.results;

public class Result {

	private boolean success;
	private String message;

	public Result(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public Result(boolean success) {
		super();
		this.success = success;
	}

	public boolean isSuccess() {
		return this.success;
	}

	public String getMessage() {
		return this.message;
	}

}
