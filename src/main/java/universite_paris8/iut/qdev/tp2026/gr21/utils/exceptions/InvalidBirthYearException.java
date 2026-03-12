package universite_paris8.iut.qdev.tp2026.gr21.utils.exceptions;

public class InvalidBirthYearException extends Exception {

    public InvalidBirthYearException() {
        super("L'année de naissance est invalide.");
    }

    public InvalidBirthYearException(int year) {
        super("L'année de naissance est invalide : " + year);
    }

    public InvalidBirthYearException(String message) {
        super(message);
    }

    public InvalidBirthYearException(String message, Throwable cause) {
        super(message, cause);
    }
}
