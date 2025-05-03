package org.example;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC404D {

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
//import java.util.stream.*;
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int m = sc.nextInt();
        long[] cc = new long[n];
        for (int i = 0; i < n; i++) {
            cc[i] = sc.nextLong();
        }
        List<List<Integer>> aaa = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int k = sc.nextInt();
            var aa = new ArrayList<Integer>();
            for (int j = 0; j < k; j++) {
                aa.add(sc.nextInt());
            }
            aaa.add(aa);
        }

        int total = (int) Math.pow(3, n);
        List<String> sss = new ArrayList<>();

        for (int i = 0; i < total; i++) {
            String ternary = Integer.toString(i, 3); // 3進数に変換

            // 先頭を0で埋めてn桁に調整
            while (ternary.length() < n) {
                ternary = "0" + ternary;
            }
            sss.add(ternary);
        }

        long ans = Long.MAX_VALUE;

        for (var s : sss) {

            int[] visit = new int[m];
            long money = 0;

            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == '0') {
                    continue;
                } else if (c == '1') {

                    for (int j = 0; j < m; j++) {
                        if (aaa.get(j).contains(i + 1)) {
                            visit[j]++;
                        }
                    }
                    money += cc[i];
                } else if (c == '2') {
                    for (int j = 0; j < m; j++) {
                        if (aaa.get(j).contains(i + 1)) {
                            visit[j] += 2;
                        }
                    }
                    money += cc[i] * 2;
                }
            }
            boolean allVisited = true;
            for (int i = 0; i < m; i++) {
                if (visit[i] < 2) {
                    allVisited = false;
                    break;
                }
            }
            if (allVisited) {
                ans = Math.min(ans, money);
            }
        }

        System.out.println(ans);
    }
//}

    @Test
    public void Case1() {

        String input = """
                4 3
                1000 300 700 200
                3 1 3 4
                3 1 2 4
                2 1 3
                
                """;

        String expected = """
                1800
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC404D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                7 6
                500 500 500 500 500 500 1000
                3 1 2 7
                3 2 3 7
                3 3 4 7
                3 4 5 7
                3 5 6 7
                3 6 1 7
                
                """;

        String expected = """
                2000
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC404D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC404D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                3 1
                1 0
                2 1 2
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC404D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
