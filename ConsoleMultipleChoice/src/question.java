import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class question {
    private String[] letters = {"a", "b", "c", "d"};
    private card correctAnswer;
    private card[] questionBank;

    private int[] uniqueIndices (int indextoAvoid) {
        int[] emptyarr = new int[4];
        for (int i = 0; i < 3; i++) {
            emptyarr[i] = (int)(Math.random()*questionBank.length);
            if (emptyarr[i] == indextoAvoid) {
                i--;
            }
            for (int j = 0; j < i; j++) {
                if (emptyarr[i] == emptyarr[j] || emptyarr[i] == indextoAvoid) {
                    i--;
                    break;
                }
            }
        }
        emptyarr[3] = indextoAvoid;
        return emptyarr;
    }
    private int[] shuffledIndices (int[] unshuffled) {
        List<Integer> randomized = new ArrayList<>();
        for (int i = 0; i < unshuffled.length; i++) {
            randomized.add(unshuffled[i]);
        }
        Collections.shuffle(randomized);
        for (int i = 0; i < unshuffled.length; i++) {
            unshuffled[i] = randomized.get(i);
        }
        return unshuffled;
    }

    public question (card correctAnswer, card[] questionBank) {
        this.correctAnswer = correctAnswer;
        this.questionBank = questionBank;
    }

    public void createChoices() {
        int indexofRightanswer = 0;
        for (int i = 0; i < questionBank.length; i++) {
            if (correctAnswer.getTerm().equals(questionBank[i].getTerm())) {
                indexofRightanswer = i;
                break;
            }
        }
        int[] indexofAnswers = shuffledIndices(uniqueIndices(indexofRightanswer));
        int indexinShuffled = 0;
        for (int i = 0; i < indexofAnswers.length; i++) {
            if (indexofAnswers[i] == indexofRightanswer) {
                indexinShuffled = i;
            }
        }
        for (int i = 0; i < indexofAnswers.length; i++) {
            System.out.println("   " + letters[i] + ")" + questionBank[indexofAnswers[i]].getDefinition());
            if (i == indexinShuffled) {
                correctAnswer.setAnswer(letters[i]);
            }
        }

    }
}
