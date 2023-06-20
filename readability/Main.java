package readability;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File("in.txt");

        new ReadabilityScoreApp().runApp(file);
    }
}