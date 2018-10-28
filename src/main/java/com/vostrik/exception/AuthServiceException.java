package com.vostrik.exception;

public class AuthServiceException extends Exception {
    /**
     * Конструктор
     */
    public AuthServiceException() {

        super();
    }

    /**
     * Конструктор
     *
     * @param error    сообщение
     */
    public AuthServiceException(String error) {

        super(error);
    }

    /**
     * Конструктор
     *
     * @param error        сообщение
     * @param exception    ошибка
     */
    public AuthServiceException(String error, Throwable exception) {

        super(error, exception);
    }

    /**
     * Конструктор
     *
     * @param exception    ошибка
     */
    public AuthServiceException(Throwable exception) {

        super(exception);
    }
}
