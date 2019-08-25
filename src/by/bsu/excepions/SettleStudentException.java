package by.bsu.excepions;

public class SettleStudentException extends Exception {

    public SettleStudentException() {
        super();
    }

    public SettleStudentException(String message) {
        super(message);
    }

    public SettleStudentException(String message, Throwable cause) {
        super(message, cause);
    }

    public SettleStudentException(Throwable cause) {
        super(cause);
    }

}
