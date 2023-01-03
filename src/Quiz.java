import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class Quiz {
    /**
     * Questions of the quiz, each question corresponds to answers and scores
     */
    ArrayList<String> questions;
    /**
     * Answers to the questions, the index of the answer is the index of the question
     */
    ArrayList<ArrayList<String>> answers;
    /**
     * Scores of the quiz, the index of the score is the index of the question
     */
    ArrayList<ArrayList<Integer>> scores;
    /**
     * Final scores of the quiz, the index of the score is the index of the question
     */
    ArrayList<Integer> finalScores;
    /**
     * Responses for the quiz, the key is the response and the value is the minimum score to get that response. !Responses should be in descending order!
     */
    LinkedHashMap<String, Integer> responses;

    /**
     * Creates a new quiz
     * @param responses Responses for the quiz. !Responses should be in descending order!
     */
    public Quiz(LinkedHashMap<String, Integer> responses) {
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.scores = new ArrayList<>();
        this.finalScores = new ArrayList<>();
        this.responses = responses;

        // Check if the responses are in descending order
        int lastScore = Integer.MAX_VALUE;
        for (Entry<String, Integer> entry : responses.entrySet()) {
            if (entry.getValue() < lastScore) {
                lastScore = entry.getValue();
            } else {
                throw new RuntimeException("Responses are not in descending order");
            }
        }
    }

    /**
     * Adds a question to the quiz, asks it and adds the score to the final score
     * @param question Question to ask
     * @param _answers Answers to the question
     * @param _scores Scores of the answers, the index of the score is the index of the answer
     */
    public void askQuestion(String question, List<String> _answers, List<Integer> _scores) {
        ArrayList<String> answers = new ArrayList<>(_answers);
        ArrayList<Integer> scores = new ArrayList<>(_scores);

        // Add question, answers and scores to the quiz
        this.questions.add(question);
        this.answers.add(answers);
        this.scores.add(scores);

        // Print question and answers
        System.out.println();
        Color.colorPrintln(Color.BLUE, question);
        for (int i = 0; i < answers.size(); i++) {
            Color.colorPrintln(Color.YELLOW, (i + 1) + ") " + answers.get(i));
        }

        // Get answer
        int answer = 0;
        boolean firstTime = true;
        while (answer < 1 || answer > answers.size()) {
            if (!firstTime) Color.colorPrintln(Color.RED, "Invalid answer, pick a number between " + 1 + " and " + answers.size() + ".");
            firstTime = false;

            Color.colorPrint(Color.GREEN, "Enter your answer: ");
            try {
                answer = Integer.parseInt(System.console().readLine());
            } catch (Exception e) {
                answer = 0;
            }
        }

        // Calculate score and add it to the final score
        int score = scores.get(answer - 1);
        this.finalScores.add(score);
    }

    /**
     * Returns the total score of the quiz, will skip questions that don't have a score
     */
    private int getScore() {
        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            if (i >= this.finalScores.size()) continue;
            score += this.finalScores.get(i);
        }

        return score;
    }

    /**
     * Returns the response for the score
     */
    public String getResponse() {
        int score = this.getScore();
        for (Entry<String, Integer> entry : this.responses.entrySet()) {
            if (score >= entry.getValue()) return entry.getKey();
        }

        throw new RuntimeException("No response found for score " + score);
    }
}
