package com.example.api_rest_RedSocial.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
        throws ServletException, IOException {

        //1. Buscamos el token en la cabecera de la peticion
        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt =null;

        //2. El estandar dice que los Tokens se envian poniendo la palabra "Bearer " delante
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7); // quitamos el bearer para quedarnos solo con el token
            username = jwtUtil.extraerUsername(jwt); // sacamos el nombre
        }
        //3. si encontramos un nombre en el token y el usuario aun no esta logueado en este momento
        if(username != null && SecurityContextHolder.getContext().getAuthentication()==null){

            //vamos a la db a por los datos de usuario
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            //validamos que el token siga siendo valido
            if(jwtUtil.validarToken(jwt, userDetails.getUsername())){

                //el token es valido, le decimos a Spring que lo deje pasar
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        //4. Independientemente de lo que pase dejamos que la peticion siga su camino
        chain.doFilter(request, response);
    }
}
