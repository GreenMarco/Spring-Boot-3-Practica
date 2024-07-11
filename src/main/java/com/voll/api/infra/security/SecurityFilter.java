package com.voll.api.infra.security;

import com.voll.api.domain.usuarios.UsuariosRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Obtener el token
        System.out.println("Inicio de filtro");
        var authHeader = request.getHeader("Authorization");
        if(authHeader != null ){
            authHeader = authHeader.replace("Bearer ","");
            System.out.println("Token NO es nulo");
            System.out.println(authHeader);
            System.out.println(tokenService.getSubject(authHeader));
            var subject = tokenService.getSubject(authHeader);
            if (subject != null){
                //token válido
                var usuario = usuariosRepository.findByLogin(subject);
                var authentication = new UsernamePasswordAuthenticationToken(usuario, null,
                        usuario.getAuthorities());//forzamos un inicio de sesion
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request,response);
        //

    }
}
