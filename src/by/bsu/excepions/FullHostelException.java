package by.bsu.excepions;

public class FullHostelException extends Exception {

    public FullHostelException() {
        super();
    }

    public FullHostelException(String message) {
        super(message);
    }

    public FullHostelException(String message, Throwable cause) {
        super(message, cause);
    }

    public FullHostelException(Throwable cause) {
        super(cause);
    }
}
