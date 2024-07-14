package com.arjun.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.util.Base64.*;

public class JwtTest {


    public static void main(String[] args) {
        String key = "NIT";

        // JWT Token Generation
        String token =
                Jwts.builder()
                        .setId("Arjun1222")
                        .setSubject("JWT Testing 12121")
                        .setIssuer("@ArjunDeveloper")
                        .setIssuedAt(new Date(System.currentTimeMillis()))
                        .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10)))
                        .signWith(SignatureAlgorithm.HS256, //signature Algorithm
                                Base64.getEncoder().encodeToString(key.getBytes()))   //secretKey
                        .compact(); //convert into string

        System.out.println("JWT_TOKEN " + token);


        // Reading Token/Parsing Token
        Claims c =
                Jwts.parser()
                        .setSigningKey(Base64.getEncoder().encodeToString(key.getBytes()))   //secret key
                        .parseClaimsJws(token)
                        .getBody();
        System.out.println(c.getSubject());
        System.out.println(c.getId());
        System.out.println(c.getIssuer());
    }

}
