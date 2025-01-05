package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC268D {

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
//public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();

        System.out.println();
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       1 1
                chokudai
                chokudai
                """;

        String expected = """
                -1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC268D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //  @Test
    public void Case2() {

        String input = """
                                       2 2
                choku
                dai
                chokudai
                choku_dai
                """;

        String expected = """
                dai_choku
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC268D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                                       2 2
                chokudai
                atcoder
                chokudai_atcoder
                atcoder_chokudai
                """;

        String expected = """
                -1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC268D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                                       4 4
                ab
                cd
                ef
                gh
                hoge
                fuga
                ____
                _ab_cd_ef_gh_
                """;

        String expected = """
                ab__ef___cd_gh
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC268D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
