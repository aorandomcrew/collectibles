package exeptions;

public class EmployeeNotFoundExeption extends RuntimeException {

    public EmployeeNotFoundExeption() {
        System.out.println("сотрудник не найден");
    }

    public EmployeeNotFoundExeption(String message) {
        super(message);
    }

    public EmployeeNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeNotFoundExeption(Throwable cause) {
        super(cause);
    }

    public EmployeeNotFoundExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
