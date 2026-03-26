package universite_paris8.iut.qdev.tp2026.gr21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import universite_paris8.iut.qdev.tp2026.gr21.commons.dtos.Joueur;
import universite_paris8.iut.qdev.tp2026.gr21.commons.enums.Langue;
import universite_paris8.iut.qdev.tp2026.gr21.mock.*;
import universite_paris8.iut.qdev.tp2026.gr21.utils.exceptions.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    private JoueurOkImplMock joueurOkMock;
    private JoueurKoImplMock joueurKoMock;
    private JoueurKoPrenomImplMock joueurKoPrenomMock;
    private JoueurKoAnneeImplMock joueurKoAnneeMock;
    private JoueurKoLangueImplMock joueurKoLangueMock;

    @BeforeEach
    public void setUp() {
        joueurOkMock = new JoueurOkImplMock();
        joueurKoMock = new JoueurKoImplMock();
        joueurKoPrenomMock = new JoueurKoPrenomImplMock();
        joueurKoAnneeMock  = new JoueurKoAnneeImplMock();
        joueurKoLangueMock = new JoueurKoLangueImplMock();
    }

    // ✅ CAS OK : joueur ajouté avec succès
    @Test
    public void ajouterJoueur_shouldReturnJoueur_WhenToutValide()
            throws Exception {
        Joueur j1 = joueurOkMock.ajouterUnJoueur("John", "Marie", 2000, Langue.FRANCAIS);
        Joueur j2 = new Joueur("John", "Marie", 2000, Langue.FRANCAIS);

        assertEquals(j1, j2, "Les joueurs devraient être égaux");
    }

    // ✅ CAS OK : liste retournée après ajout
    @Test
    public void recupererListeJoueurs_shouldReturnListe_WhenNonVide()
            throws Exception {
        joueurOkMock.ajouterUnJoueur("John", "Marie", 2000, Langue.FRANCAIS);

        ArrayList<Joueur> liste = joueurOkMock.recupererListeJoueurs();

        assertNotNull(liste);
        assertFalse(liste.isEmpty());
    }

    // ❌ CAS KO : liste vide → EmptyListException
    @Test
    public void recupererListeJoueurs_shouldThrow_WhenListeVide() {
        assertThrows(EmptyListException.class, () ->
                joueurOkMock.recupererListeJoueurs()
        );
    }

    // ❌ CAS KO : pseudo pris → UsernameTakenException
    @Test
    public void ajouterJoueur_shouldThrow_WhenPseudoPris() {
        assertThrows(UsernameTakenException.class, () ->
                joueurKoMock.ajouterUnJoueur("John", "Marie", 2000, Langue.FRANCAIS)
        );
    }

    @Test
    public void ajouterJoueur_shouldThrow_WhenPrenomNonConforme() {
        assertThrows(NonCompliantFirstNameException.class, () ->
                joueurKoPrenomMock.ajouterUnJoueur("John", "M4rie!!", 2000, Langue.FRANCAIS)
        );
    }

    // ❌ CAS KO : année de naissance invalide
    @Test
    public void ajouterJoueur_shouldThrow_WhenAnneeInvalide() {
        assertThrows(InvalidBirthYearException.class, () ->
                joueurKoAnneeMock.ajouterUnJoueur("John", "Marie", 1800, Langue.FRANCAIS)
        );
    }

    // ❌ CAS KO : langue invalide
    @Test
    public void ajouterJoueur_shouldThrow_WhenLangueInvalide() {
        assertThrows(InvalidLanguageException.class, () ->
                joueurKoLangueMock.ajouterUnJoueur("John", "Marie", 2000, null)
        );
    }
}
