package com.arjun.jwt;

import io.jsonwebtoken.Claims;

import java.awt.desktop.OpenURIEvent;

public class UtilTest {



    public static void main(String[] args) {

        JwtUtil util = new JwtUtil();
        String token = util.generateToken("AA885", "ARJUN", "NITTEST");
        System.out.println("Generated JWT_TOKEN -> "+token);

        Claims claims = util.getClaims("NITTEST", token);
        System.out.println("claimId  "+claims.getId());
        System.out.println("subject "+claims.getSubject());
        System.out.println("expiration "+claims.getExpiration());
    }





}
