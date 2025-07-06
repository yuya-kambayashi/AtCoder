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

    record Node(Node prev, int sid) {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int q = sc.nextInt();

        List<String> ss = new ArrayList<>();
        Node[] state = new Node[n + 1];

        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            int p = sc.nextInt();
            if (t == 1) {
                state[p] = state[0];

            } else if (t == 2) {
                String s = sc.next();
                ss.add(s);
                state[p] = new Node(state[p], ss.size() - 1);

            } else {
                state[0] = state[p];
            }
        }

        Deque<Integer> stack = new ArrayDeque<>();
        Node cur = state[0];
        while (cur != null) {
            stack.push(cur.sid);
            cur = cur.prev;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(ss.get(stack.pop()));
        }
        System.out.println(sb.toString());

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
