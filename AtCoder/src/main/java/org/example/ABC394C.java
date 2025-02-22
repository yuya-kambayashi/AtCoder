package org.example;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC394C {

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

        final String s = sc.next();
        int n = s.length();
        char[] cc = s.toCharArray();

        char[] aa = new char[n];
        boolean startWithA = false;

        for (int i = n - 1; i >= 0; i--) {
            char c = cc[i];
            if (c == 'A') {
                if (i != 0 && cc[i - 1] == 'W') {
                    aa[i] = 'C';
                } else {
                    aa[i] = 'A';
                }
                startWithA = true;
            } else if (c == 'W') {

                if (startWithA) {
                    if (i == 0) {
                        aa[i] = 'A';
                    } else if (cc[i - 1] == 'W') {
                        aa[i] = 'C';
                    } else {
                        aa[i] = 'A';
                    }
                } else {
                    aa[i] = 'W';
                }


            } else {
                aa[i] = c;
                startWithA = false;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(aa);
        System.out.println(sb);
    }
//}

    @Test
    public void Case1() {

        String input = """
                WACWA
                
                """;

        String expected = """
                ACCAC
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC394C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                WWA
                
                """;

        String expected = """
                ACC
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC394C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                WWWWW
                
                """;

        String expected = """
                WWWWW
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC394C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC394C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
