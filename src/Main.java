import java.util.Arrays;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        // Initialize quiz
        Quiz quiz = new Quiz(new LinkedHashMap<String, Integer>() {{
            put("You're a connoisseur of the finer things!", 80);
            put("You're a born and bred traditionalist!", 60);
            put("You're an eclectic mix of tastes!", 40);
            put("You're a classic person!", 20);
            put("You're an adventurous soul!", 0);
        }});

        // Questions
        quiz.askQuestion("What is your favorite food?", Arrays.asList("Pizza", "Sushi", "Burgers", "Tacos"), Arrays.asList(10, 8, 6, 4));
        quiz.askQuestion("What is your favorite color?", Arrays.asList("Blue", "Green", "Yellow", "Red"), Arrays.asList(7, 5, 3, 1));
        quiz.askQuestion("What is your favorite type of music?", Arrays.asList("Rock", "Country", "Jazz", "Pop"), Arrays.asList(6, 5, 4, 3));
        quiz.askQuestion("What is your favorite animal?", Arrays.asList("Cat", "Dog", "Rabbit", "Horse"), Arrays.asList(9, 8, 7, 6));
        quiz.askQuestion("What is your favorite sport?", Arrays.asList("Football", "Basketball", "Soccer", "Baseball"), Arrays.asList(8, 7, 6, 5));
        quiz.askQuestion("What is your favorite type of movie?", Arrays.asList("Romance", "Comedy", "Action", "Drama"), Arrays.asList(7, 6, 5, 4));
        quiz.askQuestion("What is your favorite type of TV show?", Arrays.asList("Reality", "Game Show", "Sitcom", "Crime"), Arrays.asList(6, 5, 4, 3));
        quiz.askQuestion("What is your favorite type of cuisine?", Arrays.asList("Italian", "Chinese", "Mexican", "Indian"), Arrays.asList(7, 6, 5, 4));
        quiz.askQuestion("What is your favorite type of dessert?", Arrays.asList("Ice Cream", "Cheesecake", "Brownie", "Pie"), Arrays.asList(8, 7, 6, 5));
        quiz.askQuestion("What is your favorite type of vacation?", Arrays.asList("Beach", "City", "Mountain", "Cruise"), Arrays.asList(10, 9, 8, 7));
        
        // Get the score of the quiz
        String response = quiz.getResponse();

        System.out.println();
        Color.colorPrintln(Color.CYAN, response);
    }
}
