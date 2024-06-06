package rs.ac.bg.fon.ai.naprednoProgramiranje.Authorization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.ai.naprednoProgramiranje.tokens.TokenService;

@RestController
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    private final TokenService tokenService;


    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    public String token(Authentication authentication){
        log.debug("Token requested for user: {}",authentication.getName());
        String token = tokenService.generateToken(authentication);
        return token;
    }

}
