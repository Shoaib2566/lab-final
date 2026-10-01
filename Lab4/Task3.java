import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }

    public boolean issueBook() {
        if (isIssued) {
            return false;
        }
        isIssued = true;
        return true;
    }

    public boolean returnBook() {
        if (!isIssued) {
            return false;
        }
        isIssued = false;
        return true;
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
}

class Library {
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

public class Task3 {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("Clean Code", "Robert C. Martin"));
        library.addBook(new Book("Design Patterns", "Erich Gamma"));
        library.addBook(new Book("Refactoring", "Martin Fowler"));
        library.addBook(new Book("The Pragmatic Programmer", "Andrew Hunt"));
        library.addBook(new Book("Effective Java", "Joshua Bloch"));

        library.showAvailableBooks();

        library.issueBook("Clean Code");
        library.issueBook("Effective Java");
        library.showAvailableBooks();

        library.returnBook("Clean Code");
        library.showAvailableBooks();
    }
}
