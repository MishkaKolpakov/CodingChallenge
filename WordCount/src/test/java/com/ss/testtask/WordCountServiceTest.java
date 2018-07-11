package com.ss.testtask;

import com.ss.testtask.service.WordCountService;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class WordCountServiceTest {
    private WordCountService wordCountService;

    @Before
    public void init() {
        wordCountService = new WordCountService("text-to-count.txt");
    }

    @Test
    public void checkAmountOfButWord() {
        String no = "no";
        Map<String, Integer> actualMap = wordCountService.getWordAmountMapFromFile();
        int expected = 2;
        int actual = actualMap.get(no);

        assertEquals(expected, actual);
    }
}
