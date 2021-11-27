package com.etiya.RentACarSpring.RentACar.core.utilities.services.findex;

public class FindexManager implements FindexService{

	@Override
	public int findexScore() {
			return (int)(Math.random()*1900)	;
	}

}
