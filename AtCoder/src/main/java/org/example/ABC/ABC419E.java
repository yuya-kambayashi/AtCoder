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
public class ABC419E {

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
        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = sc.nextInt();

        // 累積和
        int[] S = new int[N + 1];
        for (int i = 0; i < N; i++) {
            S[i + 1] = (S[i] + A[i]) % M;
        }

        int ans = 0;

        // 各グループごとに処理
        for (int start = 0; start < L; start++) {
            Map<Integer, Integer> freq = new HashMap<>();
            int cnt = 0;
            for (int j = start; j <= N; j += L) {
                freq.put(S[j], freq.getOrDefault(S[j], 0) + 1);
                cnt++;
            }
            int maxFreq = 0;
            for (int f : freq.values()) {
                maxFreq = Math.max(maxFreq, f);
            }
            ans += cnt - maxFreq;
        }

        System.out.println(ans);
    }//}

    @Test
    public void Case1() {

        String input = """
                4 5 3
                4 2 1 3
                
                """;

        String expected = """
                4
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC419E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                7 10 4
                7 0 9 1 6 4 2
                
                """;

        String expected = """
                10
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC419E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC419E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC419E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
