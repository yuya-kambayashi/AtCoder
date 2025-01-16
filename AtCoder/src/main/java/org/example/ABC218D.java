package org.example;


import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC218D {

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
        Set<Coord> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(new Coord(sc.nextInt(), sc.nextInt()));
        }

        Set<List<String>> ans = new HashSet<>();
        for (var c1 : set) {
            for (var c2 : set) {
                if (c1.equals(c2)) {
                    continue;
                }

                if (c1.x == c2.x || c1.y == c2.y) {
                    continue;
                }
                if (c1.x > c2.x || c1.y > c2.y) {
                    continue;
                }

                Coord c3 = new Coord(Math.min(c1.x, c2.x), Math.max(c1.y, c2.y));
                Coord c4 = new Coord(Math.max(c1.x, c2.x), Math.min(c1.y, c2.y));

                if (set.contains(c3) && set.contains(c4)) {
                    List<String> s = new ArrayList<>();
                    s.add(c1.toString());
                    s.add(c2.toString());
                    s.add(c3.toString());
                    s.add(c4.toString());
                    Collections.sort(s);
                    ans.add(s);
                }
            }
        }
        System.out.println(ans.size());
    }

    static class Coord {
        int x, y;

        @Override
        public String toString() {
            return x + "," + y;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Coord coord = (Coord) o;
            return x == coord.x && y == coord.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
//}

    @Test
    public void Case1() {

        String input = """
                                       6
                0 0
                0 1
                1 0
                1 1
                2 0
                2 1
                """;

        String expected = """
                3
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC218D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       4
                0 1
                1 2
                2 3
                3 4
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC218D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                                       7
                0 1
                1 0
                2 0
                2 1
                2 2
                3 0
                3 2
                """;

        String expected = """
                1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC218D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC218D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
