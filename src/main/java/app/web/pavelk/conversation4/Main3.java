package app.web.pavelk.conversation4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main3 {
    public static void main(String[] args) {
        int []arr = new int[]{1,2,3, 14, 12, 7};
        int sum = 10;

        System.out.println(firstSumNumber(arr, sum));
        System.out.println(firstIndexNumber(arr, sum));
    }

    public static List<Integer> firstSumNumber(int[] arr, int sum) {
        List<Integer> collect = IntStream.of(arr).boxed().collect(Collectors.toList());
        for (Integer i: collect){
            if(collect.contains(sum - i)){
                return Arrays.asList(i, sum - i);
            }
        }
        throw new RuntimeException();
    }

    public static List<Integer> firstIndexNumber(int[] arr, int sum) {
        List<Integer> collect = IntStream.of(arr).boxed().collect(Collectors.toList());
        int i1;
        for (int i = 0; i < collect.size(); i++) {
            if((i1 = collect.indexOf(sum - collect.get(i))) > 0){
                return  Arrays.asList(i,i1);
            }
        }
        throw new RuntimeException();
    }
}



