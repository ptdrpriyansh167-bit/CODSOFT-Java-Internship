import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("      STUDENT GRADE CALCULATOR");
        System.out.println("=================================");

        System.out.print("\nEnter number of subjects: ");
        int subjects = scanner.nextInt();

        int totalMarks = 0;

        for (int i = 1; i <= subjects; i++) {

            System.out.print("Enter marks for Subject " + i + " (out of 100): ");
            int marks = scanner.nextInt();

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Please enter marks between 0 and 100.");
                i--;
                continue;
            }

            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / subjects;

        char grade;

        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else if (averagePercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        System.out.println("\n=================================");
        System.out.println("          RESULT");
        System.out.println("=================================");

        System.out.println("Total Marks: " + totalMarks + "/" + (subjects * 100));
        System.out.printf("Average Percentage: %.2f%%%n", averagePercentage);
        System.out.println("Grade: " + grade);

        System.out.println("=================================");

        scanner.close();
    }
}
