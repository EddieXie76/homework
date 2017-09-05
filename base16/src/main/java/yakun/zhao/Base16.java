package yakun.zhao;

public class Base16 {
    public static String encode(byte[] bs) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bs) {
            int s1 = (b & 0xF);
            int s2 = (b >> 4 & 0xF);
            sb.append(Integer.toHexString(s1)).append(Integer.toHexString(s2));
        }
        return sb.toString().toUpperCase();
    }

    public static String decode(String encode) {
        byte[] bs = new byte[encode.length() / 2];
        int tmp = 0;
        for (int i = 0; i < encode.length(); i += 2) {
            int x1 = Integer.valueOf(encode.charAt(i) + "", 16);
            int x2 = Integer.valueOf(encode.charAt(i + 1) + "", 16);
            byte x =(byte) ((x2 << 4) + x1);
            bs[tmp++] = x;
        }
        return new String(bs);
    }
}
