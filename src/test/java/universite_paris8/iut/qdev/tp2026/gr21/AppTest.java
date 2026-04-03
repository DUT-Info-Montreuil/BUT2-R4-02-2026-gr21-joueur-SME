package universite_paris8.iut.qdev.tp2026.gr21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import universite_paris8.iut.qdev.tp2026.gr21.commons.dtos.Joueur;
import universite_paris8.iut.qdev.tp2026.gr21.commons.enums.Langue;
import universite_paris8.iut.qdev.tp2026.gr21.mock.*;
import universite_paris8.iut.qdev.tp2026.gr21.services.impls.JoueurService;
import universite_paris8.iut.qdev.tp2026.gr21.utils.exceptions.*;

import java.time.Year;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JoueurServiceTest {

    private JoueurService joueurService;

    @BeforeEach
    public void setUp() {
        joueurService = new JoueurService(); // ✅ Vraie implémentation
    }

    // ✅ CAS OK : joueur ajouté
    @Test
    public void ajouterJoueur_shouldReturnJoueur_WhenToutValide() throws Exception {
        Joueur j1 = joueurService.ajouterUnJoueur("Marie", "John", 2000, Langue.FRANCAIS);
        Joueur j2 = new Joueur("Marie", "John", 2000, Langue.FRANCAIS);

        assertEquals(j1, j2);
    }

    // ❌ CAS KO : pseudo déjà pris
    @Test
    public void ajouterJoueur_shouldThrow_WhenPseudoDejaUtilise() throws Exception {
        joueurService.ajouterUnJoueur("Marie", "John", 2000, Langue.FRANCAIS);

        assertThrows(UsernameTakenException.class, () ->
                joueurService.ajouterUnJoueur("Marie", "John", 2000, Langue.FRANCAIS)
        );
    }

    // ❌ CAS KO : prénom trop court
    @Test
    public void ajouterJoueur_shouldThrow_WhenPrenomTropCourt() {
        assertThrows(NonCompliantFirstNameException.class, () ->
                joueurService.ajouterUnJoueur("M", "John", 2000, Langue.FRANCAIS)
        );
    }

    // ❌ CAS KO : prénom trop long
    @Test
    public void ajouterJoueur_shouldThrow_WhenPrenomTropLong() {
        String prenomTropLong = "M".repeat(151);

        assertThrows(NonCompliantFirstNameException.class, () ->
                joueurService.ajouterUnJoueur(prenomTropLong, "John", 2000, Langue.FRANCAIS)
        );
    }

    // ❌ CAS KO : année dans le futur
    @Test
    public void ajouterJoueur_shouldThrow_WhenAnneeNaissanceDansFutur() {
        assertThrows(InvalidBirthYearException.class, () ->
                joueurService.ajouterUnJoueur("Marie", "John", 2099, Langue.FRANCAIS)
        );
    }

    // ❌ CAS KO : année trop ancienne
    @Test
    public void ajouterJoueur_shouldThrow_WhenAnneeNaissanceTropAncienne() {
        int anneeTropAncienne = Year.now().getValue() - 151;

        assertThrows(InvalidBirthYearException.class, () ->
                joueurService.ajouterUnJoueur("Marie", "John", anneeTropAncienne, Langue.FRANCAIS)
        );
    }

    // ❌ CAS KO : langue null
    @Test
    public void ajouterJoueur_shouldThrow_WhenLangueNull() {
        assertThrows(InvalidLanguageException.class, () ->
                joueurService.ajouterUnJoueur("Marie", "John", 2000, null)
        );
    }

    // ✅ CAS OK : liste non vide
    @Test
    public void recupererListeJoueurs_shouldReturnListe_WhenNonVide() throws Exception {
        joueurService.ajouterUnJoueur("Marie", "John", 2000, Langue.FRANCAIS);

        ArrayList<Joueur> liste = joueurService.recupererListeJoueurs();

        assertNotNull(liste);
        assertFalse(liste.isEmpty());
        assertEquals(1, liste.size());
    }

    // ❌ CAS KO : liste vide
    @Test
    public void recupererListeJoueurs_shouldThrow_WhenListeVide() {
        assertThrows(EmptyListException.class, () ->
                joueurService.recupererListeJoueurs()
        );
    }
}
