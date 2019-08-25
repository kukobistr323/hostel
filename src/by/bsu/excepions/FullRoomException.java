package by.bsu.excepions;

public class FullRoomException extends Exception {

    public FullRoomException() {
        super();
    }

    public FullRoomException(String message) {
        super(message);
    }

    public FullRoomException(String message, Throwable cause) {
        super(message, cause);
    }

    public FullRoomException(Throwable cause) {
        super(cause);
    }
}
