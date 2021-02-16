package app.web.pavelk.conversation2;

import java.util.*;
import java.util.concurrent.*;

class Main1 {
    public static void main(String[] args) {
//        List<Integer> integers = Arrays.asList(1, 4, 4, 4, 1, 3, 2, 4);
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 5555; i++) {
            integers.add(ThreadLocalRandom.current().nextInt(10,20));
        }

        //количество переменыйх которые дублируються
        long time1 = System.nanoTime();
        System.out.println(search1(integers));
        long time2 = System.nanoTime();
        System.out.println(search2(integers));
        long time3 = System.nanoTime();
        //количество дубликатов
        System.out.println(search3(integers));
        long time4 = System.nanoTime();
        System.out.println(search4(integers));
        long time5 = System.nanoTime();

        System.out.println("1 " + (time2 - time1) / 1_000_000.0);
        System.out.println("2 " + (time3 - time2) / 1_000_000.0);
        System.out.println("3 " + (time4 - time3) / 1_000_000.0);
        System.out.println("4 " + (time5 - time4) / 1_000_000.0);
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


class Main4 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es2 = Executors.newFixedThreadPool(1);
        Future<?> submit = es2.submit(() -> System.out.println("--"));
        submit.get();
        for (int i = 0; i < 2; i++) {
            TimeUnit.SECONDS.sleep(1);
            es2.submit(() -> System.out.println(Thread.currentThread().getName()));
        }
        for (int i = 0; i < 2; i++) {
            TimeUnit.SECONDS.sleep(1);
            CompletableFuture.runAsync(() -> System.out.println(Thread.currentThread().getName()));
        }

    }
}


class Main5 {
    public static void main(String[] args) {
        CompletableFuture<String> completableFuture1 = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture1.complete("Hello 1 -- " + Thread.currentThread().getName());
            throw new CompletionException(new Exception());
        });

        System.out.println(completableFuture1.join());

        try {
            System.out.println(completableFuture1.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello 2 -- " + Thread.currentThread().getName());
            return null;
        });
        completableFuture2.join();
        try {
            completableFuture2.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingDeque<>(1);
        ExecutorService es = new ThreadPoolExecutor(1, 10, 100L, TimeUnit.SECONDS, blockingQueue);

        CompletableFuture<String> completableFuture3 = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello 3 -- " + Thread.currentThread().getName());
            throw new CompletionException(new Exception());
//            return "Hello";
        }, es);

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (completableFuture3.isDone()) {
                try {
                    System.out.println(i + completableFuture3.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

        }

        ExecutorService es2 = Executors.newFixedThreadPool(1);
        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello 4 -- " + Thread.currentThread().getName());

        }, es2);

    }
}
