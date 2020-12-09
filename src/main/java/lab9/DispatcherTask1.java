package lab9;

import java.nio.ByteBuffer;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.crypto.KeyAgreement;

import static javax.xml.bind.DatatypeConverter.parseHexBinary;
import static javax.xml.bind.DatatypeConverter.printHexBinary;

public class DispatcherTask1 {

    public static void main(String[] args) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        KeyPair kp = getKeyPair();
        byte[] ourPk = kp.getPublic().getEncoded();

        System.out.println("Public key = " + printHexBinary(ourPk));
        System.out.println("Please input your public key: ");

        byte[] otherPk = parseHexBinary(scanner.nextLine());

        KeyFactory kf = KeyFactory.getInstance("EC");
        X509EncodedKeySpec pkSpec = new X509EncodedKeySpec(otherPk);
        PublicKey otherPublicKey = kf.generatePublic(pkSpec);

        KeyAgreement ka = KeyAgreement.getInstance("ECDH");
        ka.init(kp.getPrivate());
        ka.doPhase(otherPublicKey, true);

        byte[] sharedSecret = ka.generateSecret();
        System.out.println("Shared secret key: " + printHexBinary(sharedSecret));

        MessageDigest hash = MessageDigest.getInstance("SHA-256");
        hash.update(sharedSecret);

        List<ByteBuffer> keys = Arrays.asList(ByteBuffer.wrap(ourPk), ByteBuffer.wrap(otherPk));
        Collections.sort(keys);

        hash.update(keys.get(0));
        hash.update(keys.get(1));

        byte[] derivedKey = hash.digest();
        System.out.println("Your key is: " + printHexBinary(derivedKey));
    }

    private static KeyPair getKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
        kpg.initialize(256);
        KeyPair kp = kpg.generateKeyPair();
        return kp;
    }
}
