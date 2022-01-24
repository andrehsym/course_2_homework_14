package pro.sky.java.homeworks.course2;

import java.util.Arrays;
import java.util.List;

public class Main {

    private static StringList c = new StringListImpl(15);

    private static StringList r = new StringListImpl(10);

    public static void main(String[] args) {
        c.add("aaa");
        c.add("bbb");
        c.add("ccc");
        c.add("ddd");
        c.add("eee");
        c.add("fff");
        c.add("ggg");
//        c.add(7, "free");
//        c.set(8, "lol");
//        c.set(2, "wow");
//        c.set(2, "blob");
//        System.out.println("Свободных ячеек: " + c.getCountOfFreeCells());
//        c.remove("lol");
//        c.remove(2);
        c.contains("aaa");
        c.indexOf("ddd");
        c.lastIndexOf("ggg");
        c.get(3);
        System.out.println(c.size());
        System.out.println(c.isEmpty());
//        c.clear();
        System.out.println(c.isEmpty());

        System.out.println(Arrays.toString(c.toArray()));

//        c.remove("QQQQ");
//        c.set(100, "xxx");
    }
}
