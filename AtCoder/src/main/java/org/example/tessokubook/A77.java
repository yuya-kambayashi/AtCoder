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
public class A77 {

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
    static int n;
    static int l;
    static int k;
    static int[] aa;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        l = sc.nextInt();
        k = sc.nextInt();
        aa = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            aa[i] = sc.nextInt();
        }

        long left = 1;
        long right = 1000000000;
        while (left < right) {
            long mid = (left + right + 1) / 2;
            boolean ans = check(mid);
            if (ans) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }

    static boolean check(long x) {
        int count = 0;
        int lastCut = 0;
        for (int i = 1; i <= n; i++) {
            if (aa[i] - lastCut >= x && l - aa[i] >= x) {
                count++;
                lastCut = aa[i];
            }
        }
        return count >= k;
    }
//}

    //@Test
    public void Case1() {

        String input = """
                3 34
                1
                8 13 26
                
                """;

        String expected = """
                13
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A77.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case2() {

        String input = """
                7 45
                2
                7 11 16 20 28 34 38
                
                """;

        String expected = """
                12
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A77.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                3 100
                1
                28 54 81
                
                """;

        String expected = """
                46
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A77.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                3 100
                2
                28 54 81
                
                """;

        String expected = """
                26
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A77.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case5() {

        String input = """
                20 1000
                4
                51 69 102 127 233 295 350 388 417 466 469 523 553 587 720 739 801 855 926 954
                
                
                """;

        String expected = """
                170
                
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A77.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
