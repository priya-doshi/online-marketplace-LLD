package exceptions;

public class NoProductExistInCart extends ServiceException {
    NoProductExistInCart(String message) {
        super(message);
    }
}
