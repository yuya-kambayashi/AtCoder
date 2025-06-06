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
public class ABC406D {

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

        final int h = sc.nextInt();
        final int w = sc.nextInt();
        final int n = sc.nextInt();

        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> colMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            var map1 = rowMap.getOrDefault(x, new HashSet<Integer>());
            map1.add(y);
            rowMap.put(x, map1);

            var map2 = colMap.getOrDefault(y, new HashSet<Integer>());
            map2.add(x);
            colMap.put(y, map2);


//            rowMap.computeIfAbsent(x, k -> new HashSet<>()).add(y);
//            colMap.computeIfAbsent(y, k -> new HashSet<>()).add(x);
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            int index = sc.nextInt();

            if (t == 1) {
                Set<Integer> cols = rowMap.getOrDefault(index, new HashSet<>());
                System.out.println(cols.size());

                for (int y : cols) {
                    Set<Integer> rows = colMap.get(y);
                    if (rows != null) {
                        rows.remove(index);
                        if (rows.isEmpty()) {
                            colMap.remove(y);
                        }
                    }
                }
                rowMap.remove(index);

            } else if (t == 2) {
                Set<Integer> rows = colMap.getOrDefault(index, new HashSet<>());
                System.out.println(rows.size());

                for (int x : rows) {
                    Set<Integer> cols = rowMap.get(x);
                    if (cols != null) {
                        cols.remove(index);
                        if (cols.isEmpty()) {
                            rowMap.remove(x);
                        }
                    }
                }
                colMap.remove(index);
            }
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                3 4 5
                1 2
                1 3
                3 4
                3 1
                2 2
                5
                1 1
                1 2
                2 2
                2 4
                1 2
                
                """;

        String expected = """
                2
                1
                0
                1
                0
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC406D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                1 2 1
                1 2
                7
                2 1
                2 1
                2 1
                2 1
                2 1
                2 1
                2 1
                
                """;

        String expected = """
                0
                0
                0
                0
                0
                0
                0
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC406D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                4 4 16
                1 1
                1 2
                1 3
                1 4
                2 1
                2 2
                2 3
                2 4
                3 1
                3 2
                3 3
                3 4
                4 1
                4 2
                4 3
                4 4
                7
                2 1
                1 1
                2 2
                1 2
                2 3
                1 3
                2 4
                
                """;

        String expected = """
                4
                3
                3
                2
                2
                1
                1
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC406D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC406D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
