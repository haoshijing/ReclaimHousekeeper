package com.duyun.huishou.housekeeper.util;

import com.auth0.jwt.Algorithm;
import com.auth0.jwt.JWTSigner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class JWTSignerUtil {
    private static JWTSigner signer = new JWTSigner("4c743e444e2f53a87d1751");
    
    public static String shouldSignStringOrURI1() throws Exception {
        HashMap<String, Object> claims = new HashMap<String, Object>();
        claims.put("iss", "foo");
        return signer.sign(claims);
    }
    
    
    public static String shouldSignStringOrURI2() throws Exception {
        HashMap<String, Object> claims = new HashMap<String, Object>();
        claims.put("sub", "http://foo");
        return signer.sign(claims);
    }
    
    
    public static String shouldSignStringOrURI3() throws Exception {
        HashMap<String, Object> claims = new HashMap<String, Object>();
        claims.put("aud", "");
        return signer.sign(claims);
    }
    
    
    public static String shouldSignStringOrURICollection(String uri,String userId) throws Exception {
    	LinkedList<String> aud = new LinkedList<String>();
		aud.add(uri);
		aud.add(System.currentTimeMillis()+"");
		aud.add(userId);
        HashMap<String, Object> claims = new HashMap<String, Object>();
        claims.put("aud", aud);
        return signer.sign(claims);
    }
    
    public static String shouldSignIntDate1() throws Exception {
        HashMap<String, Object> claims = new HashMap<String, Object>();
        claims.put("exp", 123);
        return signer.sign(claims);
    }

    
    public static String shouldSignIntDate2() throws Exception {
        HashMap<String, Object> claims = new HashMap<String, Object>();
        claims.put("nbf", 0);
        return signer.sign(claims);
    }
    
    
    public static String shouldSignIntDate3() throws Exception {
        HashMap<String, Object> claims = new HashMap<String, Object>();
        claims.put("iat", Long.MAX_VALUE);
        return signer.sign(claims);
    }
    
    
    public static String shouldSignString() throws Exception {
        HashMap<String, Object> claims = new HashMap<String, Object>();
        claims.put("jti", "foo");
        return signer.sign(claims);
    }
    
    
    public static String shouldSignNullEqualsMissing() throws Exception {
        HashMap<String, Object> claims = new HashMap<String, Object>();
        for (String claimName : Arrays.asList("iss", "sub", "aud", "exp", "nbf", "iat", "jti")) {
            claims.put(claimName, null);
        }
        return signer.sign(claims);
    }
    
    public static String shouldFailExpectStringOrURI1() throws Exception {
        HashMap<String, Object> claims = new HashMap<String, Object>();
        claims.put("iss", 0);
        return signer.sign(claims);
    }
    
    public static String shouldFailExpectStringOrURI2() throws Exception {
        HashMap<String, Object> claims = new HashMap<String, Object>();
        claims.put("sub", ":");
        return signer.sign(claims);
    }
    
    public static String shouldFailExpectStringOrURICollection1() throws Exception {
        HashMap<String, Object> claims = new HashMap<String, Object>();
        claims.put("aud", 0);
        return signer.sign(claims);
    }
    
    public static String shouldFailExpectStringOrURICollection2() throws Exception {
        HashMap<String, Object> claims = new HashMap<String, Object>();
        claims.put("aud", Arrays.asList(0));
        return signer.sign(claims);
    }
    
    public static String shouldFailExpectStringOrURICollection3() throws Exception {
        HashMap<String, Object> claims = new HashMap<String, Object>();
        claims.put("aud", Arrays.asList(":"));
        return signer.sign(claims);
    }
    
    public static String shouldFailExpectIntDate1() throws Exception {
        HashMap<String, Object> claims = new HashMap<String, Object>();
        claims.put("exp", -1);
        return signer.sign(claims);
    }
    
    public static String shouldFailExpectIntDate2() throws Exception {
        HashMap<String, Object> claims = new HashMap<String, Object>();
        claims.put("nbf", "100");
        return signer.sign(claims);
    }
    
    public static String shouldFailExpectString() throws Exception {
        HashMap<String, Object> claims = new HashMap<String, Object>();
        claims.put("jti", 100);
        return signer.sign(claims);
    }
    
    
    public static String shouldOptionsNone() throws Exception {
        HashMap<String, Object> claims = new HashMap<String, Object>();
        return signer.sign(claims, new JWTSigner.Options());
    }
    
    
    public static String shouldOptionsAll() throws Exception {
        HashMap<String, Object> claims = new HashMap<String, Object>();
        return signer.sign(claims, new JWTSigner.Options()
                .setExpirySeconds(1000).setNotValidBeforeLeeway(5)
                .setIssuedAt(true).setJwtId(true));
    }

    
    public static String shouldOptionsAlgorithm() throws Exception {
        HashMap<String, Object> claims = new HashMap<String, Object>();
        return signer.sign(claims,
                new JWTSigner.Options().setAlgorithm(Algorithm.HS512));
    }
    public static void main(String[] args) throws Exception {
        System.out.println(JWTSignerUtil.shouldSignStringOrURICollection(
                "/user/login","3"));
    }
}