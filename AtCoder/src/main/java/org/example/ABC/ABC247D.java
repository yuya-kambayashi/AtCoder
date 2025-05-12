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
public class ABC247D {

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

        final int q = sc.nextInt();

        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            if (t == 1) {
                long val = sc.nextLong();
                long cnt = sc.nextLong();

                if (list.isEmpty()) {

                    list.add(new Pair(val, cnt));
                } else {
                    var last = list.get(list.size() - 1);
                    if (last.val == val) {
                        list.get(list.size() - 1).cnt += cnt;
                    } else {
                        list.add(new Pair(val, cnt));
                    }
                }

            } else {
                long cnt = sc.nextLong();
                long sum = 0;
                int index = 0;
                while (cnt > 0) {
                    var p = list.get(index);
                    if (p.cnt <= cnt) {
                        sum += p.val * p.cnt;
                        list.remove(index);
                        index--;
                        cnt -= p.cnt;
                    } else {
                        sum += p.val * cnt;
                        list.get(index).cnt -= cnt;
                        cnt = 0;
                    }
                    index++;
                }

                System.out.println(sum);
            }
        }
    }

    static class Pair {

        long val, cnt;

        public Pair(long val, long cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       4
                1 2 3
                2 2
                1 3 4
                2 3
                """;

        String expected = """
                                          4
                8
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC247D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       2
                1 1000000000 1000000000
                2 1000000000
                """;

        String expected = """
                1000000000000000000
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC247D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       5
                1 1 1
                1 1 1
                1 1 1
                1 1 1
                1 1 1
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC247D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                   4
                   1 2 2
                   1 1 2
                   2 3
                   2 1
                """;

        String expected = """
                5
                1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC247D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
