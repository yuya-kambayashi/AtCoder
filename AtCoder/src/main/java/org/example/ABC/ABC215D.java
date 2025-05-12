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
public class ABC215D {

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
    // https://atcoder.jp/contests/abc215/submissions/51170309

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int m = sc.nextInt();
        Set<Integer> aa = new HashSet<>();
        boolean[] cop = new boolean[m + 1];
        Arrays.fill(cop, true);

        for (int i = 0; i < n; i++) {
            aa.add(sc.nextInt());
        }

        for (var a : aa) {
            List<Integer> ff = primeFactors(a);
            for (int f : ff) {
                if (f > m || !cop[f]) {
                    continue;
                }
                int temp = f;
                while (temp <= m) {
                    cop[temp] = false;
                    temp += f;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            if (cop[i]) {
                ans.add(i);
            }
        }
        System.out.println(ans.size());
        for (var a : ans) {
            System.out.println(a);
        }
    }

    static List<Integer> primeFactors(int n) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                ret.add(i);
                n /= i;
            }
        }
        if (n != 1) {
            ret.add(n);
        }
        return ret;
    }

    //}
    @Test
    public void Case1() {

        String input = """
                                       3 12
                6 1 5
                """;

        String expected = """
                                          3
                1
                7
                11
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC215D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //  @Test
    public void Case2() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC215D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                   IN3
                """;

        String expected = """
                OUT3
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC215D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                   IN4
                """;

        String expected = """
                OUT4
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC215D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
