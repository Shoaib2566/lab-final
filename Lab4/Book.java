public class Book {
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
