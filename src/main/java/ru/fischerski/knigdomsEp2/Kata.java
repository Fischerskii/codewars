package ru.fischerski.knigdomsEp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kata {
    static String translate(String speech, String[] vocabulary) {
        String words[] = speech.split(" ");
        System.out.println("words: " + Arrays.toString(words));
        for (int i = 0; i < words.length; i++) {
            String regex = words[i].replaceAll("[?!,.]", "").replace("*", ".");
            String extra = words[i].replaceAll("[a-z*]", "");
            System.out.println("Это extra: " + extra);
            System.out.println("Это regex: " + regex);
            for (String v : vocabulary) if (v.matches(regex)) words[i] = v + extra;
        }
        List<String> list = new ArrayList<>();
        return String.join(" ", words);
    }
}