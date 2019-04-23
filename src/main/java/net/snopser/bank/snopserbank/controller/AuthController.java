package net.snopser.bank.snopserbank.controller;

import net.snopser.bank.snopserbank.model.AuthenticationRequest;
import net.snopser.bank.snopserbank.repository.ClientRepository;
import net.snopser.bank.snopserbank.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

/**
 * @author Виктор Фалькенберг
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;

    private final ClientRepository users;

    @Autowired
    public AuthController(JwtTokenProvider jwtTokenProvider, ClientRepository users) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.users = users;
    }

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody AuthenticationRequest data) {
        try {
            String username = data.getUsername();
            String token = jwtTokenProvider.createToken(
                    username,
                    this.users.findByLogin(username)
                            .orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found"))
                            .getRoles()
            );
            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }
}
