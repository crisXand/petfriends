package chr.springjpaxml.service;

import java.nio.CharBuffer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Component
public class AuthenticationService implements AuthenticationInterfaceService {
	@Autowired
	private PasswordEncoder passEnc;
	@Override
	public boolean authenticate(String pass) {
		// TODO Auto-generated method stub
		String encodedPassword = passEnc.encode(CharBuffer.wrap("123456"));
		if(passEnc.matches(CharBuffer.wrap(pass), encodedPassword)){
			return true;
		}
		return false;
	}

}
