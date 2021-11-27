package com.etiya.RentACarSpring.RentACar.dataAccess.forUser;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.RentACarSpring.RentACar.entities.forUser.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User getByEmail(String email);
}
