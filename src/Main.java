import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    /**
     * Scanner for user input
     */
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Personality quiz
        Quiz personalityQuiz = new Quiz();
        personalityQuiz.setResponses(new LinkedHashMap<String, Integer>() {{
            put("You're a connoisseur of the finer things!", 80);
            put("You're a born and bred traditionalist!", 60);
            put("You're an eclectic mix of tastes!", 40);
            put("You're a classic person!", 20);
            put("You're an adventurous soul!", 0);
        }});
        personalityQuiz.addQuestion("What is your favorite food?", Arrays.asList("Pizza", "Sushi", "Burgers", "Tacos"), Arrays.asList(10, 8, 6, 4));
        personalityQuiz.addQuestion("What is your favorite color?", Arrays.asList("Blue", "Green", "Yellow", "Red"), Arrays.asList(7, 5, 3, 1));
        personalityQuiz.addQuestion("What is your favorite type of music?", Arrays.asList("Rock", "Country", "Jazz", "Pop"), Arrays.asList(6, 5, 4, 3));
        personalityQuiz.addQuestion("What is your favorite animal?", Arrays.asList("Cat", "Dog", "Rabbit", "Horse"), Arrays.asList(9, 8, 7, 6));
        personalityQuiz.addQuestion("What is your favorite sport?", Arrays.asList("Football", "Basketball", "Soccer", "Baseball"), Arrays.asList(8, 7, 6, 5));
        personalityQuiz.addQuestion("What is your favorite type of movie?", Arrays.asList("Romance", "Comedy", "Action", "Drama"), Arrays.asList(7, 6, 5, 4));
        personalityQuiz.addQuestion("What is your favorite type of TV show?", Arrays.asList("Reality", "Game Show", "Sitcom", "Crime"), Arrays.asList(6, 5, 4, 3));
        personalityQuiz.addQuestion("What is your favorite type of cuisine?", Arrays.asList("Italian", "Chinese", "Mexican", "Indian"), Arrays.asList(7, 6, 5, 4));
        personalityQuiz.addQuestion("What is your favorite type of dessert?", Arrays.asList("Ice Cream", "Cheesecake", "Brownie", "Pie"), Arrays.asList(8, 7, 6, 5));
        personalityQuiz.addQuestion("What is your favorite type of vacation?", Arrays.asList("Beach", "City", "Mountain", "Cruise"), Arrays.asList(10, 9, 8, 7));

        // History quiz
        Quiz historyQuiz = new Quiz();
        historyQuiz.setResponses(new LinkedHashMap<String, Integer>() {{
            put("You're a history buff!", 80);
            put("You're a history enthusiast!", 60);
            put("You're a history lover!", 40);
            put("You're a history student!", 20);
            put("You're a history novice!", 0);
        }});
        historyQuiz.addQuestion("What year did the American Revolution start?", Arrays.asList("1775", "1776", "1777", "1778"), Arrays.asList(10, 8, 6, 4));
        historyQuiz.addQuestion("What year did the American Revolution end?", Arrays.asList("1780", "1781", "1782", "1783"), Arrays.asList(7, 5, 3, 1));
        historyQuiz.addQuestion("What year did the Civil War start?", Arrays.asList("1860", "1861", "1862", "1863"), Arrays.asList(6, 5, 4, 3));
        historyQuiz.addQuestion("What year did the Civil War end?", Arrays.asList("1865", "1866", "1867", "1868"), Arrays.asList(9, 8, 7, 6));
        historyQuiz.addQuestion("What year did the World War I start?", Arrays.asList("1914", "1915", "1916", "1917"), Arrays.asList(8, 7, 6, 5));
        historyQuiz.addQuestion("What year did the World War I end?", Arrays.asList("1918", "1919", "1920", "1921"), Arrays.asList(7, 6, 5, 4));
        historyQuiz.addQuestion("What year did the World War II start?", Arrays.asList("1939", "1940", "1941", "1942"), Arrays.asList(6, 5, 4, 3));
        historyQuiz.addQuestion("What year did the World War II end?", Arrays.asList("1944", "1945", "1946", "1947"), Arrays.asList(7, 6, 5, 4));
        historyQuiz.addQuestion("What year did the Vietnam War start?", Arrays.asList("1950", "1955", "1960", "1965"), Arrays.asList(8, 7, 6, 5));
        historyQuiz.addQuestion("What year did the Vietnam War end?", Arrays.asList("1970", "1975", "1980", "1985"), Arrays.asList(10, 9, 8, 7));

        // Geography quiz
        Quiz capitalQuiz = new Quiz();
        capitalQuiz.setResponses(new LinkedHashMap<String, Integer>() {{
            put("You're a geography buff!", 80);
            put("You're a geography enthusiast!", 60);
            put("You're a geography lover!", 40);
            put("You're a geography student!", 20);
            put("You're a geography novice!", 0);
        }});
        capitalQuiz.addQuestion("What is the capital of the United States?", Arrays.asList("New York", "Washington DC", "Los Angeles", "Chicago"), Arrays.asList(10, 8, 6, 4));
        capitalQuiz.addQuestion("What is the capital of Canada?", Arrays.asList("Ottawa", "Toronto", "Montreal", "Vancouver"), Arrays.asList(7, 5, 3, 1));
        capitalQuiz.addQuestion("What is the capital of Mexico?", Arrays.asList("Mexico City", "Guadalajara", "Monterrey", "Tijuana"), Arrays.asList(6, 5, 4, 3));
        capitalQuiz.addQuestion("What is the capital of Brazil?", Arrays.asList("Rio de Janeiro", "Sao Paulo", "Brasilia", "Salvador"), Arrays.asList(9, 8, 7, 6));
        capitalQuiz.addQuestion("What is the capital of Japan?", Arrays.asList("Tokyo", "Kyoto", "Osaka", "Nagoya"), Arrays.asList(8, 7, 6, 5));
        capitalQuiz.addQuestion("What is the capital of China?", Arrays.asList("Shanghai", "Beijing", "Hong Kong", "Guangzhou"), Arrays.asList(7, 6, 5, 4));
        capitalQuiz.addQuestion("What is the capital of India?", Arrays.asList("Mumbai", "Delhi", "Kolkata", "Bangalore"), Arrays.asList(6, 5, 4, 3));
        capitalQuiz.addQuestion("What is the capital of Russia?", Arrays.asList("Moscow", "Saint Petersburg", "Novosibirsk", "Yekaterinburg"), Arrays.asList(7, 6, 5, 4));
        capitalQuiz.addQuestion("What is the capital of Germany?", Arrays.asList("Berlin", "Hamburg", "Munich", "Cologne"), Arrays.asList(8, 7, 6, 5));
        capitalQuiz.addQuestion("What is the capital of France?", Arrays.asList("Paris", "Marseille", "Lyon", "Toulouse"), Arrays.asList(10, 9, 8, 7));

        // Picker
        QuizPicker picker = new QuizPicker();
        picker.addQuiz("Personality Quiz", personalityQuiz);
        picker.addQuiz("History Quiz", historyQuiz);
        picker.addQuiz("Capital's Quiz", capitalQuiz);
        picker.picker();
    }
}
