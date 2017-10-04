package pl.sportfacility.sportfacility.exception;

public enum Error {

    CANNOT_FIND_ACCOUNT_BY_EMAIL("Do podanego adresu email nie jest przypisane żadne konto w systemie."),

    CANNOT_FIND_ACCOUNT_BY_USERNAME("Podana nazwa użytkownika nie istnieje w systemie."),

    FATAL_ERROR("Wystąpił nieoczekiwany błąd systemu, place : ");

    private final String message;

    Error(final String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
