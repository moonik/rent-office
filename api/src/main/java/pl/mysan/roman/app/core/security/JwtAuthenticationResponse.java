package pl.mysan.roman.app.core.security;

import pl.mysan.roman.app.core.dto.UserDTO;

public class JwtAuthenticationResponse {

    private final String token;
    private final UserDTO userDTO;

    public JwtAuthenticationResponse(String token, UserDTO userDTO) {
        this.token = token;
        this.userDTO = userDTO;
    }

    public String getToken() {
        return token;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }
}
