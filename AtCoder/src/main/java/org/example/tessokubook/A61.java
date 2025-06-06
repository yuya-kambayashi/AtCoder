package org.example.tessokubook;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import com.sun.source.tree.Tree;
import org.example.template.StandardInputSnatcher;
import org.example.template.StandardOutputSnatcher;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class A61 {

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

        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + ", " + b);
            } else {
                map.put(a, "" + b);
            }
            if (map.containsKey(b)) {
                map.put(b, map.get(b) + ", " + a);
            } else {
                map.put(b, "" + a);
            }
        }
        for (int i = 1; i <= n; i++) {
            if (map.containsKey(i)) {
                System.out.println(i + ": {" + map.get(i) + "}");
            } else {
                System.out.println(i + ": {}");
            }
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                5 4
                1 2
                2 3
                3 4
                3 5
                
                """;

        String expected = """
                1: {2}
                2: {1, 3}
                3: {2, 4, 5}
                4: {3}
                5: {3}
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A61.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                15 30
                6 9
                9 10
                2 9
                9 12
                2 14
                1 4
                4 6
                1 3
                4 14
                1 6
                9 11
                2 6
                3 9
                5 9
                4 9
                11 15
                1 13
                4 13
                8 9
                9 13
                5 15
                3 5
                8 10
                2 4
                9 14
                1 9
                2 8
                6 13
                7 9
                9 15                
                """;

        String expected = """
                1: {3, 4, 6, 9, 13}
                2: {4, 6, 8, 9, 14}
                3: {1, 5, 9}
                4: {1, 2, 6, 9, 13, 14}
                5: {3, 9, 15}
                6: {1, 2, 4, 9, 13}
                7: {9}
                8: {2, 9, 10}
                9: {1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15}
                10: {8, 9}
                11: {9, 15}
                12: {9}
                13: {1, 4, 6, 9}
                14: {2, 4, 9}
                15: {5, 9, 11}
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A61.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                2 1
                1 2
                """;

        String expected = """
                1: {2}
                2: {1}
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A61.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A61.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
