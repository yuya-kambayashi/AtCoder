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
public class ABC416C {

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
    static int n, k, x;

    static List<String> ss;
    static List<List<Integer>> idss;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();
        ss = new ArrayList<>();
        idss = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ss.add(sc.next());
        }
        gen2(new ArrayList<>());

        List<String> ans = new ArrayList<>();
        for (var ids : idss) {
            StringBuilder sb = new StringBuilder();
            for (var id : ids) {
                sb.append(ss.get(id));
            }
            ans.add(sb.toString());
        }


        Collections.sort(ans);
        System.out.println(ans.get(x - 1));
    }

//    static void gen(String cur, int d) {
//        if (d == k) {
//            ans.add(cur);
//            return;
//        }
//        for (int i = 0; i < n; i++) {
//            gen(cur + ss.get(i), d + 1);
//        }
//    }

    static void gen2(List<Integer> ids) {
        if (ids.size() == k) {
            idss.add(ids);
            return;
        }
        for (int i = 0; i < n; i++) {
            List<Integer> next = new ArrayList<>(ids);
            next.add(i);
            gen2(next);
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                3 2 6
                abc
                xxx
                abc
                
                """;

        String expected = """
                abcxxx
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC416C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                5 5 416
                a
                aa
                aaa
                aa
                a
                
                """;

        String expected = """
                aaaaaaa
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC416C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC416C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        ABC416C.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
