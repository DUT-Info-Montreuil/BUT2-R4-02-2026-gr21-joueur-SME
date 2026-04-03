package universite_paris8.iut.qdev.tp2026.gr21.services.impls;

import universite_paris8.iut.qdev.tp2026.gr21.commons.dtos.Joueur;
import universite_paris8.iut.qdev.tp2026.gr21.commons.enums.Langue;
import universite_paris8.iut.qdev.tp2026.gr21.services.interfaces.IJoueurService;
import universite_paris8.iut.qdev.tp2026.gr21.utils.exceptions.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;

public class JoueurService implements IJoueurService {
    private final ArrayList<Joueur> joueurs = new ArrayList<>();

    @Override
    public Joueur ajouterUnJoueur(String prenom, String pseudo, int anneeNaissance, Langue langue) throws UsernameTakenException, NonCompliantFirstNameException, InvalidBirthYearException, InvalidLanguageException {
        for (Joueur j : joueurs) {
            if (j.getPseudo().equalsIgnoreCase(pseudo)) {
                System.out.println();
                throw new UsernameTakenException();
            }
        }

        int anneeActuelle = Year.now().getValue();

        if (prenom.length() < 2 || prenom.length() > 150) {
            throw new NonCompliantFirstNameException();
        } else if (anneeNaissance > anneeActuelle || anneeNaissance < anneeActuelle - 150) {
            throw new InvalidBirthYearException();
        }

        boolean langueValide = false;
        int i = 0;
        EnumSet<Langue> langues = EnumSet.allOf(Langue.class);
        Iterator<Langue> languesIterator = langues.iterator();
        while (!langueValide && languesIterator.hasNext()) {
            Langue l = languesIterator.next();
            if (l == langue) {
                langueValide = true;
            }
        }

        if (!langueValide) {
            throw new InvalidLanguageException();
        }

        Joueur joueur = new Joueur(prenom, pseudo, anneeNaissance, langue);
        joueurs.add(joueur);
        return joueur;
    }

    @Override
    public ArrayList<Joueur> recupererListeJoueurs() throws EmptyListException {
        if (joueurs.isEmpty()) {
            throw new EmptyListException();
        }

        return joueurs;
    }
}
