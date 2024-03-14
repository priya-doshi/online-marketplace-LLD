package exceptions;

public class UserDoesNotExistException extends ServiceException {

    public UserDoesNotExistException(String message) {
        super(message);
    }
}
