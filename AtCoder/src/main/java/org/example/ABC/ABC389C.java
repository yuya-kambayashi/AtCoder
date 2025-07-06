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
public class ABC389C {

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

        final int q = sc.nextInt();

        LinkedList<Integer> que = new LinkedList<>();
        // LinkedList<Long> queSum = new LinkedList<>();
        long sumBeforeThis = 0;
        List<Long> queSum2 = new ArrayList<>();


        long removedLength = 0;
        int removeCount = 0;

        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            if (a == 1) {
                int b = sc.nextInt();
                que.add(b);

                //   queSum.add(sumBeforeThis);
                queSum2.add(sumBeforeThis);
                sumBeforeThis += b;

            } else if (a == 2) {
                removedLength += que.poll();
                //   queSum.poll();
                removeCount++;

            } else {
                int b = sc.nextInt();
                b--;
                // long t = queSum.get(b);
                long t2 = queSum2.get(b + removeCount);


                System.out.println(t2 - removedLength);

            }
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                7
                1 5
                1 7
                3 2  
                1 3
                1 4
                2
                3 3
                
                """;

        String expected = """
                5
                10
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC389C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                3
                1 1
                2
                1 3
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC389C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                10
                1 15
                1 10
                1 5
                2
                1 5
                1 10
                1 15
                2
                3 4
                3 2
                
                """;

        String expected = """
                20
                5
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC389C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                2
                1 1
                3 1
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC389C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case5() {

        String input = """
                3
                1 1
                1 1
                3 2
                """;

        String expected = """
                1
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC389C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
