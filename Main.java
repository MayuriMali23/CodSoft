import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int rollNumber;
    private String name;
    private String grade;

    public Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Roll Number: " + rollNumber + ", Name: " + name + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Grade: ");
        String grade = scanner.nextLine();

        students.add(new Student(rollNumber, name, grade));
        System.out.println("Student added successfully!");
    }

    public void removeStudent() {
        System.out.print("Enter Roll Number to remove: ");
        int rollNumber = scanner.nextInt();
        students.removeIf(student -> student.getRollNumber() == rollNumber);
        System.out.println("Student removed successfully!");
    }

    public void searchStudent() {
        System.out.print("Enter Roll Number to search: ");
        int rollNumber = scanner.nextInt();
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting Student Management System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        system.menu();
    }
}