package lab8;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Dispatcher {

    private static final String SECRET_KEY_1 = "ssdkF$HUy2A#D%kd";
    private static final String SECRET_KEY_2 = "weJiSEvR5yAC5ftB";

    private final IvParameterSpec ivParameterSpec;
    private final SecretKeySpec secretKeySpec;
    private final Cipher cipher;

    public Dispatcher() throws NoSuchPaddingException, NoSuchAlgorithmException {
        ivParameterSpec = new IvParameterSpec(SECRET_KEY_1.getBytes(StandardCharsets.UTF_8));
        secretKeySpec = new SecretKeySpec(SECRET_KEY_2.getBytes(StandardCharsets.UTF_8), "AES");
        cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    public String encrypt(String toBeEncrypt) throws BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException, InvalidKeyException {
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] encrypted = cipher.doFinal(toBeEncrypt.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public String decrypt(String encrypted) throws InvalidAlgorithmParameterException, InvalidKeyException,
        BadPaddingException, IllegalBlockSizeException {
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encrypted));
        return new String(decryptedBytes);
    }

    public static void main(String[] args) throws Exception {
        String message = "HOMEBOY";
        System.out.println("Message to encrypt: HOMEBOY");
        String encrypt = new Dispatcher().encrypt(message);
        String decrypt = new Dispatcher().decrypt(encrypt);
        System.out.println("Encrypted message: " + encrypt);
        System.out.println("Decrypted message: " + decrypt);
    }
}
