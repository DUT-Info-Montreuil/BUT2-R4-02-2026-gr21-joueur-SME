package universite_paris8.iut.qdev.tp202x.gr21.commons.enums;

public enum Langue {

    // null car pas encore réflechi

    FRANCAIS("fr", "Francais", 1),
    ANGLAIS("en", "Anglais", 2),
    ALLEMAND("deu", "Allemand", 3),
    ESPAGNOL("es", "Espagnol", 4),
    ITALIEN("ita", "Italien", 5);

    private String libelleCourt;
    private String libelleLong;
    private int identifiant;

    Langue(String libelleCourt, String libelleLong, int identifiant) {
        this.libelleCourt = libelleCourt;
        this.libelleLong = libelleLong;
        this.identifiant = identifiant;
    }
}
