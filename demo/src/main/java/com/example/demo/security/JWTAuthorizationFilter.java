package com.example.demo.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.shared.Constants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

   @SuppressWarnings("deprecation")
private Claims setSigningKey(HttpServletRequest request) {
      String jwtToken = request.
            getHeader(Constants.HEADER_AUTHORIZACION_KEY).
            replace(Constants.TOKEN_BEARER_PREFIX, "");

      return Jwts.parserBuilder()
            .setSigningKey(Constants.SUPER_SECRET_KEY)
            .build()
            .parseClaimsJws(jwtToken)
            .getBody();
   }
   
   private void setAuthentication(Claims claims) {

    @SuppressWarnings("unchecked")
	List<String> authorities = (List<String>) claims.get("authorities");

      UsernamePasswordAuthenticationToken auth = 
            new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
            authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
      
      SecurityContextHolder.getContext().setAuthentication(auth);

   }

   private boolean isJWTValid(HttpServletRequest request, HttpServletResponse res) {
      String authenticationHeader = request.getHeader(Constants.HEADER_AUTHORIZACION_KEY);
      if (authenticationHeader == null || !authenticationHeader.startsWith(Constants.TOKEN_BEARER_PREFIX))
         return false;
      return true;
   }

   @Override
   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, java.io.IOException {
      try {
         if (isJWTValid(request, response)) {
            Claims claims = setSigningKey(request);
            if (claims.get("authorities") != null) {
               setAuthentication(claims);
            } else {
               SecurityContextHolder.clearContext();
            }
         } else {
            SecurityContextHolder.clearContext();
         }
         filterChain.doFilter(request, response);
      } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | java.io.IOException e) {
         response.setStatus(HttpServletResponse.SC_FORBIDDEN);
         response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
         return;
      }
   }

}