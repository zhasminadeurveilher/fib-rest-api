package com.fib.fibrestapi.security;

import com.fib.fibrestapi.exception.FibException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${app.jwt-secret}")
    private String jwtSecret;
    @Value("${app-jwt-expiration-milliseconds}")
    private Long jwtExpirationDate;

    public String generateToken(Authentication authentication){
        String username = authentication.getName();

        Date currentDate = new Date();

        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(key())
                .compact();

        return token;
    }

    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String getUsername(String token){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody();

        String username = claims.getSubject();

        return username;
    }

    public boolean validateToken(String token){

        try{
            Jwts.parserBuilder()
                    .setSigningKey(key())
                    .build()
                    .parse(token);

            return true;
        } catch (ExpiredJwtException e) {
            throw new FibException(HttpStatus.BAD_REQUEST, "Expired JWT.");
        } catch (MalformedJwtException e) {
            throw new FibException(HttpStatus.BAD_REQUEST, "Invalid JWT.");
        } catch (SignatureException e) {
            throw new FibException(HttpStatus.BAD_REQUEST, "Error signing JWT.");
        } catch (IllegalArgumentException e) {
            throw new FibException(HttpStatus.BAD_REQUEST, "JWT claims string is empty.");
        }

    }
}
