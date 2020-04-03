package com.monday.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeekIteratorDemo {

    static class ListIteratorWrong1 {
        public static void main(String[] args) {
            List<String> names = new ArrayList<>();
            names.add("a");
            names.add("b");
            names.add("c");
            names.add("d");
            Iterator<String> iterator = names.iterator();
            String value = iterator.next();
            System.out.println(value);
            names.remove("a");
            iterator.next();//抛出ConcurrentModificationException异常  }
        }
    }

    static class ListIteratorWrong2 {

        public static void main(String[] args) {
            List<String> names = new ArrayList<>();
            names.add("a");
            names.add("b");
            names.add("c");
            names.add("d");

            Iterator<String> iterator = names.iterator();
            iterator.next();
            iterator.remove();
            iterator.remove(); //报错，抛出IllegalStateException异常
        }
    }


    static class ListIteratorWrong3 {
        public static void main(String[] args) {
            List<String> names = new ArrayList<>();
            names.add("a");
            names.add("b");
            names.add("c");
            names.add("d");

            Iterator<String> iterator1 = names.iterator();
            Iterator<String> iterator2 = names.iterator();
            iterator1.next();
            iterator1.remove();
            iterator2.next(); // 运行结果？
        }
    }
}
