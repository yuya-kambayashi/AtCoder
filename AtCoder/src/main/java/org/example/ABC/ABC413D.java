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
public class ABC413D {

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
        int T = sc.nextInt();  // テストケース数

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[] aa = new int[N];
            for (int i = 0; i < N; i++) {
                aa[i] = sc.nextInt();
            }

            boolean isGeometric = canFormGeometricSequence2(aa);

            System.out.println(isGeometric ? "Yes" : "No");
        }
    }


    public static boolean canFormGeometricSequence2(int[] arr) {
        int n = arr.length;
        if (n <= 2) return true;

        // 0 が含まれていたら等比列は 0 のみ許容（特殊ケース）
        boolean allZero = true;
        for (int x : arr) {
            if (x == 0) continue;
            allZero = false;
            break;
        }
        if (allZero) return true;
        for (int x : arr) {
            if (x == 0) return false; // 0 が混じっていたら等比にならない
        }

        // log変換 + 符号情報を保持
        class LogEntry {
            double logVal;
            int sign;

            LogEntry(int val) {
                this.logVal = Math.log(Math.abs(val));
                this.sign = Integer.signum(val);
            }
        }

        LogEntry[] logs = Arrays.stream(arr)
                .mapToObj(LogEntry::new)
                .toArray(LogEntry[]::new);

        Arrays.sort(logs, Comparator.comparingDouble(e -> e.logVal));

        // 差分をチェック（等差になっているか）
        double expectedDiff = logs[1].logVal - logs[0].logVal;
        for (int i = 2; i < n; i++) {
            double diff = logs[i].logVal - logs[i - 1].logVal;
            if (Math.abs(diff - expectedDiff) > 1e-9) return false;
        }

        // 符号パターンのチェック：交互に変化しているか、またはすべて同符号か
        boolean allSameSign = true;
        for (int i = 1; i < n; i++) {
            if (logs[i].sign != logs[0].sign) {
                allSameSign = false;
                break;
            }
        }

        if (allSameSign) return true;

        // 交互符号（+, -, +, -, ...）や (-, +, -, +, ...) であるかを確認
        boolean alt1 = true, alt2 = true;
        for (int i = 0; i < n; i++) {
            if (logs[i].sign != (i % 2 == 0 ? 1 : -1)) alt1 = false;
            if (logs[i].sign != (i % 2 == 0 ? -1 : 1)) alt2 = false;
        }

        return alt1 || alt2;
    }

//}

    @Test
    public void Case1() {

        String input = """
                3
                5
                1 8 2 4 16
                5
                -16 24 54 81 -36
                7
                90000 8100 -27000 729 -300000 -2430 1000000
                
                """;

        String expected = """
                Yes
                No
                Yes
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC413D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case2() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC413D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                1
                5
                1 -2 4 -8 16
                -2 16 -8 16 1
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC413D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC413D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
