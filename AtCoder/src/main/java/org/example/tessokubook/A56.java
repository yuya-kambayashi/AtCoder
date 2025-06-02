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
public class A56 {

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
    private static final long mod = 1000000007;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int q = sc.nextInt();
        final String s = sc.next();
        long[] hash = new long[n + 1];
        long[] power = new long[n + 1];
        power[0] = 1;
        for (int i = 0; i < n; i++) {
            hash[i + 1] = (hash[i] * 131 + s.charAt(i)) % mod;
            power[i + 1] = power[i] * 131 % mod;
        }
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt();
            int c = sc.nextInt() - 1;
            int d = sc.nextInt();

            long hashA = (hash[b] - hash[a] * power[b - a] % mod + mod) % mod;
            long hashB = (hash[d] - hash[c] * power[d - c] % mod + mod) % mod;

            System.out.println(hashA == hashB ? "Yes" : "No");

        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                7 3
                abcbabc
                1 3 5 7
                1 5 2 6
                1 2 6 7
                
                """;

        String expected = """
                Yes
                No
                No
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A56.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case2() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A56.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A56.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A56.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
