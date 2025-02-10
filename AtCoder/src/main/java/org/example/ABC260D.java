package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import com.sun.source.tree.Tree;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC260D {

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

        final int n = sc.nextInt();
        final int k = sc.nextInt();
        int[] pp = new int[n];
        for (int i = 0; i < n; i++) {
            pp[i] = sc.nextInt();
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        TreeMap<Integer, Set<Integer>> ba = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int x = pp[i];

            Integer min = ba.ceilingKey(x);
            if (min == null) {
                Set<Integer> ll = new HashSet<>();
                ll.add(i);
                ba.put(x, ll);
            } else {
                var v = ba.get(min);
                v.add(i);
                ba.put(x, v);
                ba.remove(min);
            }

            if (ba.get(x).size() == k) {
                for (var l : ba.get(x)) {
                    ans[pp[l] - 1] = i + 1;
                }
                ba.remove(x);
            }
        }

        for (var c : ans) {

            System.out.println(c);
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       5 2
                3 5 2 1 4
                """;

        String expected = """
                                          4
                3
                3
                -1
                4
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC260D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       5 1
                1 2 3 4 5
                """;

        String expected = """
                                          1
                2
                3
                4
                5
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC260D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       15 3
                3 14 15 9 2 6 5 13 1 7 10 11 8 12 4
                """;

        String expected = """
                                          9
                9
                9
                15
                15
                6
                -1
                -1
                6
                -1
                -1
                -1
                -1
                6
                15
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC260D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC260D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
