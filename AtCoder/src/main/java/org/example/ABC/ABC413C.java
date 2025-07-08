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
public class ABC413C {

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

        LinkedList<long[]> list = new LinkedList<>();

        for (int i = 0; i < n; ++i) {
            int t = sc.nextInt();
            if (t == 1) {
                long c = sc.nextInt();
                long x = sc.nextInt();

                if (list.isEmpty()) {
                    list.add(new long[]{x, c});

                } else {

                    var last = list.get(list.size() - 1);

                    if (last[0] == x) {
                        last[1] += c;
                    } else {
                        list.add(new long[]{x, c});
                    }
                }

            } else {
                long k = sc.nextInt();

                long removed = 0;
                long ans = 0;
                while (true) {

                    if (removed == k) {
                        break;
                    }

                    long[] cur = list.get(0);

                    if (removed + cur[1] <= k) {
                        // 全部削除
                        list.removeFirst();
                        removed += cur[1];
                        ans += cur[0] * cur[1];
                    } else if (removed + cur[1] > k) {
                        long diff = removed + cur[1] - k;

                        ans += cur[0] * (cur[1] - diff);
                        list.removeFirst();
                        list.addFirst(new long[]{cur[0], diff});
                        removed += (cur[1] - diff);
                    }
                }

                System.out.println(ans);
            }
        }

    }
//}

    @Test
    public void Case1() {

        String input = """
                5
                1 2 3
                1 4 5
                2 3
                1 6 2
                2 5
                
                """;

        String expected = """
                11
                19
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC413C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                10
                1 75 22
                1 81 72
                1 2 97
                1 84 82
                1 2 32
                1 39 57
                2 45
                1 40 16
                2 32
                2 42
                
                """;

        String expected = """
                990
                804
                3024
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC413C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case3() {

        String input = """
                10
                1 160449218 954291757
                2 17217760
                1 353195922 501899080
                1 350034067 910748511
                1 824284691 470338674
                2 180999835
                1 131381221 677959980
                1 346948152 208032501
                1 893229302 506147731
                2 298309896
                
                """;

        String expected = """
                16430766442004320
                155640513381884866
                149721462357295680
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC413C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case4() {

        String input = """
                2
                1 3 2
                1 4 2
                
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC413C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
