package exceptions;

public class IncorrectLoginDetails extends ServiceException {

    IncorrectLoginDetails(String message) {
        super(message);
    }
}
