package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadabilityScoreApp {

    public void runApp(File file) {
        String input = fileToStringReader(file);
        int words = input.split(" ").length;
        int sentences = input.split("[.?!]\\s*").length;
        int characters = input.replace(" ", "").length() - 1;
        int syllables = syllables(input);
        int polysyllables = polysyllables(input);

        System.out.printf("""
                Words: %d\s
                Sentences: %d\s
                Characters: %d\s
                Syllables: %d \s
                Polysyllables: %d\s
                """, words, sentences, characters, syllables, polysyllables);

        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all):");

        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.next();
        Grade grade = new Grade(userChoice, words, sentences, characters, syllables, polysyllables);
        scanner.close();

    }

    private String fileToStringReader(File file) {
        StringBuilder inputBuilder = new StringBuilder();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                inputBuilder.append(sc.nextLine()).append("\n");
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error! Doesn't find required file");
        }
        return inputBuilder.toString();
    }

    private int syllables(String inputText) {
        String[] wordsArray = inputText.split("[,.?!]*\\s");
        String regex = "[aeiouy][^aeiouy\\s]|[aiouy]$";
        int syllablesCounter = 0;

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher;

        for (String s : wordsArray) {
            matcher = pattern.matcher(s);
            int tempCounter = 0;

            while (matcher.find()) {
                tempCounter++;
            }
            if (tempCounter == 0) {
                tempCounter = 1;
            }
            syllablesCounter += tempCounter;
        }
        return syllablesCounter;
    }

    private static int polysyllables(String inputText) {
        String[] wordsArray = inputText.split("[\\s,.?!]");
        String regex = "[aeiouy][^aeiouy]|[aiouy]$";
        int polysyllablesCounter = 0;
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher;

        for (String s : wordsArray) {
            matcher = pattern.matcher(s);
            int occursSyllable = 0;

            while (matcher.find()) {
                occursSyllable++;
            }
            if (occursSyllable > 2) {
                polysyllablesCounter++;
            }
        }
        return polysyllablesCounter;
    }
}
