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
public class ABC408D {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            String s = sc.next();

            // 0→z
            // 1→o

            List<Comp> comps = convert(s);

            int count1 = 0;
            for (int j = 0; j < comps.size(); j++) {
                if (comps.get(j).t.equals("o")) {
                    count1++;
                }
            }
            if (count1 <= 1) {
                ans.add(0);
                continue;
            }

            // 1を消す場合
            int cnt1 = 0;
            List<Integer> cnt1s = new ArrayList<>();

            for (int j = 0; j < comps.size(); j++) {
                if (comps.get(j).t.equals("o")) {
                    int c1 = comps.get(j).c;
                    cnt1s.add(c1);
                }
            }
            Collections.sort(cnt1s);
            for (int j = 0; j < cnt1s.size() - 1; j++) {
                cnt1 += cnt1s.get(j);
            }

            // 0を消す場合
            int cnt0 = 0;
            for (int j = 1; j < comps.size() - 1; j++) {
                if (comps.get(j).t.equals("z")) {
                    cnt0 += comps.get(j).c;
                }
            }

            ans.add(Math.min(cnt0, cnt1));
        }
        for (var a : ans) {

            System.out.println(a);
        }
    }

    static class Comp {
        String t;
        int c;

        Comp(String t, int c) {
            this.t = t;
            this.c = c;
        }
    }

    static List<Comp> convert(String s) {
        List<Comp> comps = new ArrayList<>();
        if (s.length() == 1) {
            comps.add(new Comp(cToAB(s.charAt(0)), 1));
            return comps;
        }

        char c = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            } else {
                comps.add(new Comp(cToAB(c), count));

                c = s.charAt(i);
                count = 1;
            }

            if (i == s.length() - 1) {
                comps.add(new Comp(cToAB(c), count));

            }
        }
        return comps;
    }

    static String cToAB(char c) {
        if (c == '0') {
            return "z";
        } else if (c == '1') {
            return "o";
        }
        return "";
    }
//}

    @Test
    public void Case1() {

        String input = """
                3
                5
                10011
                10
                1111111111
                7
                0000000
                
                """;

        String expected = """
                1
                0
                0
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC408D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                5
                2
                01
                10
                1000010011
                12
                111100010011
                3
                111
                8
                00010101
                
                """;

        String expected = """
                0
                2
                3
                0
                2
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC408D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                1
                32
                1111111111100000000001111111111
                """;

        String expected = """
                10
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC408D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC408D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
