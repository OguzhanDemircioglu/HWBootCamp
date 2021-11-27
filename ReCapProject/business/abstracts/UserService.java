package com.etiya.RentACarSpring.RentACar.business.abstracts;

import com.etiya.RentACarSpring.RentACar.business.requests.forUsers.User.UserLoginRequest;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.Result;

public interface UserService {

	Result login(UserLoginRequest userLoginRequest);
	
}
