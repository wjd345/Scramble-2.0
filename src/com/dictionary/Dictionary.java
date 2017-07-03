package com.dictionary;
/**
 * File Name: Dictionary.java
 * Description: Dictionary class that reads through a text file, reads in the file,
 * and determines if the word is within the String set. Class and word file were taken
 * from online research in implementation for this project. See below
 * @see: http://stackoverflow.com/questions/11607270/how-to-check-whether-given-string-is-a-word
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Dictionary
{
    private Set<String> wordsSet;

    public Dictionary() throws IOException
    {
        Path path = Paths.get("words.txt");
        byte[] readBytes = Files.readAllBytes(path);
        String wordListContents = new String(readBytes, "UTF-8");
        String[] words = wordListContents.split("\n");
        wordsSet = new HashSet<>();
        Collections.addAll(wordsSet, words);
    }

    public boolean contains(String word)
    {
        return wordsSet.contains(word);
    }
}