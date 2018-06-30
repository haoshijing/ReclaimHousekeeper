package com.duyun.huishou.housekeeper.util;

import java.util.List;
import java.util.Map;

public class JWTVerifierUtil {
	
	private final static String JWT_SECRET = "4c743e444e2f53a87d1751"; 
	
	public static List verify(String token){
		Map<String, Object> decodedPayload;
		try {
			decodedPayload = new JWTVerifier(JWT_SECRET).verify(token);
			List<String> list = (List<String>) decodedPayload.get("aud");
			return list;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void main(String[] args) {
//		List l = verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOlsiL3VzZXIvbG9naW4iLCIxNDYzNjIyOTczMTgzIiwiMzAxNTYxIl19.jxjCRLFoHhB54GAAAsbHqBIPLRUKUC2HEGizfT5bWFE");
//		List l = verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOlsiL3VzZXIvbG9naW4iLCIxNDk1MDE4NDkzNTA4IiwiMzA0MjQ2Il19.G3Pm1dXD1jDcobpess7zX2T4EBjvccz0MF-CWM7JjgM");
		List l = verify("eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJhdWQiOlsiL3VzZXIvbG9naW4iLCIxNTE3NDUzMDMzNTMxIiwiMTEiXX0.pS_kr5bdLhHC8pIUBEP1RK5-nS6IhC_XoTOidXFjajE");
		System.out.println(l.get(2));
	}
}