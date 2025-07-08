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
public class ABC413B {

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
        Set<String> set = new HashSet<>();
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                String t = ss[i] + ss[j];
                set.add(t);
            }
        }
        System.out.println(set.size());
    }
//}

    @Test
    public void Case1() {

        String input = """
                4
                at
                atco
                coder
                der
                
                """;

        String expected = """
                11
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC413B.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                5
                a
                aa
                aaa
                aaaa
                aaaaa
                
                """;

        String expected = """
                7
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC413B.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                10
                armiearggc
                ukupaunpiy
                cogzmjmiob
                rtwbvmtruq
                qapfzsitbl
                vhkihnipny
                ybonzypnsn
                esxvgoudra
                usngxmaqpt
                yfseonwhgp
                
                """;

        String expected = """
                90
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC413B.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC413B.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
