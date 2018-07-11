package com.ss.testtask;

import java.util.Map;

public class App {

    public static void main(String[] args) {
        WordCountService wordCountService = new WordCountService("text-to-count.txt");

        Map<String, Integer> wordsAmountMap = wordCountService.getWordAmountMapFromFile();
        Map<String, Integer> result = wordCountService.filterMapByValueHigherTheOne(wordsAmountMap);

        wordCountService.displayMap(result);
    }
}
