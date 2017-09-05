package dylens.yang;

import common.Constants;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class Base16Test {
    @Test
    public void encoding() throws Exception {
//        Assert.assertEquals("455637476E5BB88EFA59", Base16.encode("Test测试".getBytes("utf-8")));
//        Assert.assertEquals("0010203040", Base16.encode(new byte[]{0, 1, 2, 3, 4}));
    }

    @Test
    public void decoding() throws Exception {
//        Assert.assertEquals("Test测试", Base16.decode("455637476E5BB88EFA59"));
    }

    @Test
    public void encodingBenchmark() throws Exception {
        long begin = System.currentTimeMillis();

        byte[] input = "Test测试".getBytes("utf-8");
        IntStream.range(0, Constants.BENCHMARK_TIMES).forEach(value -> {
            Base16.encode(input);
        });

        System.out.println("EncodingBenchmark=" + (System.currentTimeMillis() - begin));
    }

    @Test
    public void decodingBenchmark() throws Exception {
        long begin = System.currentTimeMillis();

        IntStream.range(0, Constants.BENCHMARK_TIMES).forEach(value -> Base16.decode("455637476E5BB88EFA59"));
        System.out.println("DecodingBenchmark=" + (System.currentTimeMillis() - begin));

    }
}