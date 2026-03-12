package universite_paris8.iut.qdev.tp2026.gr21.utils.exceptions;

public class UsernameTakenException extends Exception {

    public UsernameTakenException() {
        super("Ce nom d'utilisateur est déjà pris.");
    }

    public UsernameTakenException(String username) {
        super("Le nom d'utilisateur \"" + username + "\" est déjà pris.");
    }

    public UsernameTakenException(String username, Throwable cause) {
        super("Le nom d'utilisateur \"" + username + "\" est déjà pris.", cause);
    }
}
