package com.nikhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TestMain {

    public static void main(String[] args) {
//        List<String> strList = new ArrayList<>(List.of(
//
//        ));


//        Stream.of("John","marY")
//                .filter
//                .ma

        Object[] arr = {"John","MayA","Mary"," ","Anne","d","Anne","michael",null,"Anthony","Maya","mary",
        "john"};

        Stream.of(arr)
                .filter(i -> i!=null && !i.toString().trim().isEmpty())
                .map(str -> str.toString().substring(0,1).toUpperCase()+str.toString().substring(1).toLowerCase())
                .distinct()
                .sorted()


                .forEach(System.out::println);


        List<Integer> list= Arrays.asList(Integer.valueOf("1"),Integer.valueOf("2"),Integer.valueOf("3"),Integer.valueOf("4"));
        Stream s= list.stream();
        long i1= s.count();
//        long i2= s.count();

        System.out.println(i1); // 4
//        System.out.println(i2); //


        List<String> testList = new ArrayList<>(List.of(
                "Nikhil",
                "Abc",
                "Kavita"
        ));

        String strToBeRemoved = "Abc";

        testList.stream()
                .flatMap(str -> str.equals(strToBeRemoved) ? Stream.empty() : Stream.of(str))
//                {
//                    str.equals(strToBeRemoved)) {
//                        return Stream.empty();
//                    }
//                    return Stream.of(str);

//                    return str.equals(strToBeRemoved) ? Stream.empty() : Stream.of(str);
//                })
                .forEach(System.out::println);


        String str = "";

    }
}
