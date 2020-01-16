package ml.pevgen.example.springrestsimple.web.error;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException() {
    }

    public BookNotFoundException(String s) {
        super(s);
    }

    public BookNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public BookNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public BookNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
