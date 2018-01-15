package com.crypto.portfolio.cryptoportfolio.apiclient;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class APISign {

    private static final String ENCRYPION = "HmacSHA512";
    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String sign(String secret, String url) {

        Mac shaHmac = null;

        try {
            shaHmac = Mac.getInstance(ENCRYPION);
        } catch (NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        }

        SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(), ENCRYPION);

        try {
            shaHmac.init(secretKey);
        } catch (InvalidKeyException ike) {
            ike.printStackTrace();
        }

        return bytesToHex(shaHmac.doFinal(url.getBytes()));
    }

    public static String generateNonce() {
        return new String(Long.toString(System.currentTimeMillis()));
    }

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
