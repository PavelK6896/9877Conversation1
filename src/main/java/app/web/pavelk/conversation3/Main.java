package app.web.pavelk.conversation3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        //сумма двух наименьших
        int[] integers0 = new int[]{444, 1, 2, 123, 123, 7, 2, 1};
        Arrays.sort(integers0);
        System.out.println("№1");
        System.out.println(integers0[0] + integers0[1]);

        List<Integer> integers1 = Arrays.stream(integers0).boxed().collect(Collectors.toList());
        List<Integer> sum11 = Arrays.asList(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Integer i : integers1) {
            if (i <= sum11.get(0)) {
                sum11.set(0, i);
            }
            if (i <= sum11.get(1) && i >= sum11.get(0)) {
                sum11.set(1, i);
            }
        }
        System.out.println("№2");
        System.out.println(sum11.stream().mapToInt(f -> f).sum());

        System.out.println("№3");
        System.out.println(integers1.stream().sorted().limit(2).mapToInt(f -> f).sum());
        System.out.println(Arrays.stream(integers0).boxed().sorted().limit(2).mapToInt(f -> f).sum());
        System.out.println(IntStream.of(integers0).boxed().sorted().limit(2).mapToInt(f -> f).sum());

        //--
        List<Integer> listSort = Arrays.asList(999, 2, 3, 2, 22, 7, 55, 723);
        listSort.sort(Comparator.comparingInt(f -> -f));
        System.out.println(listSort);
        Collections.sort(listSort);
        System.out.println(listSort);

        //--
        A a = new A();
        B b = new B();

        A a2 = b;
        C c = (C) a;

        //--
        System.out.println(a.equals(b));
    }
}

interface C {

}

class A implements C {
    Integer integer1;
    Integer integer2;
    Integer integer3;
}

class B extends A implements C {
    Integer integer11;
    Integer integer21;
    Integer integer31;
}
