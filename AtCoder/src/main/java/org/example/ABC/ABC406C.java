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
public class ABC406C {

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
        int n = sc.nextInt();
        int[] aa = new int[n];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
        }

        TreeSet<Integer> mountain = new TreeSet<>();
        TreeSet<Integer> valley = new TreeSet<>();


        for (int i = 1; i < n - 1; i++) {
            if (aa[i - 1] < aa[i] && aa[i] > aa[i + 1]) {
                mountain.add(i);
            }
            if (aa[i - 1] > aa[i] && aa[i] < aa[i + 1]) {
                valley.add(i);
            }
        }
        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            

            int m = 0, v = 0;
            boolean canm = false, canv = false;
            for (int j = i + 1; j < n; j++) {

                if (canm) {
                    m++;
                    canm = false;
                }
                if (canv) {
                    v++;
                    canv = false;
                }

                if (mountain.contains(j)) {
                    canm = true;
                }
                if (valley.contains(j)) {
                    canv = true;
                }
                if (m == 1 && v == 1 && j - i >= 3) {
                    ans++;
                } else if (m > 1 || v > 1) {
                    break;
                }
            }
        }
        System.out.println(ans);

    }
//}

    @Test
    public void Case1() {

        String input = """
                6
                1 3 6 4 2 5
                
                """;

        String expected = """
                2
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC406C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                6
                1 2 3 4 5 6
                
                
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC406C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                12
                11 3 8 9 5 2 10 4 1 6 12 7
                
                """;

        String expected = """
                4
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC406C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC406C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
