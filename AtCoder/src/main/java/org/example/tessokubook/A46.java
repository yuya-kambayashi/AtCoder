package org.example.tessokubook;

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
public class A46 {

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
        List<Point> pp = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            pp.add(new Point(sc.nextInt(), sc.nextInt(), i));
        }
        Map<Integer, List<Distance>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            List<Distance> ds = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                var d = pp.get(i - 1).distance(pp.get(j - 1));
                ds.add(new Distance(j, d));
            }
            ds.sort(Comparator.comparing(Distance::getDistance).thenComparing(Distance::getIndex));
            map.put(i, ds);
        }

        Set<Integer> used = new HashSet<>();
        used.add(1);
        int index = 1;
        List<Integer> ans = new ArrayList<>();
        while (ans.size() < n) {
            ans.add(index);
            var nextIds = map.get(index);
            for (var next : nextIds) {
                if (!used.contains(next.index)) {
                    index = next.index;
                    used.add(next.index);
                    break;
                }
            }
        }
        ans.add(1);
        for (var a : ans) {
            System.out.println(a);
        }
    }

    static class Point {
        int x, y, index;

        Point(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        double distance(Point p) {
            return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
        }
    }

    static class Distance {
        int index;
        double distance;

        Distance(int index, double distance) {
            this.index = index;
            this.distance = distance;
        }

        double getDistance() {
            return distance;
        }

        int getIndex() {
            return index;
        }
    }
//}

    @Test
    public void Case1() {

        String input = """
                7
                1 1
                4 1
                2 5
                3 4
                3 2
                4 2
                5 5
                
                """;

        String expected = """
                1
                2
                6
                7
                3
                4
                5
                1
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A46.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    @Test
    public void Case2() {

        String input = """
                150
                860 284
                397 996
                481 973
                529 426
                257 308
                770 955
                858 574
                268 891
                905 659
                521 14
                290 700
                864 329
                569 774
                152 841
                548 670
                838 815
                912 87
                777 360
                59 851
                594 462
                978 711
                705 534
                757 64
                63 53
                236 938
                91 561
                259 626
                170 538
                999 126
                376 591
                810 964
                526 981
                410 798
                535 728
                395 708
                333 856
                590 719
                375 208
                382 790
                340 613
                340 2
                530 351
                439 526
                2 828
                44 459
                300 907
                31 980
                29 26
                759 162
                437 303
                55 787
                638 514
                53 68
                46 114
                395 716
                71 732
                292 844
                584 305
                521 619
                402 821
                398 220
                55 375
                675 399
                484 33
                178 356
                532 929
                144 960
                793 772
                430 865
                692 818
                431 707
                414 674
                819 760
                527 653
                863 698
                422 504
                762 698
                808 479
                534 3
                423 715
                700 125
                557 545
                20 1000
                218 537
                75 372
                313 985
                457 463
                365 866
                399 477
                205 51
                484 719
                363 766
                666 813
                307 335
                513 208
                495 417
                140 115
                225 731
                397 516
                665 409
                402 430
                217 649
                446 848
                696 307
                224 823
                177 258
                305 3
                526 329
                654 116
                268 160
                936 529
                228 853
                260 866
                838 691
                53 543
                28 32
                984 775
                889 746
                382 91
                413 691
                595 522
                61 667
                105 242
                258 346
                927 794
                624 337
                995 647
                315 102
                901 22
                858 738
                13 692
                238 741
                388 305
                817 307
                458 793
                486 15
                968 875
                863 36
                967 493
                463 539
                493 662
                910 83
                253 343
                212 410
                564 332
                624 77
                659 468
                945 707
                498 227
                952 2
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A46.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case3() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A46.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }

    //@Test
    public void Case4() {

        String input = """
                
                """;

        String expected = """
                
                """;
        Stream.of(input.split("\\n")).map(String::trim).forEach(in::inputln);
        A46.main(null);
        Stream.of(expected.split("\\n")).map(String::trim).forEach(s -> assertThat(out.readLine().trim()).isEqualTo(s));
    }
}
