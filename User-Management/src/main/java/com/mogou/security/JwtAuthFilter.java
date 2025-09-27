package com.mogou.security;

import com.mogou.model.User;
import com.mogou.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
//
//public class JwtAuthFilter extends OncePerRequestFilter {
//
//    private final JwtUtils jwtUtils;
//    private final UserRepository userRepository;
//
//    public JwtAuthFilter(JwtUtils jwtUtils, UserRepository userRepository){
//        this.jwtUtils = jwtUtils; this.userRepository = userRepository;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
//            throws ServletException, IOException {
//        String token = null;
//
//        // Lire depuis Authorization header
//        String header = req.getHeader("Authorization");
//        if(header != null && header.startsWith("Bearer ")){
//            token = header.substring(7);
//        }
//
//        // Lire depuis les cookies si pas dans header
//        if(token == null && req.getCookies() != null){
//            for(var cookie : req.getCookies()){
//                if("token".equals(cookie.getName())){
//                    token = cookie.getValue();
//                    break;
//                }
//            }
//        }
//
//        if(token != null){
//            try {
//                if(jwtUtils.validateJwtToken(token)){
//                    String email = jwtUtils.getEmailFromToken(token);
//                    User user = userRepository.findByEmail(email).orElse(null);
//                    if(user != null){
//                        List<GrantedAuthority> auth = List.of(() -> "ROLE_" + user.getRole().name());
//                        Authentication authentication = new UsernamePasswordAuthenticationToken(email, null, auth);
//                        SecurityContextHolder.getContext().setAuthentication(authentication);
//                    }
//                }
//            } catch (Exception e) {
//                // Token invalide, continuer sans authentification
//            }
//        }
//        chain.doFilter(req, res);
//    }
//}
