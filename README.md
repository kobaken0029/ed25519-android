# ed25519-android


ed25519-android is [ed25519](https://github.com/luca3104/ed25519) wrapper for android.

## Usage

Gradle:  
In ```app/build.gradle```

```gradle
repositories {
    github("kobaken0029", "ed25519-android", "gh-pages", "repository")
}

dependencies {
    compile 'click.kobaken:ed25519-android:1.0.0'
}
```

## API
Generate keyPair.
```java
public static KeyPair createKeyPair();
```

Signature for message with keyPair.
```java
public static String sign(String message, KeyPair keyPair);
```

Verify message by signature and publicKey.
```java
public static boolean verify(String signature, String message, String publicKey);
```

KeyPair is this↓
```java
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
```

## Licence

[MIT](https://github.com/tcnksm/tool/blob/master/LICENCE)

## Author

[kobaken0029](https://github.com/kobaken0029)
