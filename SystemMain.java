import java.util.*;

class User {
    String username, password;
    User(String u, String p) {
        username = u;
        password = p;
    }
}

class Reservation {
    static int reservationCounter = 1000;
    int reservationId;
    String name, trainName, trainNumber, classType, date;
    String from, to;
    Reservation(String n, String tn, String tnum, String cl, String d, String f, String t) {
        reservationId = reservationCounter++;
        name = n; trainName = tn; trainNumber = tnum; classType = cl; date = d; from = f; to = t;
    }
}

class SystemMain {
    static Scanner sc = new Scanner(System.in);
    static User currentUser = null;
    static List<User> users = Arrays.asList(new User("admin", "pass123"), new User("user", "user123"));
    static List<Reservation> reservations = new ArrayList<>();

    static boolean login() {
        System.out.print("Username: "); String u = sc.next();
        System.out.print("Password: "); String p = sc.next();
        for (User usr : users) {
            if (usr.username.equals(u) && usr.password.equals(p)) {
                currentUser = usr; return true;
            }
        }
        return false;
    }

    static void reserve() {
        System.out.println("\n---Reservation Form---");
        System.out.print("Name: "); String n = sc.next();
        System.out.print("Train Name: "); String tn = sc.next();
        System.out.print("Train Number: "); String tnum = sc.next();
        System.out.print("Class Type: "); String cl = sc.next();
        System.out.print("Date of Journey: "); String d = sc.next();
        System.out.print("From: "); String f = sc.next();
        System.out.print("To: "); String t = sc.next();
        reservations.add(new Reservation(n, tn, tnum, cl, d, f, t));
        System.out.println("Reservation Done! ID: " + (Reservation.reservationCounter - 1));
    }

    static void cancel() {
        System.out.print("Enter Reservation ID to cancel: ");
        int rid = sc.nextInt();
        Iterator<Reservation> it = reservations.iterator();
        while (it.hasNext()) {
            Reservation r = it.next();
            if (r.reservationId == rid) {
                System.out.println("Cancelling reservation for: " + r.name);
                it.remove(); return;
            }
        }
        System.out.println("Reservation ID not found.");
    }

    public static void main(String[] args) {
        if (!login()) {
            System.out.println("Invalid credentials! Exiting.");
            return;
        }
        int choice;
        do {
            System.out.println("\n1. Reserve  2. Cancel  3. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1: reserve(); break;
                case 2: cancel(); break;
            }
        } while (choice != 3);
    }
}
