package com.example.demo.config;

import com.example.demo.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
// cspell:ignore Jwts
public class JwtUtil {
    private final SecretKey signingKey;
    private final long validityInMs;

    public JwtUtil(JwtProperties jwtProperties) {
        if (jwtProperties == null || jwtProperties.getSecret() == null) {
            throw new IllegalArgumentException("JWT properties cannot be null");
        }
        this.signingKey = Keys.hmacShaKeyFor(jwtProperties.getSecret().getBytes());
        this.validityInMs = jwtProperties.getValidity();
    }

    public String generateToken(User user) {
        return Jwts.builder()
                .claim("userId", user.getId())
                .claim("email", user.getEmail())
                .claim("role", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validityInMs))
                .signWith(signingKey)
                .compact();
    }

    public Jwt<?, ?> validateAndParse(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(signingKey)
                .build()
                .parse(token);
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(signingKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}