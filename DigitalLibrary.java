import java.util.*;

class Book {
    int id;
    String title, author;
    boolean issued;
    Book(int id, String title, String author) {
        this.id = id; this.title = title; this.author = author; this.issued = false;
    }
}

class Member {
    int id;
    String name;
    List<Book> issuedBooks = new ArrayList<>();
    Member(int id, String name) { this.id = id; this.name = name; }
}

class DigitalLibrary {
    Map<Integer, Book> books = new HashMap<>();
    Map<Integer, Member> members = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    void adminMenu() {
        while (true) {
            System.out.println("\nAdmin Menu: 1.Add Book 2.Delete Book 3.View Books 4.Add Member 5.View Members 6.Issue Book 7.Return Book 8.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1: addBook(); break;
                case 2: deleteBook(); break;
                case 3: viewBooks(); break;
                case 4: addMember(); break;
                case 5: viewMembers(); break;
                case 6: issueBook(); break;
                case 7: returnBook(); break;
                case 8: return;
            }
        }
    }

    void userMenu(int memberId) {
        while (true) {
            System.out.println("\nUser Menu: 1.View Books 2.Issue Book 3.Return Book 4.View Issued Books 5.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1: viewBooks(); break;
                case 2: issueBookToUser(memberId); break;
                case 3: returnBookFromUser(memberId); break;
                case 4: viewIssuedBooks(memberId); break;
                case 5: return;
            }
        }
    }

    void addBook() {
        System.out.print("Book ID: "); int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Title: "); String title = sc.nextLine();
        System.out.print("Author: "); String author = sc.nextLine();
        books.put(id, new Book(id, title, author));
        System.out.println("Book added.");
    }

    void deleteBook() {
        System.out.print("Book ID to delete: "); int id = sc.nextInt();
        if (books.remove(id) != null) System.out.println("Book deleted.");
        else System.out.println("Not found.");
    }

    void viewBooks() {
        System.out.println("-- Book List --");
        for (Book b : books.values())
            System.out.println("ID:" + b.id + " Title:" + b.title + " Author:" + b.author + " Issued:" + b.issued);
    }

    void addMember() {
        System.out.print("Member ID: "); int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: "); String name = sc.nextLine();
        members.put(id, new Member(id, name));
        System.out.println("Member added.");
    }

    void viewMembers() {
        System.out.println("-- Member List --");
        for (Member m : members.values())
            System.out.println("ID:" + m.id + " Name:" + m.name + " Books Issued:" + m.issuedBooks.size());
    }

    void issueBook() {
        System.out.print("Book ID: "); int bid = sc.nextInt();
        System.out.print("Member ID: "); int mid = sc.nextInt();
        Book b = books.get(bid); Member m = members.get(mid);
        if (b != null && m != null && !b.issued) {
            b.issued = true;
            m.issuedBooks.add(b);
            System.out.println("Book issued.");
        } else System.out.println("Invalid operation.");
    }

    void returnBook() {
        System.out.print("Book ID: "); int bid = sc.nextInt();
        System.out.print("Member ID: "); int mid = sc.nextInt();
        Book b = books.get(bid); Member m = members.get(mid);
        if (b != null && m != null && b.issued && m.issuedBooks.contains(b)) {
            b.issued = false;
            m.issuedBooks.remove(b);
            System.out.println("Book returned.");
        } else System.out.println("Invalid operation.");
    }

    // For User functions:
    void issueBookToUser(int mid) {
        System.out.print("Book ID: "); int bid = sc.nextInt();
        Book b = books.get(bid); Member m = members.get(mid);
        if (b != null && m != null && !b.issued) {
            b.issued = true;
            m.issuedBooks.add(b);
            System.out.println("Book issued.");
        } else System.out.println("Book not available.");
    }

    void returnBookFromUser(int mid) {
        System.out.print("Book ID: "); int bid = sc.nextInt();
        Book b = books.get(bid); Member m = members.get(mid);
        if (b != null && m != null && b.issued && m.issuedBooks.contains(b)) {
            b.issued = false;
            m.issuedBooks.remove(b);
            System.out.println("Book returned.");
        } else System.out.println("Not issued to user.");
    }

    void viewIssuedBooks(int mid) {
        Member m = members.get(mid);
        System.out.println("-- Books Issued --");
        for (Book b : m.issuedBooks)
            System.out.println("ID:" + b.id + " Title:" + b.title);
    }

    public static void main(String[] args) {
        DigitalLibrary sys = new DigitalLibrary();
        Scanner sc = new Scanner(System.in);
        System.out.println("Login as: 1.Admin  2.User");
        int logType = sc.nextInt();
        if (logType == 1) sys.adminMenu();
        else if (logType == 2) {
            System.out.print("Enter User/Member ID: "); int mid = sc.nextInt();
            if (!sys.members.containsKey(mid)) sys.addMember();
            sys.userMenu(mid);
        }
    }
}
