import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
    }

    public void showAvailableBooks() {
        System.out.println("Available Books:");
        for (Book b : books) {
            if (!b.isIssued()) {
                System.out.println("  " + b);
            }
        }
    }

    public void issueBook(String title) {
        Book b = findBook(title);
        if (b == null) {
            System.out.println("Book \"" + title + "\" not found.");
        } else if (b.issueBook()) {
            System.out.println("Issued: " + title);
        } else {
            System.out.println("Book \"" + title + "\" is already issued.");
        }
    }

    public void returnBook(String title) {
        Book b = findBook(title);
        if (b == null) {
            System.out.println("Book \"" + title + "\" not found.");
        } else if (b.returnBook()) {
            System.out.println("Returned: " + title);
        } else {
            System.out.println("Book \"" + title + "\" was not issued.");
        }
    }

    private Book findBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }
}
