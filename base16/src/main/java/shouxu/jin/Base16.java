package shouxu.jin;

import java.nio.charset.Charset;

public class Base16 {
    private static Charset UTF8 = Charset.forName("UTF-8");

    public static String encode(byte[] bytes) {
        if (null == bytes || bytes.length == 0 || bytes.length % 2 != 0) {
            return "";
        }
        byte[] s = new byte[bytes.length / 2];
        for (int i = 0; i < bytes.length - 1; i += 2) {
            byte h = (byte) (bytes[i + 1] > 57 ? (bytes[i + 1] - 55) : (bytes[i + 1] - 48));
            byte l = (byte) (bytes[i] > 57 ? (bytes[i] - 55) : (bytes[i] - 48));

            s[i / 2] = (byte) ((byte) (h << 4) + l);
        }

        return new String(s, UTF8);
    }

    public static byte[] decode(String str) {
        if (null == str) {
            return new byte[0];
        }

        byte[] s = str.getBytes(UTF8);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length; i++) {
            sb.append(Integer.toHexString(s[i] & 0x0F));
            sb.append(Integer.toHexString((s[i] >> 4) & 0x0F));
        }

        return sb.toString().toUpperCase().getBytes();
    }
}
