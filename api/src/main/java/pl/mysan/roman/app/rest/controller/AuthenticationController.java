package pl.mysan.roman.app.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import pl.mysan.roman.app.core.dto.UserDTO;
import pl.mysan.roman.app.core.security.JwtAuthenticationRequest;
import pl.mysan.roman.app.core.security.JwtAuthenticationResponse;
import pl.mysan.roman.app.core.security.JwtTokenUtil;
import pl.mysan.roman.app.core.security.JwtUser;
import pl.mysan.roman.app.core.services.ApplicationService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthenticationController {

    @Value("Authorization")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/auth")
    public ResponseEntity createAuthenticationToken(@RequestBody JwtAuthenticationRequest jwtAuthenticationRequest) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        jwtAuthenticationRequest.getUsername(),
                        jwtAuthenticationRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // generate token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtAuthenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @GetMapping("/refresh")
    public ResponseEntity refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

        if(jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/save")
    public ResponseEntity saveUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(applicationService.saveUser(userDTO));
    }
}
