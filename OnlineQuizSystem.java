import java.util.ArrayList;
import java.util.Scanner;

class Question {
    private String questionText;
    private String[] options;
    private int correctAnswer;

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean askQuestion(Scanner sc) {
        System.out.println("\n" + questionText);

        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        System.out.print("Enter your answer (1-4): ");
        int answer = sc.nextInt();

        return answer == correctAnswer;
    }
}

class Quiz {
    private ArrayList<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void startQuiz() {
        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("      ONLINE QUIZ SYSTEM");
        System.out.println("================================");

        for (Question q : questions) {
            if (q.askQuestion(sc)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong Answer!");
            }
        }

        System.out.println("\n================================");
        System.out.println("Quiz Completed!");
        System.out.println("Your Score: " + score + "/" + questions.size());

        double percentage = ((double) score / questions.size()) * 100;

        System.out.printf("Percentage: %.2f%%\n", percentage);

        if (percentage >= 80) {
            System.out.println("Grade: A");
        } else if (percentage >= 60) {
            System.out.println("Grade: B");
        } else if (percentage >= 40) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: Fail");
        }

        sc.close();
    }
}

public class OnlineQuizSystem {
    public static void main(String[] args) {

        Quiz quiz = new Quiz();

        quiz.addQuestion(new Question(
                "Which language is used for Android Development?",
                new String[]{"Python", "Java", "C++", "HTML"},
                2));

        quiz.addQuestion(new Question(
                "What does OOP stand for?",
                new String[]{
                        "Object Oriented Programming",
                        "Online Object Program",
                        "Operating Object Process",
                        "None of these"
                },
                1));

        quiz.addQuestion(new Question(
                "Which collection stores unique values?",
                new String[]{"ArrayList", "LinkedList", "HashSet", "Vector"},
                3));

        quiz.addQuestion(new Question(
                "Which keyword is used for inheritance in Java?",
                new String[]{"implements", "inherits", "extends", "super"},
                3));

        quiz.addQuestion(new Question(
                "Which company developed Java?",
                new String[]{"Microsoft", "Oracle", "Sun Microsystems", "Google"},
                3));

        quiz.startQuiz();
    }
}