package com.guo.uilts;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Md5Util {

    final static String SALT = "guoshangxu123";

    public static String md5(String password) {
        String result = null;
        // 盐值加密
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            md5.update((password + SALT).getBytes());
            byte[] digest = md5.digest();
            result = new BigInteger(1, digest).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(md5("123"));
//        double random = Math.random();
//        System.out.println(random)
        Random random = new Random();
        int i = random.nextInt(9000)+1000;
        System.out.println(i);

    }

}
