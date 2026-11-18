public class Book {
    private String title;
    private String author;
    private boolean borrowed;  

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        borrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    
    public String borrowBy(Student s) {
        if (borrowed) {
            return "Sorry, the book " + title + " has already been borrowed.";
        }
        if (s.getHasBorrowed()) {
            return s.getName() + " has already borrowed one book.";
        }

        borrowed = true;
        s.setHasBorrowed(true);
        return s.getName() + " with matric number " + s.getMatric()
                + " has borrow a book with title " + title + ".";
    }

   
    public String toString() {
        return title + " (" + author + ")";
    }
}
