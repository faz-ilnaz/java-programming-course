package ru.kpfu.itis.servlets.model;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Student {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String salt;


    public String getSalt() {

        return salt;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        SecureRandom random = new SecureRandom();
        this.salt = new BigInteger(50, random).toString(32);
        this.password = md5(password  + this.salt);
    }

    public static boolean check(String hashedPass, String pass, String salt) {
        return hashedPass.equals(md5(pass + salt));

    }

    private static String md5(String str) {
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
}
