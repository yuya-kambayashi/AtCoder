package org.example;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC392C {

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
        List<Person> persons = new ArrayList<>();
        int[] pp = new int[n + 1];
        int[] qq = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pp[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            qq[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            int p = pp[i];
            int q = qq[i];

            persons.add(new Person(i, q, p));
        }
        persons.sort(Comparator.comparingInt(Person::getBib));
        for (int i = 0; i < n; i++) {
            var p = persons.get(i);
            var target = p.target;
            var t = qq[target];
            System.out.print(t + " ");

        }
    }

    static class Person {
        int id, bib, target;

        public Person(int id, int bib, int target) {
            this.id = id;
            this.bib = bib;
            this.target = target;
        }

        public int getId() {
            return id;
        }

        public int getBib() {
            return bib;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                4
                4 3 2 1
                2 3 1 4
                
                """;

        String expected = """
                3 4 1 2
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC392C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                10
                2 6 4 3 7 8 9 10 1 5
                1 4 8 2 10 5 7 3 9 6
                
                """;

        String expected = """
                4 8 6 5 3 10 9 2 1 7
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC392C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC392C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC392C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
