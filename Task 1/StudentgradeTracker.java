import java.util.*;

class StudentgradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students:");
        int numOfStudents = sc.nextInt();

        String[] namesOfStudents = new String[numOfStudents];
        double[] scoreOfStudents = new double[numOfStudents];

        for (int i = 0; i < numOfStudents; i++) {
            System.out.println("Enter the name of student " + (i + 1) + ":");
            namesOfStudents[i] = sc.next();

            System.out.println("Enter the score of the student " + namesOfStudents[i] + ":");
            scoreOfStudents[i] = sc.nextDouble();
        }

        double sum = 0;
        double highestScore = scoreOfStudents[0];
        double lowestScore = scoreOfStudents[0];
        int highIndex = 0;
        int lowIndex = 0;

        for (int i = 0; i < numOfStudents; i++) {
            double score = scoreOfStudents[i];
            sum += score;

            if (score > highestScore) {
                highestScore = score;
                highIndex = i;
            }

            if (score < lowestScore) {
                lowestScore = score;
                lowIndex = i;
            }
        }

        double averageScore = sum / numOfStudents;

        System.out.println("\nGrade Summary");
        System.out.println("The Student Score list:");
        System.out.println("S.No | Student Name | Score | Grade");

        for (int i = 0; i < numOfStudents; i++) {
            char grade = calculateGrade(scoreOfStudents[i]);
            System.out.println((i + 1) + " | " + namesOfStudents[i] + " | " + scoreOfStudents[i] + " | " + grade);
        }

        System.out.println("Average Score is: " + averageScore);
        System.out.println("Highest Score is: " + highestScore + " (Grade: " + calculateGrade(highestScore) + ", Student: " + namesOfStudents[highIndex] + ")");
        System.out.println("Lowest Score is: " + lowestScore + " (Grade: " + calculateGrade(lowestScore) + ", Student: " + namesOfStudents[lowIndex] + ")");

        sc.close();
    }

    public static char calculateGrade(double score) {
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 60) {
            return 'C';
        } else if (score >= 33) {
            return 'D';
        } else {
            return 'F' ; }
        }
}