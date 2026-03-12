package universite_paris8.iut.qdev.tp2026.gr21.utils.exceptions;

public class NonCompliantFirstNameException extends Exception {

    public NonCompliantFirstNameException() {
        super("Le prénom ne respecte pas les critères requis.");
    }

    public NonCompliantFirstNameException(String firstName) {
        super("Le prénom \"" + firstName + "\" ne respecte pas les critères requis.");
    }

    public NonCompliantFirstNameException(String firstName, String reason) {
        super("Le prénom \"" + firstName + "\" est invalide : " + reason);
    }

    public NonCompliantFirstNameException(String firstName, Throwable cause) {
        super("Le prénom \"" + firstName + "\" ne respecte pas les critères requis.", cause);
    }
}
