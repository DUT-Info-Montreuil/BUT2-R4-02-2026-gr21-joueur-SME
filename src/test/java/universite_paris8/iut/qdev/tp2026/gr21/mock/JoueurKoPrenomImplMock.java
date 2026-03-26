package universite_paris8.iut.qdev.tp2026.gr21.mock;

import universite_paris8.iut.qdev.tp2026.gr21.commons.dtos.Joueur;
import universite_paris8.iut.qdev.tp2026.gr21.commons.enums.Langue;
import universite_paris8.iut.qdev.tp2026.gr21.services.interfaces.IJoueurService;
import universite_paris8.iut.qdev.tp2026.gr21.utils.exceptions.*;

import java.util.ArrayList;

public class JoueurKoPrenomImplMock implements IJoueurService {

    @Override
    public Joueur ajouterUnJoueur(String pseudo, String prenom,
                                  int anneeNaissance, Langue langue)
            throws UsernameTakenException, NonCompliantFirstNameException,
            InvalidBirthYearException, InvalidLanguageException {
        throw new NonCompliantFirstNameException(prenom);
    }

    @Override
    public ArrayList<Joueur> recupererListeJoueurs() throws EmptyListException {
        throw new EmptyListException();
    }
}