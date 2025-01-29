package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC236D {

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

    // c++サンプルコードの変換

    static int n;
    static int[][] aaa;
    static List<int[]> vec;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        aaa = new int[20][20];
        vec = new ArrayList<>();
        used = new boolean[20];

        for (int i = 1; i <= 2 * n - 1; i++) {
            for (int j = i + 1; j <= 2 * n; j++) {
                aaa[i][j] = sc.nextInt();
            }
        }

        System.out.println(calc());
    }

    static int calc() {
        if (vec.size() == n) {
            int ret = 0;
            for (int[] pp : vec) {
                ret ^= aaa[pp[0]][pp[1]];
            }
            return ret;
        }

        int l = -1;
        for (int i = 1; i <= 2 * n; i++) {
            if (!used[i]) {
                l = i;
                break;
            }
        }
        used[l] = true;

        int ret = 0;
        for (int i = 1; i <= 2 * n; i++) {
            if (!used[i]) {
                vec.add(new int[]{l, i});
                used[i] = true;
                ret = Math.max(ret, calc());
                vec.remove(vec.size() - 1);
                used[i] = false;
            }
        }
        used[l] = false;
        return ret;
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       2
                4 0 1
                5 3
                2
                """;

        String expected = """
                6
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC236D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       1
                5
                """;

        String expected = """
                5
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC236D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       5
                900606388 317329110 665451442 1045743214 260775845 726039763 57365372 741277060 944347467
                369646735 642395945 599952146 86221147 523579390 591944369 911198494 695097136
                138172503 571268336 111747377 595746631 934427285 840101927 757856472
                655483844 580613112 445614713 607825444 252585196 725229185
                827291247 105489451 58628521 1032791417 152042357
                919691140 703307785 100772330 370415195
                666350287 691977663 987658020
                1039679956 218233643
                70938785
                """;

        String expected = """
                1073289207
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC236D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC236D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
