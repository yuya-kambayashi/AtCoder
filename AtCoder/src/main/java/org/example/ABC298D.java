package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC298D {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int mod = 998244353;

        Queue<Integer> que = new LinkedList<>();
        que.add(1);

        final int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            if (t == 1) {
                int x = sc.nextInt();
                que.add(x);
            } else if (t == 2) {
                que.poll();
            } else if (t == 3) {
                StringBuilder sb = new StringBuilder();
                for (var p : que) {
                    sb.append(p);
                    if (sb.length() > 9) {
                        break;
                    }
                }
                Long l = Long.parseLong(sb.toString());
                System.out.println(l % mod);
            }
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       3
                3
                1 2
                3
                """;

        String expected = """
                                          1
                12
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC298D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       3
                1 5
                2
                3
                """;

        String expected = """
                5
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC298D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                                       11
                1 9
                1 9
                1 8
                1 2
                1 4
                1 4
                1 3
                1 5
                1 3
                2
                3
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC298D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC298D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
