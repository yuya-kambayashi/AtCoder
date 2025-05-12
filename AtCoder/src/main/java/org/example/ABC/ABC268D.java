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
public class ABC268D {

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

    // https://atcoder.jp/contests/abc268/submissions/39730428

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int m = sc.nextInt();
        String[] ss = new String[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            ss[i] = sc.next();
            len += ss[i].length();
        }
        String[] tt = new String[m];
        for (int i = 0; i < m; i++) {
            tt[i] = sc.next();
        }
        Arrays.sort(ss);
        Arrays.sort(tt);

        boolean first = true;
        while (first || next_permutation(ss)) {
            first = false;
            generate(0, 16 - len + 1 - n, "", ss, tt);
        }

        System.out.println(-1);
    }

    static boolean next_permutation(String[] pp) {
        for (int a = pp.length - 2; a >= 0; a--) {
            if (pp[a].compareTo(pp[a + 1]) < 0) {
                for (int b = pp.length - 1; ; b--) {
                    if (pp[b].compareTo(pp[a]) > 0) {
                        String t = pp[a];
                        pp[a] = pp[b];
                        pp[b] = t;
                        for (++a, b = pp.length - 1; a < b; ++a, --b) {
                            t = pp[a];
                            pp[a] = pp[b];
                            pp[b] = t;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static void generate(int cur, int len, String res, String[] ss, String[] tt) {
        if (len < 0) {
            return;
        }
        if (cur == ss.length) {
            if (res.length() >= 3 && Arrays.binarySearch(tt, res) < 0) {
                System.out.println(res);
                System.exit(0);
            }
            return;
        }

        if (res.length() > 0 && res.charAt(res.length() - 1) != '_') {
            generate(cur, len, res.concat("_"), ss, tt);
        } else {
            generate(cur + 1, len, res.concat(ss[cur]), ss, tt);
            if (res.length() > 0) {
                generate(cur, len - 1, res.concat("_"), ss, tt);
            }
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       1 1
                chokudai
                chokudai
                """;

        String expected = """
                -1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC268D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       2 2
                choku
                dai
                chokudai
                choku_dai
                """;

        String expected = """
                dai_choku
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC268D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       2 2
                chokudai
                atcoder
                chokudai_atcoder
                atcoder_chokudai
                """;

        String expected = """
                -1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC268D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                                       4 4
                ab
                cd
                ef
                gh
                hoge
                fuga
                ____
                _ab_cd_ef_gh_
                """;

        String expected = """
                ab__ef___cd_gh
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC268D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
