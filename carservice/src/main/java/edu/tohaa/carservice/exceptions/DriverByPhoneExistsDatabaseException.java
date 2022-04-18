package edu.tohaa.carservice.exceptions;

public class DriverByPhoneExistsDatabaseException extends Exception {

    public DriverByPhoneExistsDatabaseException() {
    }

    public DriverByPhoneExistsDatabaseException(String message) {
        super(message);
    }
}
