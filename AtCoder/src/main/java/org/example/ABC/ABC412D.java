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
public class ABC412D {

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
        boolean[][] ggg = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            ggg[a][b] = true;
            ggg[b][a] = true;
        }

        for (int bit = 0; bit < (1 << n); bit++) {
            for (int i = 0; i < n; i++) {
                if ((bit & (1 << i)) != 0) {
                    continue;
                }
                boolean[][] ttt = new boolean[n][n];
                for (int j = 0; j < n; j++) {
                    ttt = Arrays.copyOf(ggg, n);
                }
                if (i > 0){
                    ggg[i]
                }
            }
        }


        System.out.println(ans);
    }

    static boolean chack(boolean[][] ggg) {
        boolean ok = true;
        for (int i = 0; i < ggg.length; i++) {
            if (ggg[i].length != 2) {
                ok = false;
                break;
            }
        }
        return ok;
    }
//}

    @Test
    public void Case1() {

        String input = """
                5 4
                1 2
                1 5
                2 4
                4 5
                
                
                """;

        String expected = """
                3
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC412D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                3 0
                
                """;

        String expected = """
                3
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC412D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                6 8
                1 4
                1 5
                2 3
                2 6
                3 4
                3 6
                4 5
                4 6
                
                """;

        String expected = """
                2
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC412D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                8 21
                1 4
                5 7
                8 4
                3 4
                2 5
                8 1
                5 1
                2 8
                2 1
                2 4
                3 1
                6 7
                5 8
                2 7
                6 8
                5 4
                3 8
                7 3
                7 8
                5 3
                7 4
                
                """;

        String expected = """
                13
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC412D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
