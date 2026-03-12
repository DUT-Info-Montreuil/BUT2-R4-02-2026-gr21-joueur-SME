package universite_paris8.iut.qdev.tp2026.gr21.utils.exceptions;

public class EmptyListException extends Exception {

    public EmptyListException() {
        super("La liste des joueurs est vide.");
    }

    public EmptyListException(String message) {
        super(message);
    }

    public EmptyListException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyListException(Throwable cause) {
        super("La liste des joueurs est vide.", cause);
    }
}