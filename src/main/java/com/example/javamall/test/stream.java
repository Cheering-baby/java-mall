package com.example.javamall.test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class stream {
    public static void main(String[] args) {
//        generateStream();
//        forEach();
//        sort();
        filter();
    }

    public static void generateStream() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "jk");
        List<String> filters = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        for(String filter: filters) {
            System.out.println(filter);
        }
    }

    public static void forEach() {
        Random random = new Random();
        System.out.println(random);
        random.ints().limit(10).forEach(System.out:: println);
    }

    public static void sort() {
        Random random = new Random();
        System.out.println(random);
        random.ints().limit(10).sorted().forEach(System.out:: println);
    }

    public static void filter() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "jk");
        List<String> filters = strings.stream().filter(string -> string.length() > 2).collect(Collectors.toList());
        for(String filter: filters) {
            System.out.println(filter);
        }
    }
}
