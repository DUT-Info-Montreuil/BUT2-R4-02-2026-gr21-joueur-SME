package universite_paris8.iut.qdev.tp2026.gr21.utils.exceptions;

public class InvalidLanguageException extends Exception {

    public InvalidLanguageException() {
        super("La langue sélectionnée est invalide.");
    }

    public InvalidLanguageException(String language) {
        super("La langue sélectionnée est invalide : " + language);
    }

    public InvalidLanguageException(String language, Throwable cause) {
        super("La langue sélectionnée est invalide : " + language, cause);
    }
}
