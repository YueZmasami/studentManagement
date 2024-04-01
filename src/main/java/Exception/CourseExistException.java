package Exception;

/**
 * @author: yue
 * @description:
 */


public class CourseExistException extends Exception{
    String message;
    public CourseExistException() {
    }

    public CourseExistException(String message) {
        this. message=message;
    }

    @Override
    public String getMessage() {
        return message ;
    }
}
