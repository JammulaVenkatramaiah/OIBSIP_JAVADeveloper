import java.util.*;

public class OnlineExamination {
    static Scanner sc = new Scanner(System.in);
    static String username = "student";
    static String password = "exam123";
    static String name = "Student Name";
    static int score = 0;

    static void login() {
        System.out.print("Username: ");
        String u = sc.next();
        System.out.print("Password: ");
        String p = sc.next();
        if (!u.equals(username) || !p.equals(password)) {
            System.out.println("Invalid credentials!"); System.exit(0);
        }
        System.out.println("Welcome, " + name);
    }

    static void updateProfile() {
        System.out.print("Update Name (Current: " + name + "): ");
        sc.nextLine();
        String newName = sc.nextLine();
        if (!newName.isEmpty()) name = newName;
        System.out.print("Update Password (leave blank to keep current): ");
        String newPass = sc.nextLine();
        if (!newPass.isEmpty()) password = newPass;
        System.out.println("Profile updated.");
    }

    static void takeExam() {
        String[] questions = {
            "Capital of India?\nA. Delhi\nB. Mumbai\nC. Chennai\nD. Kolkata",
            "Java founder?\nA. Bjarne\nB. James Gosling\nC. Dennis\nD. Guido",
            "Largest planet?\nA. Earth\nB. Mars\nC. Jupiter\nD. Saturn",
        };
        char[] answers = {'A', 'B', 'C', 'D'};
        score = 0;
        int durationSec = 60; // total time for exam

        long start = System.currentTimeMillis();
        for (int i = 0; i < questions.length; i++) {
            long elapsed = (System.currentTimeMillis() - start) / 1000;
            if (elapsed > durationSec) {
                System.out.println("Time's up! Auto-submit.");
                break;
            }
            System.out.println(questions[i]);
            System.out.print("Answer (A/B/C/D): ");
            char ans = sc.next().toUpperCase().charAt(0);
            if (ans == answers[i]) score += 1;
        }
        System.out.println("Exam Completed. Score: " + score + "/" + questions.length);
    }

    public static void main(String[] args) {
        login();
        while (true) {
            System.out.println("\n1.Update Profile & Password\n2.Take MCQ Exam\n3.Logout & Exit");
            int ch = sc.nextInt();
            if (ch == 1) updateProfile();
            else if (ch == 2) takeExam();
            else if (ch == 3) {
                System.out.println("Session closed. Goodbye!"); break;
            }
        }
    }
}
