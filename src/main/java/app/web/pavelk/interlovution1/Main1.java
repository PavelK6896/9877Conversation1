package app.web.pavelk.interlovution1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class Main1 {
    public static void main(String[] args) throws IOException {
        long time1 = System.currentTimeMillis();
        List<String> list = Files.readAllLines(Paths.get("user.txt"), StandardCharsets.UTF_8);
        List<User> listUser = new ArrayList<>();
        int size = list.size() - list.size() % 5;
        for (int indexUser = 0; indexUser < size; indexUser += 5) {
            listUser.add(new User(list.get(indexUser), list.get(indexUser + 1),
                    list.get(indexUser + 2), list.get(indexUser + 3),
                    list.get(indexUser + 4)));
        }
        System.out.println(System.currentTimeMillis() - time1);

        listUser.forEach(System.out::println);
        listUser.sort(Comparator.comparing(User::getAge, Comparator.nullsLast(Comparator.naturalOrder())));
        System.out.println("--");
        listUser.forEach(System.out::println);
        Comparator<User> compareById = (User o1, User o2) -> o1.getFirstName().compareTo(o2.getFirstName());
        compareById.reversed();
        Collections.sort(listUser, compareById);
        System.out.println("--");
        listUser.forEach(System.out::println);
    }
}

class Main2 {
    public static void main(String[] args) throws IOException {
        long time1 = System.currentTimeMillis();
        List<String> data = new ArrayList<>();
        List<User> listUser = new ArrayList<>();
        AtomicInteger count = new AtomicInteger();
        Files.lines(Paths.get("user.txt")).sequential().forEach(f -> {
            data.add(f);
            if (count.incrementAndGet() == 5) {
                listUser.add(new User(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4)));
                count.set(0);
                data.clear();
            }
        });
        System.out.println(System.currentTimeMillis() - time1);

        listUser.forEach(System.out::println);
        System.out.println("--");
        listUser.sort(Comparator.comparing(User::getAge, Comparator.nullsLast(Comparator.naturalOrder())));
        listUser.forEach(System.out::println);

    }
}

class Main3 {
    public static void main(String[] args) throws IOException {
        long time1 = System.currentTimeMillis();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("user.txt"));
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
        System.out.println(System.currentTimeMillis() - time1);
        listUser.forEach(System.out::println);
        listUser.sort(Comparator.comparing(User::getAge, Comparator.nullsLast(Comparator.naturalOrder())).reversed());
        System.out.println("--");
        listUser.forEach(System.out::println);
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
        long time1 = System.currentTimeMillis();
        List<String> list = Files.readAllLines(Paths.get("user.txt"), StandardCharsets.UTF_8);
        List<User> listUser = new ArrayList<>();
        int count = (list.size() / 5);
        int beginNewUser = 0;
        for (int indexUser = 0; indexUser < count; indexUser++) {
            listUser.add(new User(list.get(indexUser + beginNewUser), list.get(indexUser + beginNewUser + 1),
                    list.get(indexUser + beginNewUser + 2), list.get(indexUser + beginNewUser + 3),
                    list.get(indexUser + beginNewUser + 4)));
            beginNewUser += 4;
        }
        System.out.println(System.currentTimeMillis() - time1);

        listUser.forEach(System.out::println);
        listUser.sort(Comparator.comparing(User::getAge, Comparator.nullsLast(Comparator.naturalOrder())));
        System.out.println("--");
        listUser.forEach(System.out::println);
        Comparator<User> compareById = (User o1, User o2) -> o1.getFirstName().compareTo(o2.getFirstName());
        compareById.reversed();
        Collections.sort(listUser, compareById);
        System.out.println("--");
        listUser.forEach(System.out::println);
    }
}

class Main6 {
    public static void main(String[] args) throws IOException {
        List<String> data = new ArrayList<>();
        List<User> listUser = new ArrayList<>();
        AtomicInteger count = new AtomicInteger();
        Files.lines(Paths.get("user.txt")).sequential().forEach(f -> {
            data.add(f);
            if (count.incrementAndGet() == 5) {
                listUser.add(new User(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4)));
                count.set(0);
                data.clear();
            }
        });

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

