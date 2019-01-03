import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static ArrayList<Integer> pastIndices = new ArrayList<>();
    public static card[] flashCards (String textfile) {
        String[] termWithDef = textfile.split("\n");                                                                  //https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
        String[] onlyTerm = new String[termWithDef.length];
        String[] onlyDef = new String[termWithDef.length];
        for (int i = 0; i < onlyTerm.length; i++) {
            onlyTerm[i] = termWithDef[i].split(": ")[0];
        }
        for (int i = 0; i < onlyDef.length; i++) {
            onlyDef[i] = termWithDef[i].split(": ")[1];
        }
        card[] flashCards = new card[termWithDef.length];
        for (int i = 0; i < termWithDef.length; i++) {
            flashCards[i] = new card(onlyTerm[i], onlyDef[i]);
        }
        return flashCards;
    }

    public static void main(String[] args) {
        String textfile = "";
        Scanner scanner;
        try {
            FileInputStream text = new FileInputStream(new File("NAME OF FILE HERE"));                                  //Enter name of textfile including the filetype ending (i.e .txt), it should be located in the same directory as this project.
            scanner = new Scanner(text);
            while (scanner.hasNextLine()) {
                textfile += scanner.nextLine();
                textfile += "\n";
            }
        } catch (Exception e) {
            throw new RuntimeException("Not Found");
        }
        card[] flashCards = flashCards(textfile);
        card Question;

        for (int i = 0; i < flashCards.length; i++) {
            int index = (int)(Math.random() * (flashCards.length));
            while (pastIndices.contains(index)) {
                index = (int)(Math.random() * (flashCards.length));
            }
            Question = flashCards[index];
            question firstQ = new question(Question, flashCards);
            System.out.println("What is the definition of " + Question.getTerm() + ":");
            firstQ.createChoices();
            System.out.print("Enter your answer choice: ");
            scanner = new Scanner(System.in);
            String choice = scanner.next();
            if (choice.toLowerCase().equals(Question.getAnswer())) {
                System.out.println("You are correct");
            } else {
                System.out.println("You are incorrect, the correct answer was: " + Question.getAnswer());
            }
            System.out.println("");
            pastIndices.add(index);
        }



    }
}
