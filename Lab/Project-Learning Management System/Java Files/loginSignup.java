import java.io.*;
import java.util.Scanner;

public class loginSignup {
    public static void studentLogin() throws IOException {
        System.out.println("::::::::::::: Student Login :::::::::::::");
        System.out.print("Enter username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();


        if (validateLoginCredentials("stuInfo.txt", username, password)) {
            System.out.println("Login successful!");
            StudentOperation.performStudentOperations();
        } else {
            System.out.println("Invalid username or password. Please try again.");
            studentLogin();
        }
    }

    public static void studentSignup() throws IOException {
        System.out.println("::::::::::::: Student Signup :::::::::::::");
        System.out.print("Enter username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();


        saveSignupInformation("stuInfo.txt", username, password);

        System.out.println("Signup successful! Please login with your new account.");
        studentLogin();
    }

    public static void teacherLogin() throws IOException {
        System.out.println("::::::::::::: Teacher Login :::::::::::::");
        System.out.print("Enter username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();


        if (validateLoginCredentials("teacherInfo.txt", username, password)) {
            System.out.println("Login successful!");
            TeacherOperation.performTeacherOperations();
        } else {
            System.out.println("Invalid username or password. Please try again.");
            teacherLogin();
        }
    }

    public static void teacherSignup() throws IOException {
        System.out.println("::::::::::::: Teacher Signup :::::::::::::");
        System.out.print("Enter username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();


        saveSignupInformation("teacherInfo.txt", username, password);

        System.out.println("Signup successful! Please login with your new account.");
        teacherLogin();
    }

    public static void adminLogin() throws IOException {
        System.out.println("::::::::::::: Admin Login :::::::::::::");
        System.out.print("Enter username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();


        if (validateLoginCredentials("adminInfo.txt", username, password)) {
            System.out.println("Login successful!");
            AdminOperation.performAdminOperations();
        } else {
            System.out.println("Invalid username or password. Please try again.");
            adminLogin();
        }
    }

    public static void adminSignup() throws IOException {
        System.out.println("::::::::::::: Admin Signup :::::::::::::");
        System.out.print("Enter username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();


        saveSignupInformation("adminInfo.txt", username, password);

        System.out.println("Signup successful! Please login with your new account.");
        adminLogin();
    }

    public static boolean validateLoginCredentials(String fileName, String username, String password) throws IOException {
        File sb = new File(fileName);
        try (Scanner scanner = new Scanner(sb)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] credentials = line.split(",");

                if (credentials.length == 2) {
                    String storedUsername = credentials[0];
                    String storedPassword = credentials[1];

                    if (storedUsername.equals(username) && storedPassword.equals(password)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
            throw e;
        }

        return false;
    }

    public static void saveSignupInformation(String fileName, String username, String password) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(file, true);
            writer.write(username + "," + password + "\n" + "\n");
            writer.close();

            System.out.println("User added successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
