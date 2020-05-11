package structural.proxy.command.executor;

public class InsufficientPermissionException extends RuntimeException {

    public InsufficientPermissionException() {
        super();
    }

    public InsufficientPermissionException(String message) {
        super(message);
    }

}
