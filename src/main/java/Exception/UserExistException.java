package Exception;

/**
 * @author: yue
 * @description: user defined exception
 */


public class UserExistException extends  Exception {
    String message;
    public UserExistException() {
    }

    public UserExistException(String message) {
        this. message=message;
    }

    @Override
    public String getMessage() {
        return message ;
    }
}
