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
public class ABC415C {

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
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            String s = sc.next();
            int len = (int) Math.pow(2, t);

            List<List<Integer>> oks = new ArrayList<>();
            for (int j = 0; j <= t; j++) {
                oks.add(new ArrayList<>());
            }
            for (int j = 1; j <= t; j++) {
                for (int k = 1; k <= t; k++) {
                    if (j == k) {
                        continue;
                    }
                    oks.get(j).add(k);
                }
            }

            for (int j = 0; j < len - 1; j++) {
                if (s.charAt(j) == '1') {
                    String b = Integer.toBinaryString(j + 1);

                    List<Integer> ng = new ArrayList<>();
                    for (int k = 0; k < b.length(); k++) {
                        if (b.charAt(k) == '1') {
                            ng.add(k + 1);
                        }
                    }
                    for (int k = 0; k < ng.size(); k++) {

                        var ok = oks.get(ng.get(k));
                        for (int p = 0; p < ng.size(); p++) {
                            if (k == p) {
                                continue;
                            }
                            ok.remove(ng.get(p));
                        }
                    }
                }
            }
            String ret = "No";
            for (int j = 1; j <= t; j++) {
                if (oks.get(j).size() > 0) {
                    ret = "Yes";
                    break;
                }
            }
            System.out.println(ret);
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                5
                3
                0010000
                3
                0010110
                1
                1
                2
                100
                4
                001110010101110
                
                """;

        String expected = """
                Yes
                No
                No
                Yes
                Yes
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC415C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                1
                4
                001110010101110
                """;

        String expected = """
                Yes
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC415C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC415C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC415C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
