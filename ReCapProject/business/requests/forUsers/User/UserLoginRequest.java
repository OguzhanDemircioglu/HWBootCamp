package com.etiya.RentACarSpring.RentACar.business.requests.forUsers.User;

import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserLoginRequest {
	
	@Email
	private String email;
	
	private String password;
}
