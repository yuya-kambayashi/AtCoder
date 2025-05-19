package org.example.tessokubook;

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
public class A24 {

    private final StandardInputSnatcher in = new StandardInputSnatcher();
    private final StandardOutputSnatcher out = new StandardOutputSnatcher();

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
//public class Main {

    // https://atcoder.jp/contests/tessoku-book/submissions/56688390

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        int[] aa = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            aa[i] = sc.nextInt();
        }
        List<Integer> tt = new ArrayList<>();
        tt.add(aa[1]);
        for (int i = 2; i <= n; i++) {
            int idx = Collections.binarySearch(tt, aa[i]);
            if (idx >= 0) {
                tt.set(idx, aa[i]);
            } else {
                int insert = -(idx + 1);
                if (insert >= tt.size()) {
                    tt.add(aa[i]);
                } else {
                    tt.set(insert, aa[i]);
                }
            }
        }
        System.out.println(tt.size());
    }
//}

    @Test
    public void Case1() {

        String input = """
                6
                2 3 1 6 4 5
                
                """;

        String expected = """
                4
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A24.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                10
                1 1 1 1 1 1 1 1 1 1
                
                """;

        String expected = """
                1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A24.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A24.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A24.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
