package universite_paris8.iut.qdev.tp202x.gr21.commons.dtos;

import universite_paris8.iut.qdev.tp202x.gr21.commons.enums.Langue;

import java.util.ArrayList;
import java.util.Objects;

public class Joueur {

    private String prenom, pseudo;
    private int anneeNaissance;
    private ArrayList<CentreInteret> centreInterets;
    private Langue languePreferee;
    private int score;

    public Joueur(String prenom, String pseudo, int anneeNaissance, Langue languePreferee) {
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.anneeNaissance = anneeNaissance;
        this.centreInterets = new ArrayList<>();
        this.languePreferee = languePreferee;
        this.score = 0;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public int getAnneeNaissance() {
        return anneeNaissance;
    }

    public ArrayList<CentreInteret> getCentreInterets() {
        return centreInterets;
    }

    public Langue getLanguePreferee() {
        return languePreferee;
    }

    public int getScore() {
        return score;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setAnneeNaissance(int anneeNaissance) {
        this.anneeNaissance = anneeNaissance;
    }

    public void setCentreInterets(ArrayList<CentreInteret> centreInterets) {
        this.centreInterets = centreInterets;
    }

    public void setLanguePreferee(Langue languePreferee) {
        this.languePreferee = languePreferee;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joueur joueur = (Joueur) o;
        return Objects.equals(pseudo, joueur.pseudo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(pseudo);
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "prenom='" + prenom + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", anneeNaissance=" + anneeNaissance +
                ", centreInterets=" + centreInterets +
                ", languePreferee=" + languePreferee +
                ", score=" + score +
                '}';
    }
}
