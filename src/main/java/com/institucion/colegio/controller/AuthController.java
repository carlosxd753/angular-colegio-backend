package com.institucion.colegio.controller;

import com.institucion.colegio.dto.ApiError;
import com.institucion.colegio.dto.AuthResponse;
import com.institucion.colegio.dto.LoginDTO;
import com.institucion.colegio.service.CustomUserDetailsService;
import com.institucion.colegio.service.JwtService;
import com.institucion.colegio.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final CustomUserDetailsService customUserDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.correo(), dto.password())
            );
            UserDetails user = customUserDetailsService.loadUserByUsername(dto.correo());
            String token = jwtService.generarToken(user);
            return ResponseEntity.ok(new AuthResponse(token));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body(
                    new ApiError(401, "Credenciales incorrectas o token inválido")
            );
        }
    }
}
