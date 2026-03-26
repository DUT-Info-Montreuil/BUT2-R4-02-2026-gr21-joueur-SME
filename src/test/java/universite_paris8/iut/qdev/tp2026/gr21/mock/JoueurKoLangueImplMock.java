package universite_paris8.iut.qdev.tp2026.gr21.mock;

import universite_paris8.iut.qdev.tp2026.gr21.services.interfaces.IJoueurService;
import universite_paris8.iut.qdev.tp2026.gr21.utils.exceptions.*;
import universite_paris8.iut.qdev.tp2026.gr21.commons.dtos.Joueur;
import universite_paris8.iut.qdev.tp2026.gr21.commons.enums.Langue;

import java.util.ArrayList;

public class JoueurKoLangueImplMock implements IJoueurService {

    @Override
    public Joueur ajouterUnJoueur(String pseudo, String prenom,
                                  int anneeNaissance, Langue langue)
            throws UsernameTakenException, NonCompliantFirstNameException,
            InvalidBirthYearException, InvalidLanguageException {
        throw new InvalidLanguageException(String.valueOf(langue));
    }

    @Override
    public ArrayList<Joueur> recupererListeJoueurs() throws EmptyListException {
        throw new EmptyListException();
    }
}
