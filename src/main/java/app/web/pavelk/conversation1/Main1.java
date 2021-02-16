package app.web.pavelk.conversation1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

class Main1 {
    public static void main(String[] args) throws IOException {
        long time1 = System.nanoTime();
        List<String> list = Files.readAllLines(Paths.get("user.txt"), StandardCharsets.UTF_8);
        List<User> listUser = new ArrayList<>();
        int size = list.size() - list.size() % 5;
        int count = list.size() / 5;
        int current = 1;
        for (int indexUser = 0; indexUser < size; indexUser += 5) {
            listUser.add(new User(list.get(indexUser), list.get(indexUser + 1),
                    list.get(indexUser + 2), list.get(indexUser + 3),
                    list.get(indexUser + 4)));
            System.out.println("current " + current + " all " + count + " " + (100.0 / count ) * current  + " %");
            current++;
        }
        System.out.println("1 " + (System.nanoTime() - time1) / 1_000_000.0);
        listUser.forEach(System.out::println);
        listUser.sort(Comparator.comparing(User::getAge, Comparator.nullsLast(Comparator.naturalOrder())));
        System.out.println("--");
        listUser.forEach(System.out::println);
        Comparator<User> compareByFirstName = Comparator.comparing(User::getFirstName);
        Collections.sort(listUser, compareByFirstName.reversed());
        System.out.println("--");
        listUser.forEach(System.out::println);
    }
}

class Main2 {
    public static void main(String[] args) throws IOException {
        long time1 = System.nanoTime();
        List<String> data = new ArrayList<>();
        List<User> listUser = new ArrayList<>();
        AtomicInteger count = new AtomicInteger();
        Stream<String> sequential = Files.lines(Paths.get("user.txt")).sequential();
        sequential.forEach(f -> {
            data.add(f);
            if (count.incrementAndGet() == 5) {
                listUser.add(new User(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4)));
                count.set(0);
                data.clear();
            }
        });
        sequential.close();
        System.out.println("1 " + (System.nanoTime() - time1) / 1_000_000.0);
        listUser.forEach(System.out::println);
        System.out.println("--");
        listUser.sort(Comparator.comparing(User::getAge, Comparator.nullsLast(Comparator.naturalOrder())));
        listUser.forEach(System.out::println);

    }
}

class Main3 {
    public static void main(String[] args) throws IOException {
        long time1 = System.nanoTime();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("user.txt"))) {
            int userSize = 0;
            List<String> list = new ArrayList<>();
            List<User> listUser = new ArrayList<>();
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                list.add(string);
                userSize++;
                if (userSize == 5) {
                    User user = new User(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
                    listUser.add(user);
                    list = new ArrayList<>();
                    userSize = 0;
                }
            }
            System.out.println("1 " + (System.nanoTime() - time1) / 1_000_000.0);
            listUser.forEach(System.out::println);
            listUser.sort(Comparator.comparing(User::getAge, Comparator.nullsLast(Comparator.naturalOrder())).reversed());
            System.out.println("--");
            listUser.forEach(System.out::println);
        }
    }
}

class Main4 {
    public static void main(String[] args) throws IOException {
        List<String> list = Files.readAllLines(Paths.get("user.txt"), StandardCharsets.UTF_8);
        List<User> listUser = new ArrayList<>();
        for (int indexUser = 0; indexUser < list.size(); indexUser += 5) {
            listUser.add(new User(list.get(indexUser), list.get(indexUser + 1),
                    list.get(indexUser + 2), list.get(indexUser + 3),
                    list.get(indexUser + 4)));
        }

        listUser.forEach(System.out::println);
        listUser.sort(Comparator.comparing(User::getAge, Comparator.nullsLast(Comparator.naturalOrder())).reversed());
        System.out.println("--");
        listUser.forEach(System.out::println);
    }
}

class Main5 {
    public static void main(String[] args) throws IOException {
        long time1 = System.nanoTime();
        List<String> list = Files.readAllLines(Paths.get("user.txt"), StandardCharsets.UTF_8);
        List<User> listUser = new ArrayList<>();
        int count = (list.size() / 5);
        int beginNewUser = 0;
        for (int indexUser = 0; indexUser < count; indexUser++) {
            listUser.add(new User(list.get(indexUser + beginNewUser), list.get(indexUser + beginNewUser + 1),
                    list.get(indexUser + beginNewUser + 2), list.get(indexUser + beginNewUser + 3),
                    list.get(indexUser + beginNewUser + 4)));
            System.out.println("current " + (indexUser + 1) + " all " + count + " " + (100.0 / count ) * (indexUser + 1)  + " %" );
            beginNewUser += 4;
        }
        System.out.println("1 " + (System.nanoTime() - time1) / 1_000_000.0);
        listUser.forEach(System.out::println);
        listUser.sort(Comparator.comparing(User::getAge, Comparator.nullsLast(Comparator.naturalOrder())));
        System.out.println("--");
        listUser.forEach(System.out::println);
        Comparator<User> sort1 = Comparator.comparing(User::getAge,Comparator.nullsFirst(Comparator.naturalOrder()));
        Collections.sort(listUser, sort1.reversed());
        System.out.println("--");
        listUser.forEach(System.out::println);
    }
}

class Main6 {
    public static void main(String[] args) throws IOException {
        List<String> data = new ArrayList<>();
        List<User> listUser = new ArrayList<>();
        AtomicInteger count = new AtomicInteger();
        Stream<String> sequential = Files.lines(Paths.get("user.txt")).sequential();
        sequential.forEach(f -> {
            data.add(f);
            if (count.incrementAndGet() == 5) {
                listUser.add(new User(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4)));
                count.set(0);
                data.clear();
            }
        });
        sequential.close();

        Map<User, Integer> map = new HashMap<>();
        Map<User, User> map2 = new HashMap<>();

        listUser.forEach(f -> {
            map.put(f, 1);
            map2.put(f, f);
        });

        System.out.println("--");
        map.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println("--");
        map2.forEach((k, v) -> System.out.println(k + " " + v));
    }
}

class Main7 {
    public static void main(String[] args) {
        main(new String[]{});
    }
}

class Main8 {
    public static void main(String[] args) {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


class Main9 {
    public static void main(String[] args) throws IOException {
        long time1 = System.nanoTime();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("user.txt"), StandardCharsets.UTF_8)) {
            List<User> listUser = new ArrayList<>();
            List<String> list = new ArrayList<>();
            String string;
            int userSize = 0;
            while ((string = bufferedReader.readLine()) != null) {
                list.add(string);
                userSize++;
                if (userSize == 5) {
                    User user = new User(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
                    listUser.add(user);
                    list = new ArrayList<>();
                    userSize = 0;
                }
            }
            System.out.println("1 " + (System.nanoTime() - time1) / 1_000_000.0);
            listUser.forEach(System.out::println);
            listUser.sort(Comparator.comparing(User::getAge, Comparator.nullsLast(Comparator.naturalOrder())));
            System.out.println("--");
            listUser.forEach(System.out::println);
            Comparator<User> compareByFirstName = Comparator.comparing(User::getFirstName);
            Collections.sort(listUser, compareByFirstName.reversed());
            System.out.println("--");
            listUser.forEach(System.out::println);
        }
    }
}

