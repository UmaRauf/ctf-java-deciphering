import java.io.PrintStream;
import java.util.Base64;

public class FlagGen {
    public static void main(String[] var0) {
        // Get the first and last part of the flag
        String firstPart = generateFirstPart();  // "0e7fd6"
        String lastPart = generateLastPart();    // "9c18d5"

        // XOR the first part with the hint value "64005f"
        String xorFirst = xorHex(firstPart, "64005f");

        // XOR the last part with the hint value "9ad164"
        String xorLast = xorHex(lastPart, "9ad164");

        // Combine the parts into the full flag
        String flag = "flag{" + xorFirst + xorLast + "}";

        // Convert the flag to lowercase before printing
        System.out.println(flag.toLowerCase());
    }

    public static String generateFirstPart() {
        return "0e7fd6";
    }

    public static String generateLastPart() {
        return "9c18d5";
    }

    public static String xorHex(String var0, String var1) {
        char[] var2 = new char[var0.length()];

        for(int var3 = 0; var3 < var2.length; ++var3) {
            var2[var3] = toHex(fromHex(var0.charAt(var3)) ^ fromHex(var1.charAt(var3)));
        }

        return new String(var2);
    }

    private static int fromHex(char var0) {
        if (var0 >= '0' && var0 <= '9') {
            return var0 - 48;
        } else if (var0 >= 'A' && var0 <= 'F') {
            return var0 - 65 + 10;
        } else if (var0 >= 'a' && var0 <= 'f') {
            return var0 - 97 + 10;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static char toHex(int var0) {
        if (var0 >= 0 && var0 <= 15) {
            return "0123456789ABCDEF".charAt(var0);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
