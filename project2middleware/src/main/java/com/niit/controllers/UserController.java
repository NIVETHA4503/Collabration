package com.niit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.UserDao;
import com.niit.models.ErrrorClazz;
import com.niit.models.User;

@RestController
public class UserController {
@Autowired
private UserDao userDao;


@RequestMapping(value="/registration",method=RequestMethod.POST)
public ResponseEntity<?> userRegistration(@RequestBody User user){
	
	if(!userDao.isEmailUnique(user.getEmail())) {
		ErrrorClazz errorClazz=new ErrrorClazz(2,"Email already exists..Please choose different email Id");	
	return new ResponseEntity<ErrrorClazz>(errorClazz,HttpStatus.INTERNAL_SERVER_ERROR);
}
	if(user.getRole()=="" || user.getRole()==null) {
		ErrrorClazz errorClazz=new ErrrorClazz(4,"Role cannot be null..");	
		return new ResponseEntity<ErrrorClazz>(errorClazz,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	try {
		userDao.userRegistration(user);
	}
	catch(Exception e){
		ErrrorClazz errorClazz=new ErrrorClazz(2,"Unable to register user details");	
		return new ResponseEntity<ErrrorClazz>(errorClazz,HttpStatus.INTERNAL_SERVER_ERROR);
}
	return new ResponseEntity<Void>(HttpStatus.OK);
	
}

}
