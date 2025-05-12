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
public class ABC403C {

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
        final int m = sc.nextInt();
        final int q = sc.nextInt();

        Set<String> all = new HashSet<>();

        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            int x = sc.nextInt();
            if (t == 1) {
                int y = sc.nextInt();
                String s = Integer.toString(x) + "," + Integer.toString(y);
                all.add(s);

            } else if (t == 2) {
                String s = Integer.toString(x) + ",all";
                all.add(s);

            } else if (t == 3) {
                int y = sc.nextInt();
                String s1 = Integer.toString(x) + ",all";
                String s2 = Integer.toString(x) + "," + Integer.toString(y);

                if (all.contains(s1) || all.contains(s2)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }

    }
//}

    @Test
    public void Case1() {

        String input = """
                2 3 5
                1 1 2
                3 1 1
                3 1 2
                2 2
                3 2 3
                
                """;

        String expected = """
                No
                Yes
                Yes
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC403C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                5 5 10
                2 2
                3 4 4
                1 1 1
                1 4 1
                1 4 2
                1 4 4
                1 2 4
                3 3 2
                3 5 4
                3 2 1
                
                """;

        String expected = """
                No
                No
                No
                Yes
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC403C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC403C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                2 3 5
                1 1 2
                3 1 1
                3 1 2
                2 2
                3 2 3
                
                """;

        String expected = """
                No
                Yes
                Yes
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC403C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
