package ru.fischerski.knigdomsEp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Kata {
    static String translate(String speech, String[] vocabulary) {
        List<String> completeStringList = new ArrayList<>();
        List<List<Character>> speechList = new Kata().speechCharacterList(speech.replaceAll("[^A-Za-z* ]", ""));
        List<List<Character>> vocabularyList = new Kata().vocabularyCharacterList(vocabulary);

        String str;
        for (List<Character> characters : speechList) {
            str = vocabulary[new Kata().checkTwoWordsForMatches(characters, vocabularyList)];
            completeStringList.add(str);
        }

        StringBuilder listString = new StringBuilder();
        for (String s :
                completeStringList) {
            listString.append(s).append(" ");
        }
        String trueSpeechWithoutSymbols = listString.toString();

        if (speech.isEmpty()) {
            return "";
        } else {

            return new Kata().addCharactersToFinalLineFromSpeech(speech, trueSpeechWithoutSymbols).trim();
        }

    }

    public List<List<Character>> speechCharacterList(String speech) {
        return Arrays.stream(speech.split(" "))
                .map(wordCell -> wordCell.chars()
                        .mapToObj(symbolCell -> (char) symbolCell)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    public List<List<Character>> vocabularyCharacterList(String[] vocabulary) {
        return Arrays.stream(vocabulary)
                .map(wordCell -> wordCell.chars()
                        .mapToObj(symbolCell -> (char) symbolCell)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    private Integer checkTwoWordsForMatches(List<Character> speechLearn, List<List<Character>> vocabularyLearn) {
        List<Boolean> counterCheckingLettersCoincidence = new ArrayList<>();
        int learnNumber = 0;
        outerFlag:
        for (int vocabularyWordIteration = 0; vocabularyWordIteration < vocabularyLearn.size(); vocabularyWordIteration++) {
            counterCheckingLettersCoincidence.clear();
            for (int speechIteration = 0; speechIteration < speechLearn.size(); speechIteration++) {
                if (speechLearn.size() != vocabularyLearn.get(vocabularyWordIteration).size()) {
                    System.out.println("Длина произнесенного слова не равна длине в банке слов");
                    continue outerFlag;
                }
                if (!speechLearn.get(speechIteration).equals('*')) {
                    if (speechLearn.get(speechIteration).equals(vocabularyLearn.get(vocabularyWordIteration).get(speechIteration))) {
                        counterCheckingLettersCoincidence.add(true);
                    } else {
                        counterCheckingLettersCoincidence.add(false);
                    }
                }
            }
            if (counterCheckingLettersCoincidence.stream().allMatch(x -> x.equals(true))) {
                learnNumber = vocabularyWordIteration;
                break;
            }
        }
        return learnNumber;
    }

    private List<Character> convertStringToLettersList(String conversionPhrase) {
        return conversionPhrase.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
    }

    private String addCharactersToFinalLineFromSpeech(String speech, String compileString) {
        List<Character> speechList = convertStringToLettersList(speech);
        List<Character> compileStringList = convertStringToLettersList(compileString);

        for (int i = 0; i < speechList.size(); i++) {
            if (speechList.get(i) != '*' && speechList.get(i) != ' ' && !Character.isLetter(speechList.get(i))) {
                compileStringList.add(i, speechList.get(i));
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character s:
             compileStringList) {
            stringBuilder.append(s);
        }

        return stringBuilder.toString();
    }
}