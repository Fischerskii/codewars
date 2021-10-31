package ru.fischerski.knigdomsEp2;

public class Kata {
    static String translate(String speech, String[] vocabulary) {
        String words[] = speech.split(" ");
        for (int i = 0; i < words.length; i++) {
            String regex = words[i].replaceAll("[?!,.]", "").replace("*", ".");
            String extra = words[i].replaceAll("[a-z*]", "");
            for (String v : vocabulary) if (v.matches(regex)) words[i] = v + extra;
        }
        return String.join(" ", words);
    }
}