import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] questions = {
            "Which language is used for Android development?",
            "Which keyword is used to create a class in Java?",
            "Which method is the entry point of a Java program?",
            "Which data type is used to store whole numbers?",
            "Which symbol is used to end a statement in Java?"
        };

        String[][] options = {
            {"1. Java", "2. Python", "3. HTML", "4. CSS"},
            {"1. function", "2. class", "3. object", "4. define"},
            {"1. start()", "2. run()", "3. main()", "4. execute()"},
            {"1. double", "2. String", "3. int", "4. boolean"},
            {"1. :", "2. .", "3. ,", "4. ;"}
        };

        int[] correctAnswers = {1, 2, 3, 3, 4};

        int score = 0;
        int totalQuestions = questions.length;
        int timeLimit = 10;

        int[] userAnswers = new int[totalQuestions];

        System.out.println("======================================");
        System.out.println("       QUIZ APPLICATION WITH TIMER");
        System.out.println("======================================");
        System.out.println("You have " + timeLimit + " seconds for each question.");
        System.out.println();

        for (int i = 0; i < totalQuestions; i++) {

            System.out.println("--------------------------------------");
            System.out.println("Question " + (i + 1) + " of " + totalQuestions);
            System.out.println("--------------------------------------");

            System.out.println(questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.println();
            System.out.println("Time limit: " + timeLimit + " seconds");
            System.out.print("Enter your answer (1-4): ");

            long startTime = System.currentTimeMillis();

            int answer;

            while (true) {

                if (scanner.hasNextInt()) {
                    answer = scanner.nextInt();

                    long elapsedTime =
                        (System.currentTimeMillis() - startTime) / 1000;

                    if (elapsedTime > timeLimit) {
                        System.out.println("Time's up!");
                        userAnswers[i] = 0;
                        break;
                    }

                    if (answer >= 1 && answer <= 4) {
                        userAnswers[i] = answer;

                        if (answer == correctAnswers[i]) {
                            System.out.println("Correct Answer!");
                            score++;
                        } else {
                            System.out.println("Incorrect Answer!");
                            System.out.println(
                                "Correct answer was: "
                                + correctAnswers[i]
                            );
                        }

                        break;

                    } else {
                        System.out.print(
                            "Invalid option! Enter a number between 1 and 4: "
                        );
                    }

                } else {
                    System.out.println("Invalid input!");
                    scanner.next();
                    System.out.print("Enter your answer (1-4): ");
                }
            }

            System.out.println();
        }

        System.out.println("======================================");
        System.out.println("             QUIZ RESULT");
        System.out.println("======================================");

        System.out.println(
            "Final Score: " + score + "/" + totalQuestions
        );

        double percentage =
            (score * 100.0) / totalQuestions;

        System.out.printf(
            "Percentage: %.2f%%%n",
            percentage
        );

        System.out.println();
        System.out.println("Answer Summary:");
        System.out.println("--------------------------------------");

        for (int i = 0; i < totalQuestions; i++) {

            System.out.print("Question " + (i + 1) + ": ");

            if (userAnswers[i] == 0) {
                System.out.println("Not Answered / Time Up");

            } else if (userAnswers[i] == correctAnswers[i]) {
                System.out.println("Correct");

            } else {
                System.out.println("Incorrect");
            }
        }

        System.out.println("======================================");
        System.out.println("       THANK YOU FOR PLAYING!");
        System.out.println("======================================");

        scanner.close();
    }
}
