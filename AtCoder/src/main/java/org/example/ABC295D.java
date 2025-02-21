package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC295D {

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

    // https://atcoder.jp/contests/abc295/submissions/41783546

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final String s = sc.next();

        Map<String, Long> count = new HashMap<>();
        int[] flg = new int[10];
        count.put(toString(flg), 1l);

        for (int i = 0; i < s.length(); i++) {
            int sub = Integer.valueOf(s.substring(i, i + 1));
            flg[sub] = (flg[sub] + 1) % 2;
            String key = toString(flg);
            if (count.containsKey(key)) {
                count.replace(key, count.get(key) + 1);
            } else {
                count.put(key, 1l);
            }
        }

        long ret = 0;
        for (var v : count.values()) {
            ret += (v * (v - 1)) / 2;
        }
        System.out.println(ret);

    }

    static String toString(int[] list) {
        StringBuilder sb = new StringBuilder();
        for (var n : list) {
            sb.append(n);
        }
        return sb.toString();
    }
//}

    @Test
    public void Case1() {

        String input = """
                   20230322
                """;

        String expected = """
                4
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC295D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                   0112223333444445555556666666777777778888888889999999999
                """;

        String expected = """
                185
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC295D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                   3141592653589793238462643383279502884197169399375105820974944
                """;

        String expected = """
                9
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC295D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC295D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
