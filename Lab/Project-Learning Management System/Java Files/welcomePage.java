import java.io.*;
import java.util.Scanner;

public class welcomePage extends loginSignup {

    public static void showWelcomePage() throws IOException {
        System.out.println("::::::::::::: Welcome to NSU LMS :::::::::::::");
        System.out.println("Please select your role:");
        System.out.println("1. Admin");
        System.out.println("2. Teacher");
        System.out.println("3. Student");
        System.out.println("4. Herculean Exit");

        Scanner scanner = new Scanner(System.in);
        int roleChoice = scanner.nextInt();
        scanner.nextLine();

        switch (roleChoice) {
            case 1 -> handleAdmin();
            case 2 -> handleTeacher();
            case 3 -> handleStudent();
            case 4 -> HerculeanExit();
            default -> {
                System.out.println("Invalid choice. Please try again.");
                showWelcomePage();
            }
        }
    }

    private static void handleStudent() throws IOException {
        System.out.println("::::::::::::: Student :::::::::::::");
        System.out.println("1. Login");
        System.out.println("2. Signup");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                studentLogin();
                System.out.println("\n");
            }
            case 2 -> {
                studentSignup();
                System.out.println("\n");
            }
            default -> {
                System.out.println("Invalid choice. Please try again.");
                handleStudent();
            }
        }
    }

    private static void handleTeacher() throws IOException {
        System.out.println("::::::::::::: Teacher :::::::::::::");
        System.out.println("1. Login");
        System.out.println("2. Signup");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                teacherLogin();
                System.out.println("\n");
            }
            case 2 -> {
                teacherSignup();
                System.out.println("\n");
            }
            default -> {
                System.out.println("Invalid choice. Please try again.");
                handleTeacher();
            }
        }
    }

    private static void handleAdmin() throws IOException {
        System.out.println("::::::::::::: Admin :::::::::::::");
        System.out.println("1. Login");
        System.out.println("2. Signup");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                loginSignup.adminLogin();
                System.out.println("\n");
            }
            case 2 -> {
                loginSignup.adminSignup();
                System.out.println("\n");
            }
            default -> {
                System.out.println("Invalid choice. Please try again.");
                handleAdmin();
            }
        }
    }

    public static void HerculeanExit() {
        System.out.println("Are you sure? [y/n]");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if (choice.equals("y")) {
            System.out.println("Thanks for using NSU-LMS!");
            System.exit(0);
        } else if (choice.equals("n")) {
            try {
                showWelcomePage();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
