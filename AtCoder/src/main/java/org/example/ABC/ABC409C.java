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
public class ABC409C {

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
        final int l = sc.nextInt();
        if (l % 3 != 0) {
            System.out.println(0);
            return;
        }

        int[] aa = new int[n];
        aa[0] = 0;
        for (int i = 1; i < n; i++) {
            int t = sc.nextInt();
            int next = aa[i - 1] + t;
            next %= l;
            aa[i] = next;
        }
        Arrays.sort(aa);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (var a : aa) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int len = l / 3;

        long ans = 0;
        Set<Integer> used = new HashSet<>();
        for (var a : map.keySet()) {
            if (used.contains(a)) {
                continue;
            }
            int b = (a + len) % l;
            int c = (b + len) % l;
            if (map.containsKey(b) && map.containsKey(c)) {
                ans += (long) map.get(a) * map.get(b) * map.get(c);
                used.add(a);
                used.add(b);
                used.add(c);
            }
        }

        System.out.println(ans);
    }
//}

    @Test
    public void Case1() {

        String input = """
                5 6
                4 3 1 2
                
                """;

        String expected = """
                2
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC409C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                4 4
                1 1 1
                
                """;

        String expected = """
                0
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC409C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                10 12
                4 4 5 7 1 7 0 8 5
                
                """;

        String expected = """
                13
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC409C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC409C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
