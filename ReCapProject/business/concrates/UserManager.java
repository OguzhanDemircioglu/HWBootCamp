package com.etiya.RentACarSpring.RentACar.business.concrates;

import com.etiya.RentACarSpring.RentACar.business.abstracts.UserService;
import com.etiya.RentACarSpring.RentACar.business.requests.forUsers.User.UserLoginRequest;
import com.etiya.RentACarSpring.RentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.ErrorResult;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.Result;
import com.etiya.RentACarSpring.RentACar.core.utilities.result.SuccessResult;
import com.etiya.RentACarSpring.RentACar.dataAccess.forUser.UserDao;
import com.etiya.RentACarSpring.RentACar.entities.forUser.User;

public class UserManager implements UserService{

	private UserDao userDao;
	private ModelMapperService modelMapperService;
	
	public UserManager(UserDao userDao, ModelMapperService modelMapperService) {
		super();
		this.userDao = userDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result login(UserLoginRequest userLoginRequest) {

		User user= this.userDao.getByEmail(userLoginRequest.getEmail());
		if (user==null) {
			return new ErrorResult("Kullanıcı kayıtlı değil");
		}
		if (user.getEmail().equals(userLoginRequest.getEmail())&&
				user.getPassword().equals(userLoginRequest.getPassword())) {
			return new SuccessResult("Kullanıcı girişi yapıldı");
		}
		return new ErrorResult("Kullanıcı bilgileri hatalı");
	}
	
}
