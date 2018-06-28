package com.duyun.huishou.housekeeper.util;

public class JWTIssuerException extends JWTVerifyException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7878739875352619708L;
	private final String issuer;

    public JWTIssuerException(String issuer) {
        this.issuer = issuer;
    }

    public JWTIssuerException(String message, String issuer) {
        super(message);
        this.issuer = issuer;
    }

    public String getIssuer() {
        return issuer;
    }
}