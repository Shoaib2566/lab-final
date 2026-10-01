public class LibraryMain {
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
