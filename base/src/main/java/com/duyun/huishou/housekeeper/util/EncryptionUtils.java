package com.duyun.huishou.housekeeper.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by Administrator on 2016/11/6.
 */
public final class EncryptionUtils {
    private EncryptionUtils(){}

    private static final Random RANDOM = new SecureRandom();

    /**
     * 加盐生成密码
     * @param password
     * @param salt
     * @return
     */
    public static String encryptPasswordBySalt(String password,String salt){
        return DigestUtils.sha256Hex(password+salt);
    }

    public static String generateSalt(){
        byte [] salt = new byte[32];
        RANDOM.nextBytes(salt);
        return Base64.encodeBase64String(salt);
    }

    public static void main(String[] args) {
        System.out.println(generateSalt());
        System.out.println(encryptPasswordBySalt("111111","qGt6/zgN6Q8n7f+niZjMJyAb4hs0EyZtsTpEsyu7qBM="));


    }


}