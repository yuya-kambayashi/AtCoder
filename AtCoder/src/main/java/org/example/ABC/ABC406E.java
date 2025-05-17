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
public class ABC406E {

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

    static final int MOD = 998244353;
    static long[][][] dp;
    static int[][][] sumDp;
    static String bin;
    static int K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            long N = sc.nextLong();
            K = sc.nextInt();

            bin = Long.toBinaryString(N);
            int len = bin.length();

            dp = new long[len + 1][K + 2][2]; // dp[pos][count_of_1s][tight]
            sumDp = new int[len + 1][K + 2][2]; // 合計用

            dp[0][0][1] = 1;

            for (int pos = 0; pos < len; pos++) {
                int bit = bin.charAt(pos) - '0';
                for (int cnt = 0; cnt <= K; cnt++) {
                    for (int tight = 0; tight <= 1; tight++) {
                        for (int d = 0; d <= 1; d++) {
                            if (cnt + d > K) continue;
                            if (tight == 1 && d > bit) continue;

                            int newTight = (tight == 1 && d == bit) ? 1 : 0;

                            dp[pos + 1][cnt + d][newTight] += dp[pos][cnt][tight];
                            dp[pos + 1][cnt + d][newTight] %= MOD;

                            sumDp[pos + 1][cnt + d][newTight] += (int) (((long) sumDp[pos][cnt][tight] * 2 + d * dp[pos][cnt][tight]) % MOD);
                            sumDp[pos + 1][cnt + d][newTight] %= MOD;
                        }
                    }
                }
            }

            int ans = (sumDp[len][K][0] + sumDp[len][K][1]) % MOD;
            System.out.println(ans);
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                2
                20 2
                1234567890 17
                
                """;

        String expected = """
                100
                382730918
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC406E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case2() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC406E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC406E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC406E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
