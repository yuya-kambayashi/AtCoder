package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.swing.plaf.synth.SynthLookAndFeel;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC287D {

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
//public class Mai{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        for (int i = 0; i < s.length(); i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i + 1, s.length());
            String s3 = s1 + s2;

            boolean ok = true;

            for (int j = 0; j < t.length(); j++) {
                char a = s3.charAt(j);
                char b = t.charAt(j);

                if (!match(a, b)) {
                    ok = false;
                    break;
                }
            }
            System.out.println(ok ? "Yes" : "No");
        }
    }

    static boolean match(char a, char b) {
        return a == '?' || b == '?' || a == b;
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       a?c
                b?
                """;

        String expected = """
                                          Yes
                No
                No
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC287D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       atcoder
                ?????
                """;

        String expected = """
                                          Yes
                Yes
                Yes
                Yes
                Yes
                Yes
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC287D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       beginner
                contest
                """;

        String expected = """
                                          No
                No
                No
                No
                No
                No
                No
                No
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC287D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC287D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
