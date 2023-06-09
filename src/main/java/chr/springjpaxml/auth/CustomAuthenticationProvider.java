package chr.springjpaxml.auth;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import chr.springjpaxml.entities.Rol;
import chr.springjpaxml.entities.User;
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
		
		if(authorizedUser(user,pass)) {
			List<GrantedAuthority> grantedAuth = new ArrayList<>();
			grantedAuth.add(() -> "AUTH_USER");
			HashSet<Rol> roles = new HashSet<Rol>();
			Rol rol = new Rol("ADMIN");
			roles.add(rol);
			User userObject = new User(user,pass,true, roles);
			Authentication auth = new UsernamePasswordAuthenticationToken(userObject,pass,grantedAuth);
			return auth;
		}else {
			throw new AuthenticationCredentialsNotFoundException("Invalid credentials");
		}
	}
	
	private boolean authorizedUser(String user, String pass) {
		 
		 if(authService.authenticate(user,pass))
             return true;
		 return false;
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
	
}
