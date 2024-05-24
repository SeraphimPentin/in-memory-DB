package sim.inmemorydb.exception;

public class RecordsNotFoundException extends RuntimeException {
    public RecordsNotFoundException(String message) {
        super(message);
    }
}
