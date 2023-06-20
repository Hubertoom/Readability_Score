package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File(args[0]);
        String input = readFileToString(file);

        int words = input.split(" ").length;
        int characters = input.replace(" ", "").length() - 1;
        int sentences = input.split("[.?!]\\s*").length;
        double score = 4.71 * ((double)characters / words) + 0.5 * ((double)words / sentences) - 21.43;
        String ageRange = ageRange(score);

        System.out.printf("""
                Words: %d\s
                Sentences: %d\s
                Characters: %d \s
                The score is: %.2f\s
                This text should be understood by %s year olds.""",words, sentences, characters, score - 0.005, ageRange);
    }

    private static String ageRange(double s) {
        int score = (int) Math.floor(s);
        if (score < 13) {
            int age1 = score + 5;
            int age2 = score + 6;
            return age1+"-"+age2;
        } else if (score == 13) {
            int age1 = score + 5;
            int age2 = 24;
            return age1+"-"+age2;
        } else {
            return "24+";
        }
    }

    private static String readFileToString(File file) {
        StringBuilder text = new StringBuilder();

        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                text.append(sc.nextLine()).append("\n");
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error! Doesn't find required file");
        }
        return text.toString();
    }
}