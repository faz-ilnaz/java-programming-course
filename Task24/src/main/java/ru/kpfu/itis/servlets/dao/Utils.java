package ru.kpfu.itis.servlets.dao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {

    // check password
    public static boolean check(String hashedPass, String pass, String salt) {
        return hashedPass.equals(md5(pass + salt));
    }

    // return MD5 HashSum
    public static String md5(String str) {
        MessageDigest md;
        StringBuffer  hexString = new StringBuffer();
        try {
            byte[] bytesOfMessage = str.getBytes("UTF-8");
            md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(bytesOfMessage);
            byte[] thedigest = md.digest(bytesOfMessage);

            for (int i = 0; i < thedigest.length; i++) {
                hexString.append(Integer.toHexString(0xFF & thedigest[i]));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hexString.toString();
    }

    // return generated random string
    public static String randString(int len) {
        final String ALPHA_NUMERIC_STRING = "abcdefghijkkmnopqustuvwxyz" +
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder builder = new StringBuilder();
        while (len-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
}
