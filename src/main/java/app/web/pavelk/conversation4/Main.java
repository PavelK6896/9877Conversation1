package app.web.pavelk.conversation4;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.sort(Comparator.comparing(Integer::intValue).reversed());
        System.out.println(list);

        System.out.println(StandardCharsets.UTF_8.name());
        System.out.println(StandardCharsets.UTF_8.toString());
        System.out.println(StandardCharsets.UTF_8);

        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = Collections.synchronizedMap(map1);
        Map<String, String> map3 = new ConcurrentHashMap<>();
        Map<String, String> map4 = new Hashtable<>();
        Map<String, String> map5 = new ConcurrentSkipListMap<>();
        Map<String, String> map6 = new TreeMap<>();
        Map<String, String> map7 = Collections.synchronizedMap(map6);

        System.out.println(map1.getClass().toString());
        System.out.println(map2.getClass().toString());
        System.out.println(map3.getClass().toString());
        System.out.println(map4.getClass().toString());
        System.out.println(map5.getClass().toString());
        System.out.println(map6.getClass().toString());
        System.out.println(map7.getClass().toString());

        List<String> list1 = new ArrayList<>();
        List<String> list2 = Collections.synchronizedList(list1);
        List<String> list3 = new CopyOnWriteArrayList<>();

        System.out.println(list1.getClass().toString());
        System.out.println(list2.getClass().toString());
        System.out.println(list3.getClass().toString());

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = Collections.synchronizedSet(set1);
        Set<String> set3 = new CopyOnWriteArraySet<>();
        Set<String> set4 = new ConcurrentSkipListSet<>();

        System.out.println(set1.getClass().toString());
        System.out.println(set2.getClass().toString());
        System.out.println(set3.getClass().toString());
        System.out.println(set4.getClass().toString());

    }
}
