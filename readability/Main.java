package readability;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double numberOfWords = input.split("\\s").length;
        double numberOfSentences = input.split("[.?!]").length;

        System.out.println(numberOfWords / numberOfSentences > 10 ? "HARD" : "EASY");
    }
}