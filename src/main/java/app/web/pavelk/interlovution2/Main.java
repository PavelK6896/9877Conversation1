package app.web.pavelk.interlovution2;

import java.util.*;
import java.util.concurrent.*;

class Main1 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 4, 4, 4, 1, 3, 2, 4);
        //количество переменыйх которые дублируються
        System.out.println(search1(integers));
        System.out.println(search2(integers));
        //количество дубликатов
        System.out.println(search3(integers));
        System.out.println(search4(integers));
    }

    public static Integer search1(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer integer : list) {
            if (map.containsKey(integer)) {
                map.put(integer, 1);
            } else {
                map.put(integer, 0);
            }
        }
        return map.values().stream().mapToInt(f -> f).sum();
    }

    public static Integer search2(List<Integer> list) {
        Integer count = 0;
        Integer current = 0;
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            current = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (current.equals(list.get(j)) && !list1.contains(list.get(j))) {
                    count++;
                    list1.add(list.get(j));
                }
            }
        }
        return count;
    }

    public static Integer search3(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer current;
        for (Integer integer : list) {
            if ((current = map.get(integer)) != null) {
                map.put(integer, ++current);
            } else {
                map.put(integer, 0);
            }
        }
        return map.values().stream().mapToInt(f -> f).sum();
    }

    public static Integer search4(List<Integer> list) {
        int s1 = list.size();
        int s2 = new HashSet<>(list).size();
        return s1 - s2;
    }
}

class Main2 {
    public static void main(String[] args) {
        int[] sd = new int[10];
        sd[0] = 1;
        sd[1] = 2;
        try {
            System.out.println(sd[100]);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        for (; ; ) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-");
        }
    }
}

class Main3 {
    public static void main(String[] args) {
        ExecutorService es1 = Executors.newCachedThreadPool();
        ExecutorService es2 = Executors.newFixedThreadPool(1);
        final Semaphore semaphore = new Semaphore(4);
        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingDeque<>(10);
        ExecutorService es = new ThreadPoolExecutor(1, 10, 100L, TimeUnit.SECONDS, blockingQueue);
        es.submit(() -> System.out.println("--"));
    }
}


