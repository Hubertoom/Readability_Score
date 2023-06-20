package readability;

public class Grade {
    private final int words;
    private final int sentences;
    private final int characters;
    private final int syllables;
    private final int polysyllables;

    public Grade(String userChoice, int words, int sentences, int characters, int syllables, int polysyllables) {
        this.words = words;
        this.sentences = sentences;
        this.characters = characters;
        this.syllables = syllables;
        this.polysyllables = polysyllables;

        chooseCalculate(userChoice);
    }

    public void chooseCalculate(String choice) {
        switch (choice) {
            case "ARI" -> automatedReadabilityIndex(words, sentences, characters);
            case "FK" -> fleshKincaid(words, sentences, syllables);
            case "SMOG" -> smogIndex(polysyllables, sentences);
            case "CL" -> colemanLiauIndex(characters, sentences, words);
            case "ALL" -> {
                automatedReadabilityIndex(words, sentences, characters);
                fleshKincaid(words, sentences, syllables);
                smogIndex(polysyllables, sentences);
                colemanLiauIndex(characters, sentences, words);
            }
            default -> System.out.println("Wrong command");
        }
    }

    public void automatedReadabilityIndex(double words, double sentences, double characters) {
        double scoreARI = 4.71 * (characters / words) + 0.5 * (words / sentences) - 21.43;
        System.out.printf("Automated Readability Index: %.2f (about %s year olds).\n", scoreARI, agesTable(scoreARI));
    }

    public void fleshKincaid(double words, double sentences, double syllables) {
        double scoreFK = 0.39 * words / sentences + 11.8 * syllables / words - 15.59;
        System.out.printf("Flesch–Kincaid readability tests: %.2f (about %s year olds).\n", scoreFK, agesTable(scoreFK));
    }

    public void smogIndex(double polysyllables, double sentences) {
        double smogIndexScore = 1.043 * Math.sqrt((polysyllables * 30 / sentences)) + 3.1291;
        System.out.printf("Simple Measure of Gobbledygook: %.2f (about %s year olds).\n", smogIndexScore, agesTable(smogIndexScore));
    }

    public void colemanLiauIndex(double characters, double sentences, double words) {
        double l = 100 * characters / words;
        double s = 100 * sentences / words;
        double scoreColemanLiau = 0.0588 * l - 0.296 * s - 15.8;
        System.out.printf("Coleman–Liau index: %.2f (about %s year olds).\n", scoreColemanLiau, agesTable(scoreColemanLiau));
    }

    private String agesTable(double s) {
        int score = (int)Math.round(s);
        String finding;

        if (score < 13) {
            finding = String.valueOf(score + 6);
        } else if (score == 13) {
            finding = "24";
        } else {
            finding = "24+";
        }
        return finding;
    }
}