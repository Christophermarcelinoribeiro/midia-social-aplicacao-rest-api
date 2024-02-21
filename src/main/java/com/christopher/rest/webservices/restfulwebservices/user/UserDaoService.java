package com.christopher.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users= new ArrayList<>();
	
	static {
		users.add(new User(1,"naruto",LocalDate.now().minusYears(30)));
		users.add(new User(2,"boruto",LocalDate.now().minusYears(10)));
		users.add(new User(3,"kakashi",LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll(){
		return users;
	}


	public User findById(int id) {
		for(User u: users) {
			if(u.getId().equals(id)) {
				return u;
			}
		}
		return null;
	}
}
