package com.institucion.colegio.service;

import com.institucion.colegio.model.Usuario;
import com.institucion.colegio.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Usuario no encontrado con correo: " + correo));

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(
                "ROLE_" + usuario.getRol().getNombre().toUpperCase());

        return org.springframework.security.core.userdetails.User
                .withUsername(usuario.getCorreo())
                .password(usuario.getPassword())
                .authorities(authority)
                .build();
    }
}
