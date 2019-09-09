package com.hillel.web;

import java.util.*;

public class Text {

    public  String text = "Some say the world will end in fire\n" +
            "Some say in ice\n" +
            "From what I’ve tasted of desire\n" +
            "I hold with those who favor fire\n" +
            "But if it had to perish twice\n" +
            "I think I know enough of hate\n" +
            "To say that for destruction ice\n" +
            "Is also great and would suffice";

    public List<String> splitTextToWords(String text) {
        return new ArrayList<>(Arrays.asList(text.split("\\W+")));
    }

    public Map<String, Integer> toMap(List<String> words) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }
}
