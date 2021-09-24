package ua.com.alevel.service;

import ua.com.alevel.model.FileModel;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class IONIOServiceImpl implements IONIOService {

    @Override
    public void create(FileModel fileModel) {
        File file = new File(fileModel.getName() + "." + fileModel.getFileType().getType());
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(fileModel.getContent());
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public String read(String pathToFile) {
        StringBuilder string = new StringBuilder();
        try {
            File file = new File("input.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = "";
            while (line != null) {
                line = reader.readLine();
                if (line != null && !line.isEmpty()) {
                    string.append(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string.toString();
    }

    @Override
    public String countInfo(String text) {
        String output = "input.txt contains following words:\n";
        Map<String, Integer> words = getUniqueWords(text);
        for (String key : words.keySet()) {
            output = output.concat(key + " - " + words.get(key) + "\n");
        }
        output = output.concat("\ninput.txt contains following palindromes:\n");
        HashSet<String> palindromes = getPalindrome(text);
        for (String palindrome : palindromes) {
            output = output.concat(palindrome + " - " + words.get(palindrome) + "\n");
        }
        output = output.concat("\nThe amount of sentences in input.txt is " + countSentence(text));
        System.out.println(output);
        return output;
    }

    private Map<String, Integer> getUniqueWords(String text) {
        String[] words = toWords(text);
        Set<String> uniqueWords = new HashSet<>();
        uniqueWords.addAll(Arrays.asList(words));
        Map<String, Integer> wordsAmount = new HashMap<>();
        for (String word : uniqueWords) {
            int count = 0;
            for (String w : words) {
                if (word.equals(w)) {
                    count++;
                }
            }
            wordsAmount.put(word, count);
        }
        return wordsAmount.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    private HashSet<String> getPalindrome(String text) {
        HashSet<String> palindromes = new HashSet<>();
        String[] words = toWords(text);
        for (String w : words) {
            if (w.equals(new StringBuilder(w).reverse().toString())) {
                palindromes.add(w);
            }
        }
        return palindromes;
    }

    private int countSentence(String text) {
        String[] sentences = text.split("[.?!]");
        return sentences.length;
    }

    private String[] toWords(String text) {
        return text.toLowerCase(Locale.ROOT).replaceAll("[^a-zA-Z- ]", "").split(" ");
    }
}
