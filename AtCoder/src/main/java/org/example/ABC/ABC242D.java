package org.example.ABC;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.template.StandardInputSnatcher;
import org.example.template.StandardOutputSnatcher;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC242D {

    final private StandardInputSnatcher in = new StandardInputSnatcher();
    final private StandardOutputSnatcher out = new StandardOutputSnatcher();

    @BeforeAll
    public void beforeAll() {
        System.setIn(in);
        System.setOut(out);
    }

    @AfterAll
    public void afterAll() {
        System.setIn(null);
        System.setOut(null);
    }
//import java.math.*;
//import java.util.*;
//import java.util.stream.*;
//public class Main {

    // https://atcoder.jp/contests/abc242/submissions/29897189

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int q = sc.nextInt();
        char[] cc = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            long t = sc.nextLong();
            long k = sc.nextLong() - 1;
            long diff = 0;
            while (k > 0 && t > 0) {
                int leftRight = k % 2 == 0 ? 1 : 2;
                diff += leftRight;
                k /= 2;
                t--;
            }
            diff += t;
            char c = cc[(int) k];
            char ans;
            if (c == 'B') {
                diff += 1;
            } else if (c == 'C') {
                diff += 2;
            }
            ans = (char) ('A' + (int) (diff % 3));
            sb.append(ans + "\n");
        }

        System.out.println(sb);
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       ABC
                4
                0 1
                1 1
                1 3
                1 6
                """;

        String expected = """
                                          A
                B
                C
                B
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC242D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       CBBAACCCCC
                5
                57530144230160008 659279164847814847
                29622990657296329 861239705300265164
                509705228051901259 994708708957785197
                176678501072691541 655134104344481648
                827291290937314275 407121144297426665
                """;

        String expected = """
                                          A
                A
                C
                A
                A
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC242D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC242D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC242D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
