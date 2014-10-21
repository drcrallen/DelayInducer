/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.allennet.delayinducer;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * @author Charles Allen
 */
public class DelayInducer {

    public static void main(String[] inarr) {
        final Integer numTimes = 1;
        final Integer bitSize = 26;
        final Random rand = new Random();
        List<Integer> lengths = new ArrayList<>(bitSize);
        for (int i = bitSize; i > 0; --i) {
            lengths.add(1 << i);
        }
        for (Integer n : lengths) {
            final List<Integer> newList = new ArrayList<>(n);
            IntStream.range(0, n + 1).forEach((int i) -> {
                newList.add(i);
            });
            Instant start = Instant.now();
            for (int j = 0; j < numTimes; ++j) {
                for (int i = 0; i < newList.size(); ++i) {
                    int sizeLeft = newList.size() - i;
                    int shuffleWith = rand.nextInt(sizeLeft) + i;
                    Collections.swap(newList, i, shuffleWith);
                }
            }
            Duration d = Duration.between(start, Instant.now());
            System.out.println(String.format("%d|%d", n, d.toMillis()));
        }
    }
}
