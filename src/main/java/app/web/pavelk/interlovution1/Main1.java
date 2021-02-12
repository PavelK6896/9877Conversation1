package app.web.pavelk.interlovution1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main1 {
    public static void main(String[] args) throws IOException {
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
        listUser.forEach(System.out::println);
        listUser.sort(Comparator.comparing(User::getAge, Comparator.nullsLast(Comparator.naturalOrder())));
        System.out.println("--");
        listUser.forEach(System.out::println);
    }
}

class Main2 {
    public static void main(String[] args) {
        //ребасе
        //мердже
        //создать базу построить индексы


    }
}

class Main3 {
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

class Main4 {
    public static void main(String[] args) {
        main(new String[]{});
    }
}

class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("user.txt"));
        int userSize = 0;
        List<String> list = new ArrayList<>();
        List<User> listUser = new ArrayList<>();
        String string;
        while ((string = bufferedReader.readLine()) != null) {
            list.add(string);
            userSize++;
            if (userSize == 5) {
                listUser.add(new User(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4)));
                list = new ArrayList<>();
                userSize = 0;
            }
        }
        listUser.forEach(System.out::println);
        listUser.sort(Comparator.comparing(User::getAge, Comparator.nullsLast(Comparator.naturalOrder())).reversed());
        System.out.println("--");
        listUser.forEach(System.out::println);
    }
}

class Main6 {
    public static void main(String[] args) {
        System.out.println("-----------");
    }
}

class Main7 {
    public static void main(String[] args) {
        System.out.println("-----------------------------");
    }
}



