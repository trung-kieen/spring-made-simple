package com.example.the_open_book.exception;

/**
 * BadRequestException
 */
public class BadUserRequestException  extends ApplicationException{
    public BadUserRequestException() {
        super();

    }
    public BadUserRequestException(String message, Throwable cause) {
        super(message, cause);
    }
    public BadUserRequestException(String message) {
        super(message);
    }

    public BadUserRequestException(Throwable cause) {
        super(cause);
    }


}
