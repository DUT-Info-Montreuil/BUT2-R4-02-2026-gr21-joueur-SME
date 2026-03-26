package universite_paris8.iut.qdev.tp2026.gr21.mock;

import universite_paris8.iut.qdev.tp2026.gr21.commons.dtos.Joueur;
import universite_paris8.iut.qdev.tp2026.gr21.commons.enums.Langue;
import universite_paris8.iut.qdev.tp2026.gr21.services.interfaces.IJoueurService;
import universite_paris8.iut.qdev.tp2026.gr21.utils.exceptions.*;

import java.util.ArrayList;

public class JoueurOkImplMock implements IJoueurService {

    private ArrayList<Joueur> listeJoueurs = new ArrayList<>();

    @Override
    public Joueur ajouterUnJoueur(String pseudo, String prenom,
                                  int anneeNaissance, Langue langue)
            throws UsernameTakenException, NonCompliantFirstNameException,
            InvalidBirthYearException, InvalidLanguageException {
        Joueur joueur = new Joueur(pseudo, prenom, anneeNaissance, langue);
        listeJoueurs.add(joueur); // On l'ajoute à la liste
        return joueur;
    }

    @Override
    public ArrayList<Joueur> recupererListeJoueurs() throws EmptyListException {
        if (listeJoueurs.isEmpty()) {
            throw new EmptyListException(); // Lève l'exception si vide
        }
        return listeJoueurs; // Retourne la liste si non vide
    }

}
