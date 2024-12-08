import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        int[] marks = new int[numSubjects];

        // Input marks for each subject
        System.out.println("Enter the marks for each subject (out of 100):");
        int totalMarks = 0;
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Determine grade
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display results
        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks + "/" + (numSubjects * 100));
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}