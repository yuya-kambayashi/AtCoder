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
public class ABC411D {

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
        final int q = sc.nextInt();

        List<String> ss = new ArrayList<>();
        for (int i = 0; i <= q; i++) {
            ss.add("");
        }

        int[] p = new int[q];
        Arrays.fill(p, -1);

        int[] p2 = new int[n];
        Arrays.fill(p2, -1);
        int s = -1;

        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            int num = sc.nextInt() - 1;

            if (t == 1) {
                p2[num] = s;

            } else if (t == 2) {
                String st = sc.next();
                ss.set(i, st);

                int tmp = p2[num];
                p[i] = tmp;
                p2[num] = i;

            } else {
                s = p2[num];
            }
        }

        if (s == -1) {
            System.out.println("");
        } else {
            int par = s;
            StringBuilder sb = new StringBuilder();
            while (par != -1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(ss.get(par));
                sb.append(sb2.reverse());
                par = p[par];
            }
            System.out.println(sb.reverse());
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                2 6
                2 1 at
                3 1
                2 2 on
                1 2
                2 2 coder
                3 2
                
                """;

        String expected = """
                atcoder
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC411D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                100000 3
                1 100
                2 300 abc
                3 200
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC411D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                10 10
                2 7 ladxf
                2 7 zz
                2 7 kfm
                3 7
                1 5
                2 5 irur
                3 5
                1 6
                2 6 ptilun
                3 6
                
                """;

        String expected = """
                ladxfzzkfmirurptilun
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC411D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC411D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
