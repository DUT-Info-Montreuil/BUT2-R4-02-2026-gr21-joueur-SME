package universite_paris8.iut.qdev.tp2026.gr21.services.interfaces;

import universite_paris8.iut.qdev.tp2026.gr21.commons.dtos.Joueur;
import universite_paris8.iut.qdev.tp2026.gr21.commons.enums.Langue;
import universite_paris8.iut.qdev.tp2026.gr21.utils.exceptions.*;

import java.util.ArrayList;

/**
 * Interface du service joueur.
 * Définit les opérations disponibles pour la gestion des joueurs.
 */
public interface IJoueurService {

    /**
     * Ajoute un nouveau joueur dans le référentiel.
     *
     * @param pseudo          Le pseudo unique du joueur.
     * @param prenom          Le prénom du joueur.
     * @param anneeNaissance  L'année de naissance du joueur.
     * @param langue          La langue préférée du joueur.
     * @return                Le joueur nouvellement créé.
     * @throws UsernameTakenException        Si le pseudo est déjà utilisé par un autre joueur.
     * @throws NonCompliantFirstNameException Si le prénom ne respecte pas les règles de conformité.
     * @throws InvalidBirthYearException     Si l'année de naissance est invalide.
     * @throws InvalidLanguageException      Si la langue fournie est invalide ou non supportée.
     */
    public Joueur ajouterUnJoueur(String pseudo, String prenom, int anneeNaissance, Langue langue)
            throws UsernameTakenException, NonCompliantFirstNameException,
            InvalidBirthYearException, InvalidLanguageException;

    /**
     * Récupère la liste complète de tous les joueurs enregistrés.
     *
     * @return Une ArrayList contenant l'ensemble des joueurs du jeu.
     * @throws EmptyListException Si aucun joueur n'est présent dans le référentiel.
     */
    public ArrayList<Joueur> recupererListeJoueurs() throws EmptyListException;

}
