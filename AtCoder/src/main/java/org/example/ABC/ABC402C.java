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
public class ABC402C {

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

        int n = sc.nextInt();  // 食材の数
        int m = sc.nextInt();  // 料理の数

        // 食材 i を使う料理のリスト（1-indexedだが0-indexで持つ）
        List<Integer>[] ingredientToRecipes = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            ingredientToRecipes[i] = new ArrayList<>();
        }

        // 各料理に必要な食材集合
        int[][] recipeIngredients = new int[m][];
        int[] remaining = new int[m];  // 残り必要な食材数

        for (int i = 0; i < m; i++) {
            int k = sc.nextInt();
            recipeIngredients[i] = new int[k];
            for (int j = 0; j < k; j++) {
                int s = sc.nextInt();
                recipeIngredients[i][j] = s;
                ingredientToRecipes[s].add(i);
            }
            remaining[i] = k;
        }

        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        boolean[] used = new boolean[n + 1];  // 食材が使われたか
        boolean[] cooked = new boolean[m];    // 料理が完成したか
        int cookedCount = 0;

        for (int i = 0; i < n; i++) {
            int ing = b[i];

            // この食材を使う料理に対して、残り食材を減らす
            for (int r : ingredientToRecipes[ing]) {
                if (cooked[r]) continue;

                remaining[r]--;
                if (remaining[r] == 0) {
                    cooked[r] = true;
                    cookedCount++;
                }
            }

            used[ing] = true;
            System.out.println(cookedCount);
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                5 4
                2 1 2
                3 3 4 5
                3 1 2 5
                1 3
                1 3 2 5 4
                
                """;

        String expected = """
                0
                1
                2
                3
                4
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC402C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                9 8
                1 4
                5 6 9 7 4 3
                4 2 4 1 3
                1 1
                5 7 9 8 1 5
                2 9 8
                1 2
                1 1
                6 5 2 7 8 4 1 9 3
                
                """;

        String expected = """
                0
                0
                1
                1
                1
                2
                4
                6
                8
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC402C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC402C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC402C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
