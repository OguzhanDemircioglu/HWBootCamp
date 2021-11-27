package com.etiya.RentACarSpring.RentACar.ws;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.RentACarSpring.RentACar.business.abstracts.UserService;
import com.etiya.RentACarSpring.RentACar.business.requests.forUsers.User.UserLoginRequest;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.Result;

@RestController
@RequestMapping("api/users")
public class UsersController {
private UserService userService;

public UsersController(UserService userService) {
	super();
	this.userService = userService;
}

@PostMapping("login")
public Result login(@RequestBody @Valid UserLoginRequest userLoginRequest ) {
	return this.userService.login(userLoginRequest);
}
}
