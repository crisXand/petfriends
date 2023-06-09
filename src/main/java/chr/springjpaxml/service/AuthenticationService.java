package chr.springjpaxml.service;

import java.nio.CharBuffer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import chr.springjpaxml.entities.User;
import chr.springjpaxml.repository.UserDao;
@Component
public class AuthenticationService implements AuthenticationInterfaceService {
	@Autowired
	private PasswordEncoder passEnc;
	
	@Autowired
	private UserDao userDao;
	@Override
	public boolean authenticate(String username, String pass) {
		// TODO Auto-generated method stub
		
		List<User> users = userDao.getByUsername(username);
		if(!users.isEmpty()) {
			System.out.print(users.get(0).getPassword());
			if(passEnc.matches(CharBuffer.wrap(pass), users.get(0).getPassword())){
				return true;
			}
		}
		
		return false;
	}

}
