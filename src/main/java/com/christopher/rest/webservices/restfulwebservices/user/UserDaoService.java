package com.christopher.rest.webservices.restfulwebservices.user;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;





@Component
public class UserDaoService {
	private static List<User> users= new ArrayList<>();
	private static int usersCount =0;
	static {
		users.add(new User(++usersCount,"naruto",LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount,"boruto",LocalDate.now().minusYears(10)));
		users.add(new User(++usersCount,"kakashi",LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll(){
		return users;
	}
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}


	public User findById(int id) throws Exception {
		for(User u: users) {
			if(u.getId().equals(id)) {
				return u;
			}
		}
		throw new UserNotFoundException("id" +id );
	}
/*	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().get();
	}
*/
	public void deleteById(int id) throws Exception {
		for(User u: users) {
			if(u.getId().equals(id)) {
				users.remove(u);
			}
		}
		throw new UserNotFoundException("id" +id );
	}
}
