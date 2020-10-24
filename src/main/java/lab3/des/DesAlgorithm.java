package lab3.des;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.function.Supplier;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public abstract class DesAlgorithm implements Supplier<String> {

    private static final String ENCRYPTION_MODE = "DES";

    private final Cipher encryptCipher;
    private final Cipher decryptCipher;
    private final String line;

    public DesAlgorithm(final String line, final String key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        final SecretKey secretKey = new SecretKeySpec(key.getBytes(), ENCRYPTION_MODE);
        this.line = line;
        this.encryptCipher = Cipher.getInstance(ENCRYPTION_MODE);
        this.encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);
        this.decryptCipher = Cipher.getInstance(ENCRYPTION_MODE);
        this.decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);
    }

    public String getLine() {
        return line;
    }

    public Cipher getEncryptCipher() {
        return encryptCipher;
    }

    public Cipher getDecryptCipher() {
        return decryptCipher;
    }
}
