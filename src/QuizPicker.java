import java.util.LinkedHashMap;

public class QuizPicker {
	/**
	 * Quizzes to pick from, the key is the name of the quiz and the value is the quiz
	 */
	LinkedHashMap<String, Quiz> quizzes = new LinkedHashMap<>();

	/**
	 * Adds a quiz to the list of quizzes
	 * @param quiz Quiz to add
	 */
	public void addQuiz(String name, Quiz quiz) {
		quizzes.put(name, quiz);
	}

	/**
	 * Asks the user to select a quiz and then asks the questions, loops until the user doesn't want to take another quiz
	 */
	public void picker() {
		boolean stop = false;		
		while (!stop) {
			// Print quizzes
			Color.colorPrintln(Color.PURPLE, "Please select a quiz:");
			int i = 0;
			for (String name : quizzes.keySet()) {
				i++;
				Color.colorPrintln(Color.BLACK, i + ") " + name);
			}
			System.out.println();

			// Get quiz
			int quizIndex = 0;
            boolean firstTime = true;
            while (quizIndex < 1 || quizIndex > quizzes.keySet().size()) {
                if (!firstTime) Color.colorPrintln(Color.RED, "Invalid quiz!, pick a number between " + 1 + " and " + quizzes.keySet().size() + ".");
                firstTime = false;

                Color.colorPrint(Color.PURPLE, "Enter which quiz: ");
                try {
                    quizIndex = Integer.parseInt(Main.scanner.nextLine());
                } catch (Exception e) {
                    quizIndex = 0;
                }
            }

			// Ask quiz
			String name = (String) quizzes.keySet().toArray()[quizIndex - 1];
			Quiz quiz = quizzes.get(name);
			quiz.askQuestions();

			// Print response
			Color.colorPrintln(Color.CYAN, quiz.getResponse());
			System.out.println();

			// Ask if they want to take another quiz
			Color.colorPrintln(Color.BLACK, "Do you want to take another quiz? (y/n)");
			String answer = Main.scanner.nextLine();
			if (!answer.equals("y")) {
				stop = true;
			}
		}
	}
}
