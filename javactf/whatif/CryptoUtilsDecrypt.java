import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;

public class CryptoUtilsDecrypt {
    public static String getMD5(String var0) {
        try {
            MessageDigest var1 = MessageDigest.getInstance("MD5");
            var1.update(var0.getBytes(), 0, var0.length());
            return (new BigInteger(1, var1.digest())).toString(16);
        } catch (Exception var2) {
            System.err.println(var2);
            return "error";
        }
    }

    public static void main(String[] var0) {
        // Define AES key (same as before)
        String aesKey = "bGiuzNCS1Mpp6R9C";

        // Ensure correct path for encrypted file
        File encryptedFile = new File("flag.enc");
        File outputFile = new File("output.txt");

        try {
            // Attempt decryption
            CryptoUtils.decrypt(aesKey, encryptedFile, outputFile);
            System.out.println("Decryption successful! Check output.txt for the flag.");
        } catch (CryptoException var5) {
            System.out.println(var5.getMessage());
            var5.printStackTrace();
        }
    }
}
