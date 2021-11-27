package com.etiya.RentACarSpring.RentACar.core.utilities.Business;

import com.etiya.RentACarSpring.RentACar.core.utilities.result.Result;

public class BusinessRules {

	public static Result run(Result ...logics) {
		
			for(Result logic: logics) {
				if(!logic.isSuccess()) {
					return logic;
				}
			}
		return null;
		
	}
}
