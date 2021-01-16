package com.gi.builmanager.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

@Component
public class JwtManager {

    private static final long EXPIRATION_TIME_SECONDS = 60 * 60;

    @Value("${builmanager.jwt-signing-key}")
    private String signingKey;

    public String generateToken(CustomUserDetails usuario) {

        Map<String, Object> claims = new HashMap<>();
        setTokenClaimsConsumer(usuario).accept(claims);
        return Jwts.builder()
            .setClaims(claims)
            .setSubject(usuario.getUsername())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_SECONDS * 1000))
            .setIssuer(usuario.getUsername())
            .signWith(SignatureAlgorithm.HS512, signingKey)
            .compact();

    }

    public UserData parseUserDataFunction(String token) {
        Jws<Claims> jws = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token);
        Claims claims = jws.getBody();
        return parseUserDataFunction().apply(claims);
    }


    private Function<Map<String, Object>, UserData> parseUserDataFunction() {
        return map -> {
            UserData userData = new UserData();
            userData.setNombreUsuario((String) map.get("nombreUsuario"));
            userData.setRol((String) map.get("rol"));
            //userData.setPermisos((List<String>) map.get("nombreUsuario"));
            return userData;
        };
    }

    private static Consumer<Map<String, Object>> setTokenClaimsConsumer(CustomUserDetails usuario) {
        return claims -> {
            claims.put("nombreUsuario", usuario.getUsername());
            claims.put("rol", usuario.getRol().toUpperCase());
            //claims.put("permisos", usuario.getRol().getPermisos().stream().map(permiso -> permiso.getCodigo()).collect(Collectors.toList()));
        };
    }
}
