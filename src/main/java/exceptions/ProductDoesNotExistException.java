package exceptions;

public class ProductDoesNotExistException extends ServiceException {
    public ProductDoesNotExistException(String message) {
        super(message);
    }
}
