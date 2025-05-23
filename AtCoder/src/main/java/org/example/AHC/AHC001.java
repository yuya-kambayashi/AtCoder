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
public class AHC001 {

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
        List<Input> ins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ins.add(new Input(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        List<Output> outs = new ArrayList<>();
        for (var in : ins) {
            outs.add(new Output(in.x - 1, in.y - 1, in.x + 1, in.y + 1));
        }

        for (var out : outs) {
            System.out.println(out.a + " " + out.b + " " + out.c + " " + out.d);
        }

    }

    static class Input {
        int x, y, r;

        public Input(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    static class Output {
        int a, b, c, d;

        public Output(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                50
                1909 360 6468907
                5810 7091 4661329
                5407 422 2010076
                5767 3140 681477
                6659 3234 920591
                4206 1620 2487369
                7853 9492 440133
                7875 432 586159
                9048 5059 1805425
                7292 9070 509242
                7633 2496 1558444
                421 4835 1808752
                7164 4109 35081
                5356 2271 78438
                5261 577 971398
                3546 5225 1871979
                4667 3386 28796
                5596 7896 3310195
                2518 9813 1739130
                9002 3913 334620
                8574 8947 1107057
                3118 1773 669849
                7140 4388 2098247
                8544 8196 1742491
                8577 4337 4435283
                3155 9168 976005
                7823 4404 945830
                9451 110 569854
                7031 1389 787729
                1841 2337 942236
                76 8364 710110
                3543 3931 3840994
                3927 8828 2920828
                5671 3305 1526349
                5542 4587 6285390
                4030 7732 3962404
                8575 8200 3662259
                1139 3739 254000
                50 7415 647735
                934 4056 1800657
                8801 7178 1218595
                4499 6207 660560
                3096 3375 2695827
                5252 3281 1046149
                2247 1446 7148429
                3347 8501 7546190
                5791 8600 3909497
                8033 8992 3365971
                2297 9254 23830
                4312 6176 192104
                
                """;

        String expected = """
                0 0 4473 1446
                4634 5915 6987 7896
                4473 0 7875 577
                5260 2633 6274 3305
                6274 2722 7172 3747
                3174 1446 5238 2651
                7522 9161 8185 9824
                7875 0 8454 1012
                8376 4388 9720 5731
                6890 8668 7522 9473
                7172 1815 8315 3178
                0 4072 1185 5598
                7071 4016 7258 4203
                5238 2124 5504 2418
                4565 577 5958 1274
                2862 4541 4230 5909
                4582 3302 4752 3471
                3348 7896 8049 8600
                1351 9255 3685 10000
                8713 3624 9291 4202
                8185 8373 9149 9521
                2480 1446 3174 2411
                6105 4203 7823 5424
                8049 5731 8575 8373
                7823 3178 8713 4388
                2410 8600 3900 9255
                7823 4388 8376 5731
                8969 0 9933 591
                6581 940 7481 1815
                1356 1852 2327 2822
                0 7805 635 8923
                1286 3376 4582 4541
                3900 8600 5791 10000
                4752 3305 6274 4203
                4582 4203 6105 5915
                2287 6208 4634 7896
                8575 7179 10000 8373
                849 3449 1286 4030
                0 6812 652 7805
                0 4030 1286 4072
                8575 6182 9797 7179
                4313 5915 4634 6208
                2327 2651 4582 3376
                4752 2651 5260 3305
                0 1446 2480 1852
                635 7896 3348 8600
                5791 8600 6890 10000
                7522 8600 8185 9161
                2188 9146 2406 9255
                3671 5909 4313 6208
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        AHC001.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case2() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        AHC001.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        AHC001.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        AHC001.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
