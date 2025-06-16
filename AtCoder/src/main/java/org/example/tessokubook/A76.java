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
public class A76 {

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
        int mod = 1000000007;
        final int n = sc.nextInt();
        final int w = sc.nextInt();
        final int l = sc.nextInt();
        final int r = sc.nextInt();
        int[] xx = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            xx[i] = sc.nextInt();
        }
        xx[n + 1] = w;

        int[] dp = new int[n + 2];
        int[] sum = new int[n + 2];
        dp[0] = 1;
        sum[0] = 1;
        for (int i = 1; i <= n + 1; i++) {
            int posl = Arrays.binarySearch(xx, xx[i] - r);
            int posr = Arrays.binarySearch(xx, xx[i] - l + 1);
            posl = posl >= 0 ? posl : ~posl;
            posr = posr >= 0 ? posr : ~posr;
            posr--;

            if (posr >= 0) {
                dp[i] += sum[posr];
            }
            if (posl >= 1) {
                dp[i] -= sum[posl - 1];
            }
            dp[i] = (dp[i] + mod) % mod;

            sum[i] = sum[i - 1] + dp[i];
            sum[i] %= mod;
        }

        System.out.println(dp[n + 1]);
    }
//}

    @Test
    public void Case1() {

        String input = """
                5 65 7 37
                5 15 30 50 55
                
                """;

        String expected = """
                7
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A76.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case2() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A76.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A76.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A76.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
