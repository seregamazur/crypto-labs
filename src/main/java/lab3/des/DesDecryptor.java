package lab3.des;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class DesDecryptor extends DesAlgorithm {

    public DesDecryptor(final String line, final String key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        super(line, key);
    }

    @Override
    public String get() {
        byte[] decodedBytes = Base64.getDecoder().decode(getLine().getBytes(StandardCharsets.UTF_8));
        byte[] unencryptedByteArray = new byte[0];
        try {
            unencryptedByteArray = getDecryptCipher().doFinal(decodedBytes);
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            System.out.close();
        }
        return new String(unencryptedByteArray, StandardCharsets.UTF_8);
    }
}
