import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class Quiz {
    /**
     * Questions of the quiz, each question corresponds to answers and scores
     */
    private ArrayList<String> questions = new ArrayList<>();
    /**
     * Answers to the questions, the index of the answer is the index of the question
     */
    private ArrayList<ArrayList<String>> answers = new ArrayList<>();
    /**
     * Scores of the quiz, the index of the score is the index of the question
     */
    private ArrayList<ArrayList<Integer>> scores = new ArrayList<>();
    /**
     * Final scores of the quiz, the index of the score is the index of the question
     */
    private ArrayList<Integer> finalScores = new ArrayList<>();
    /**
     * Responses for the quiz, the key is the response and the value is the minimum score to get that response. !Responses should be in descending order!
     */
    private LinkedHashMap<String, Integer> responses = new LinkedHashMap<>();

    /**
     * Sets the responses for the quiz. !Responses should be in descending order!
     * @param responses Responses for the quiz, the key is the response and the value is the minimum score to get that response
     */
    public void setResponses(LinkedHashMap<String, Integer> responses) {
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
     * Adds a question to the quiz
     * @param question Question to ask
     * @param answers Answers to the question
     * @param scores Scores of the answers, the index of the score is the index of the answer
     */
    public void addQuestion(String question, List<String> answers, List<Integer> scores) {
        this.questions.add(question);
        this.answers.add(new ArrayList<>(answers));
        this.scores.add(new ArrayList<>(scores));
    }

    /**
     * Asks the questions and stores the scores
     */
    public void askQuestions() {
        for (int x = 0; x < questions.size(); x++) {
            String question = questions.get(x);
            ArrayList<String> answers = this.answers.get(x);
            ArrayList<Integer> scores = this.scores.get(x);

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
                    answer = Integer.parseInt(Main.scanner.nextLine());
                } catch (Exception e) {
                    answer = 0;
                }
            }

            // Calculate score and add it to the final score
            int score = scores.get(answer - 1);
            this.finalScores.add(score);
        }
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
