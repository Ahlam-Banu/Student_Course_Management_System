package ahlam.java.server.authentication;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import ahlam.java.server.jwt.TokenService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final TokenService tokenService;

    public CustomAuthSuccessHandler(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // Generate and include the token in the response
        String username = authentication.getName();
        String token = tokenService.generateToken(username);
        response.setHeader("Authorization", "Bearer " + token);
        clearAuthenticationAttributes(request);
    }
}