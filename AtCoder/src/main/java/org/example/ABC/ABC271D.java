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
public class ABC271D {

    final private StandardInputSnatcher in = new StandardInputSnatcher();
    final private StandardOutputSnatcher out = new StandardOutputSnatcher();

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

    // https://atcoder.jp/contests/abc271/submissions/35322889

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int s = sc.nextInt();
        int[] aa = new int[n];
        int[] bb = new int[n];
        for(int i = 0; i < n; i++){
            aa[i] = sc.nextInt();
            bb[i] = sc.nextInt();
        }
        var map = new TreeMap<Integer, String>();
        map.put(0, "");

        for(int i =0; i < n; i++){
            var next = new TreeMap<Integer, String>();
            for(var e : map.entrySet()){
                if (next.get(e.getKey() + aa[i]) == null){
                    next.put(e.getKey() + aa[i], e.getValue() + "H");
                }
                if (next.get(e.getKey() + bb[i]) == null){
                    next.put(e.getKey() + bb[i], e.getValue() + "T");
                }
            }
            map = next;
        }
        for(var e : map.entrySet()){
            if (e.getKey() == s){
                System.out.println("Yes");
                System.out.println(e.getValue());
                return;
            }
        }

        System.out.println("No");
    }
//}

    @Test
    public void Case1() {

        String input = """
                                       3 11
                1 4
                2 3
                5 7
                """;

        String expected = """
                                          Yes
                THH
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC271D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                                       5 25
                2 8
                9 3
                4 11
                5 1
                12 6
                """;

        String expected = """
                No
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC271D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC271D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    // @Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);

        ABC271D.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
