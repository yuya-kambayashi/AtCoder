package org.example;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ABC392D {

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

        int N = sc.nextInt();
        List<Map<Integer, Double>> dice = new ArrayList<>();

        // サイコロの情報を読み込む
        for (int i = 0; i < N; i++) {
            int K = sc.nextInt();
            Map<Integer, Double> prob = new HashMap<>();
            for (int j = 0; j < K; j++) {
                int num = sc.nextInt();
                prob.put(num, prob.getOrDefault(num, 0.0) + 1.0 / K);
            }
            dice.add(prob);
        }

        double maxProb = 0.0;

        // 2つのサイコロを選ぶ
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double probSum = 0.0;
                Map<Integer, Double> d1 = dice.get(i);
                Map<Integer, Double> d2 = dice.get(j);

                // 共通する目について確率を計算
                for (int key : d1.keySet()) {
                    if (d2.containsKey(key)) {
                        probSum += d1.get(key) * d2.get(key);
                    }
                }
                maxProb = Math.max(maxProb, probSum);
            }
        }

        System.out.printf("%.8f%n", maxProb);
    }
//}

    @Test
    public void Case1() {

        String input = """
                3
                3 1 2 3
                4 1 2 2 1
                6 1 2 3 4 5 6
                
                """;

        String expected = """
                0.333333333333333
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC392D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                3
                5 1 1 1 1 1
                4 2 2 2 2
                3 1 1 2
                
                """;

        String expected = """
                0.666666666666667
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC392D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC392D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC392D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
