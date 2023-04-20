import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 class LibrarySystem {
    static List<Book> bookList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;

        do {
            int j=0;
            for(int i=0;i<1000000000;i++){
                j=5;


            }
            System.out.println("Enter option:");
            System.out.println("1 - Add book");
            System.out.println("2 - Issue book");
            System.out.println("3 - Return book");
            System.out.println("4 - Display all books");
            System.out.println("5 - Exit");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    issueBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    displayBooks();
                    break;
                case 5:
                    System.out.println("Thank you for using the Library System!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (option != 5);
    }

    private static void addBook() {
        System.out.println("Enter book name:");
        String bookName = scanner.next();
        System.out.println("Enter author name:");
        String authorName = scanner.next();
        Book book = new Book(bookName, authorName, true);
        bookList.add(book);
        System.out.println("Book added successfully!");
    }

    private static void issueBook() {
        System.out.println("Enter book name:");
        String bookName = scanner.next();
        System.out.println("Enter author name:");
        String authorName = scanner.next();
        boolean isBookIssued = false;
        for (Book book : bookList) {
            if (book.getBookName().equals(bookName) && book.getAuthorName().equals(authorName) && book.isAvailable()) {
                book.setAvailable(false);
                isBookIssued = true;
                System.out.println("Book " + book.getBookName() + " by " + book.getAuthorName() + " has been issued.");
                break;
            }
        }
        if (!isBookIssued) {
            System.out.println("Book not available or invalid book details!");
        }
    }

    private static void returnBook() {
        System.out.println("Enter book name:");
        String bookName = scanner.next();
        System.out.println("Enter author name:");
        String authorName = scanner.next();
        boolean isBookReturned = false;
        for (Book book : bookList) {
            if (book.getBookName().equals(bookName) && book.getAuthorName().equals(authorName) && !book.isAvailable()) {
                book.setAvailable(true);
                isBookReturned = true;
                System.out.println("Book " + book.getBookName() + " by " + book.getAuthorName() + " has been returned.");
                break;
            }
        }
        if (!isBookReturned) {
            System.out.println("Book not issued or invalid book details!");
        }
    }

    private static void displayBooks() {
        System.out.println("List of books:");
        for (Book book : bookList) {
            System.out.println(book.getBookName() + " by " + book.getAuthorName() + " - " + (book.isAvailable() ? "Available" : "Not Available"));
        }
    }
}

class Book {
    private String bookName;
    private String authorName;
    private boolean available;

    public Book(String bookName, String authorName, boolean available) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.available = available;
    }



    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}



