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
public class ABC413E {

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

    static String solve(int N, int[] P) {
        Queue<int[]> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        int[] best = P.clone();

        queue.add(P);
        visited.add(Arrays.toString(P));

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (compare(current, best) < 0) {
                best = current.clone();
            }

            for (int len = 1; len < N; len <<= 1) {
                for (int a = 0; a < N; a += len) {
                    for (int b = a + len; b + len - 1 < N; b += len) {
                        int[] next = current.clone();
                        reverse(next, a, a + len - 1);
                        reverse(next, b, b + len - 1);
                        swap(next, a, b, len);
                        String key = Arrays.toString(next);
                        if (!visited.contains(key)) {
                            visited.add(key);
                            queue.add(next);
                        }
                    }
                }
            }
        }

        return arrayToString(best);
    }

    static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int tmp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = tmp;
        }
    }

    static void swap(int[] arr, int a, int b, int len) {
        for (int i = 0; i < len; i++) {
            int tmp = arr[a + i];
            arr[a + i] = arr[b + i];
            arr[b + i] = tmp;
        }
    }

    static int compare(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return Integer.compare(a[i], b[i]);
        }
        return 0;
    }

    static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int x : arr) sb.append(x).append(" ");
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int size = 1 << n;
            int[] P = new int[size];
            for (int i = 0; i < size; i++) {
                P[i] = sc.nextInt();
            }
            System.out.println(solve(size, P));
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                4
                1
                1 2
                2
                1 3 4 2
                2
                2 3 4 1
                3
                8 3 4 2 1 5 7 6
                
                """;

        String expected = """
                1 2
                1 3 2 4
                1 4 2 3
                1 5 6 7 2 4 3 8
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC413E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case2() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC413E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC413E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC413E.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
