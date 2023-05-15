package chr.springjpaxml.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import chr.springjpaxml.service.AuthenticationInterfaceService;
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	@Autowired
	private  AuthenticationInterfaceService authService;
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		String user = authentication.getName();
		String pass = authentication.getCredentials().toString();
		System.out.print(user+pass);
		if(authorizedUser(user,pass)) {
			List<GrantedAuthority> grantedAuth = new ArrayList<>();
			grantedAuth.add(() -> "AUTH_USER");
			Authentication auth = new UsernamePasswordAuthenticationToken(user,pass,grantedAuth);
			return auth;
		}else {
			throw new AuthenticationCredentialsNotFoundException("Invalid credentials");
		}
	}
	
	private boolean authorizedUser(String user, String pass) {
		 
		 if("chr".equals(user) && authService.authenticate(pass))
             return true;
		 return false;
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
	
}
