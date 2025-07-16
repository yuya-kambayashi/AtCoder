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
public class ABC414D {

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
        final int m = sc.nextInt();
        long[] xx = new long[n];
        for (int i = 0; i < n; i++) {
            xx[i] = sc.nextLong();
        }

        long[] dd = new long[n - 1];
        Arrays.sort(xx);

        for (int i = 0; i < n - 1; i++) {
            dd[i] = xx[i + 1] - xx[i];
        }
        Arrays.sort(dd);

        long ans = 0;
        for (int i = 0; i < n - m; i++) {
            ans += dd[i];
        }

        System.out.println(ans);
    }
//}

    @Test
    public void Case1() {

        String input = """
                7 3
                5 10 15 20 8 14 15
                
                """;

        String expected = """
                6
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC414D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                7 7
                5 10 15 20 8 14 15
                
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC414D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                7 1
                5 10 15 20 8 14 15
                
                """;

        String expected = """
                15
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC414D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC414D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
