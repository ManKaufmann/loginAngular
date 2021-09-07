package com.example.loginangular.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.crypto.spec.SecretKeySpec;

import java.security.Key;
import java.util.*;

@RestController
@RequestMapping("/api/v1/")
public class Login {
    //LoginTest
    @GetMapping("/login")
    public String testLogin(){
        System.out.println("Test Login wird angefragt");
        String keyString= "Hall";

        Calendar instance = Calendar.getInstance();
        Date issuedAt= instance.getTime();
        Date expirationDate = new Date(instance.getTimeInMillis() + (10 * 60 * 1000));
        Set<String> claims= new HashSet<>();
        claims.add("ADMIN");
        claims.add("USER");

        byte[] keyBytes = Base64.getDecoder().decode(keyString.getBytes());
        Key key = new SecretKeySpec(keyBytes,  SignatureAlgorithm.HS256.getJcaName());

        JwtBuilder jwtBuilder = Jwts.builder()
                .setIssuer("NETSTORSYS")
                .setSubject("UserName")
                .claim("pms", claims)
                .setIssuedAt(issuedAt)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, key);
        String jwtKey = jwtBuilder.compact();
        return jwtKey;

    }
}
