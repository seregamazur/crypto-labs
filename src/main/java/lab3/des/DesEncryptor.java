package lab3.des;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class DesEncryptor extends DesAlgorithm {

    public DesEncryptor(final String line, final String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        super(line, key);
    }

    @Override
    public String get() {
        byte[] unencryptedByteArray = getLine().getBytes(StandardCharsets.UTF_8);

        byte[] encryptedBytes = new byte[0];
        try {
            encryptedBytes = getEncryptCipher().doFinal(unencryptedByteArray);
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            System.out.close();
        }
        byte[] encodedBytes = Base64.getEncoder().encode(encryptedBytes);
        return new String(encodedBytes);
    }
}
