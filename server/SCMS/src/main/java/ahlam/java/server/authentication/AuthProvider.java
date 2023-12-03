package ahlam.java.server.authentication;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import ahlam.java.server.user.User;
import ahlam.java.server.user.UserRepository;

@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userRepository.findByUsername(username);
    	System.out.println("This is before checking if it matches or not (we r in AuthProvider)" + password);
        
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
        	System.out.println("sucessful");
            return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
        } else {
        	System.out.println("after invalid (in AuthProvider.java) and password is: "+ password);
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}