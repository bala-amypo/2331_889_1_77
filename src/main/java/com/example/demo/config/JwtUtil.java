package com.example.demo.config;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    private Key getSignKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    // Called from AuthController
    public String generateToken(User user) {
        // ✅ CHANGE THIS if your User uses a different field
        return generateToken(user.getEmail());
    }

    public String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)   // ✅ correct for jjwt 0.11.x
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignKey())
                .compact();
    }

    // Called from JwtAuthenticationFilter
    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSignKey()) // ✅ correct for jjwt 0.11.x
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractSubject(String token) {
        return getClaims(token).getSubject();
    }
}
