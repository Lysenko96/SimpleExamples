package edu.tohaa.carservice.exceptions;

public class DriverNotExistsDatabaseException extends Exception {

    public DriverNotExistsDatabaseException() {
    }

    public DriverNotExistsDatabaseException(String message) {
        super(message);
    }
}
