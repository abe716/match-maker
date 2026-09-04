import java.util.Scanner;

public class MatchMaker {

    // Constants
    static final int NUMBER_OF_QUESTIONS = 5;
    static final int MIN_ANSWER = 1;
    static final int MAX_ANSWER = 5;

    static final int TRUE_LOVE_THRESHOLD = 80;
    static final int FRIENDS_THRESHOLD = 50;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Questions
        String[] questions = {
            "I enjoy trying new foods.",
            "I like watching movies together.",
            "I enjoy traveling.",
            "I like spending time with friends and family.",
            "I enjoy listening to music."
        };

        // Your desired answers
        int[] desiredAnswers = {
            5,
            4,
            5,
            4,
            5
        };

        int totalCompatibilityScore = 0;

        System.out.println("======================================");
        System.out.println("        ♥ MATCHMAKER WITH JAVA ♥");
        System.out.println("======================================");
        System.out.println();
        System.out.println("Answer each statement from 1 to 5.");
        System.out.println("1 = Strongly Disagree");
        System.out.println("2 = Disagree");
        System.out.println("3 = Neutral");
        System.out.println("4 = Agree");
        System.out.println("5 = Strongly Agree");
        System.out.println();

        // Ask all five questions
        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {

            System.out.println("Question " + (i + 1) + ":");
            System.out.println(questions[i]);

            int answer = validate(scanner);

            // Calculate compatibility
            int compatibilityScore =
                Math.abs(answer - desiredAnswers[i]);

            totalCompatibilityScore += compatibilityScore;

            System.out.println(
                "Question compatibility score: "
                + compatibilityScore
            );

            System.out.println();
        }

        // Calculate final percentage
        int compatibilityPercentage =
            100 - (totalCompatibilityScore * 5);

        System.out.println("======================================");
        System.out.println("          MATCH RESULTS");
        System.out.println("======================================");

        System.out.println(
            "Overall Compatibility: "
            + compatibilityPercentage + "%"
        );

        // Determine result
        if (compatibilityPercentage >= TRUE_LOVE_THRESHOLD) {

            System.out.println("❤️ TRUE LOVE!");

        } else if (compatibilityPercentage >= FRIENDS_THRESHOLD) {

            System.out.println("🙂 You could be great friends!");

        } else {

            System.out.println("🏃 RUN AWAY!");

        }

        System.out.println();
        System.out.println("Thanks for using MatchMaker!");

        scanner.close();
    }


    // Validates user input
    public static int validate(Scanner scanner) {

        while (true) {

            System.out.print("Enter your answer (1-5): ");

            if (scanner.hasNextInt()) {

                int answer = scanner.nextInt();

                if (answer >= MIN_ANSWER && answer <= MAX_ANSWER) {
                    return answer;
                }

                System.out.println(
                    "Error: Please enter a number from 1 to 5."
                );

            } else {

                System.out.println(
                    "Error: Please enter a whole number from 1 to 5."
                );

                scanner.next();
            }
        }
    }
}