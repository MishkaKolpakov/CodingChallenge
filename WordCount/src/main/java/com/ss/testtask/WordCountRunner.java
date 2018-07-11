package com.ss.testtask;

import com.ss.testtask.service.WordCountService;

import java.util.Map;

public class WordCountRunner {

    public static void main(String[] args) {
        WordCountService wordCountService = new WordCountService("text-to-count.txt");

        Map<String, Integer> wordsAmountMap = wordCountService.getWordAmountMapFromFile();
        Map<String, Integer> unsortedResult = wordCountService.filterMapByValueHigherTheOne(wordsAmountMap);
        Map<String, Integer> sortedResult = wordCountService.sort(unsortedResult);

        wordCountService.displayMap(sortedResult);
    }
}
