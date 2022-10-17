package com.example.demo.exception;

public class DocUploadException extends RuntimeException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a reporting dashboard exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public DocUploadException(String message, Throwable cause) {
        super(message, cause);
    }


    /**
     * Instantiates a new  reporting dashboard exception.
     *
     * @param message the message
     */
    public DocUploadException(String message) {
        super(message);
    }

}
