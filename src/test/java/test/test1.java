package test;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

public class test1 {


    public static void main(String[] args) {

        BloomFilter<String> bloomFilter = BloomFilter.create(
                Funnels.stringFunnel(Charset.defaultCharset()), 10000000, 0.1
        );

        for (int i = 0; i < 10000000; i++) {
            bloomFilter.put("aa" + i);
        }
        long millis = System.currentTimeMillis();

        boolean aa1 = bloomFilter.mightContain("aa6598587");
        System.out.print(aa1);
        System.out.print(System.currentTimeMillis() - millis);

        //     Assert.assertTrue(bloomFilter.mightContain("aa98587"));




    }




}
