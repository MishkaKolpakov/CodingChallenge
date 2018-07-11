package com.ss.testtask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordCountService {
    private File file;
    private static final int ONE = 1;

    public WordCountService(String fileName){
        file = new File(fileName);
    }

    public Map<String, Integer> getWordAmountMapFromFile(){
        Map<String, Integer> wordsAmountMap = new HashMap<>();
        try (Scanner scanner = new Scanner(new FileInputStream(file))){
            while (scanner.hasNext()){
                String word = scanner.next();
                if(!wordsAmountMap.containsKey(word)){
                    wordsAmountMap.put(word, ONE);
                } else {
                    int currentAmount = wordsAmountMap.get(word);
                    wordsAmountMap.put(word, ++currentAmount);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return wordsAmountMap;
    }

    public Map<String, Integer> filterMapByValueHigherTheOne(Map<String, Integer> wordsAmountMap){
        Map<String, Integer> result = wordsAmountMap.entrySet().stream()
                .filter(entry -> entry.getValue() > ONE)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return result;
    }

    public void displayMap(Map<String, Integer> result){
        result.forEach((key, value) -> {
            System.out.println(value + " " + key);
        });
    }
}
