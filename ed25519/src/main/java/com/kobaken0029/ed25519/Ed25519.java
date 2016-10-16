package com.kobaken0029.ed25519;

import java.util.ArrayList;
import java.util.List;


public class Ed25519 {
    public native static ArrayList<String> GenerateKeyPair();

    public native static String Signature(String message, String priKey, String pubKey);

    public native static boolean Verify(String signatureb64, String message, String pubKeyb64);

    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("ed25519");
    }

    public static KeyPair createKeyPair() {
        List<String> generatedKeyPair = GenerateKeyPair();
        return new KeyPair(generatedKeyPair.get(0), generatedKeyPair.get(1));
    }

    public static String sign(String message, KeyPair keyPair) {
        return Signature(message, keyPair.getPublicKey(), keyPair.getPrivateKey());
    }

    public static boolean verify(String signature, String message, String publicKey) {
        return Verify(signature, message, publicKey);
    }

    public static class KeyPair {
        private String publicKey;
        private String privateKey;

        public KeyPair(String publicKey, String privateKey) {
            this.publicKey = publicKey;
            this.privateKey = privateKey;
        }

        public String getPublicKey() {
            return publicKey;
        }

        public String getPrivateKey() {
            return privateKey;
        }
    }
}
