package eddie.xie.base16;

import java.util.stream.IntStream;

public class Base16 {

//    private static final String encodeTable = "ABCDEFGHIJKLMNOP";
    private static final String encodeTable = "0123456789ABCDEF";
    private static final byte[] decodeTable = createDecodeTable();

    private static byte[] createDecodeTable() {
        byte[] table = new byte[256];
        IntStream.range(0, encodeTable.length()).forEach(index -> {
            int c = encodeTable.charAt(index);
            table[c] = (byte) index;
        });
        return table;
    }

    public static String encoding(byte[] input) {
        StringBuilder sb = new StringBuilder(input.length*2);
        for (byte b : input) {
            int high = (b & 0b11110000) >> 4;
            int low = b & 0b00001111;
            sb.append(encodeTable.charAt(low)).append(encodeTable.charAt(high));
        }
        return sb.toString();
    }


    public static byte[] decoding(String input) {
        byte[] result = new byte[input.length() / 2];
        IntStream.range(0, input.length()/2).forEach(index -> {
            int low = input.charAt(index*2);
            int high = input.charAt(index*2+1);
            result[index] = (byte) ((decodeTable[high] << 4) | decodeTable[low]);
        });
        return result;
    }
}
