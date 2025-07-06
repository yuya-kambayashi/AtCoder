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
public class ABC401D {

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
        int k = sc.nextInt();
        String s = sc.next();
        char[] cc = s.toCharArray();

        if (n == 1) {
            if (k == 1) {
                System.out.println("o");
            } else if (k == 0) {
                System.out.println(".");
            }
            return;
        }

        int req = k;
        for (var c : cc) {
            if (c == 'o') {
                req--;
            }
        }


        for (int i = 0; i < n; i++) {
            if (cc[i] == '?') {
                if (i > 0 && cc[i - 1] == 'o') {
                    cc[i] = '.';
                }
                if (i < n - 1 && cc[i + 1] == 'o') {
                    cc[i] = '.';
                }
            }
        }

        int cntq = 0;
        for (int i = 0; i < n; i++) {
            if (cc[i] == '?') {
                cntq++;
            }
        }

        if (req == 0) {
            System.out.println(String.valueOf(cc));
            return;
        }

        if (req == cntq) {
            for (int i = 0; i < n; i++) {
                if (cc[i] == '?') {
                    cc[i] = 'o';
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (cc[i] == '?') {
                    int cnt = 1;
                    int j = i + 1;
                    while (j <= n - 1) {
                        if (cc[j] == '?') {
                            cnt++;
                        } else {
                            break;
                        }
                        j++;
                    }
                    if (cnt % 2 == 1) {
                        boolean b = true;
                        for (int t = i; t < i + cnt; t++) {
                            if (b) {
                                cc[t] = '.';
                                b = false;
                            } else {
                                cc[t] = 'o';
                                b = true;
                            }
                        }
                    }
                    i += cnt - 1;
                }
            }
        }


        System.out.println(String.valueOf(cc));
    }
//}

    @Test
    public void Case1() {

        String input = """
                4 2
                o???
                
                """;

        String expected = """
                o.??
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC401D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                5 2
                ?????
                
                
                """;

        String expected = """
                ?????
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC401D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                7 3
                .o???o.
                
                """;

        String expected = """
                .o.o.o.
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC401D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                3 1
                ??.
                """;

        String expected = """
                o..
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC401D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
