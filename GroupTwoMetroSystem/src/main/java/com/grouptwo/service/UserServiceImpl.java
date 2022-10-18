package com.grouptwo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.grouptwo.entity.User;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RestTemplate restTemplate;
	@Override
	public User loginUser(User user) {
		
//		return userDao.getUserByUserNameAndPassword(user.getUserName(), user.getPassword());
		return restTemplate.getForObject("http://localhost:8082/login/"+user.getUserId()+"/"+user.getPassword(), User.class);
	}

}
