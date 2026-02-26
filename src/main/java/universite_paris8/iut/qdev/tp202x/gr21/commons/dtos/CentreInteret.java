package universite_paris8.iut.qdev.tp202x.gr21.commons.dtos;

import java.util.Objects;

public class CentreInteret {

    private String nom;

    public CentreInteret(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CentreInteret that = (CentreInteret) o;
        return Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nom);
    }

    @Override
    public String toString() {
        return "CentreInteret{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
