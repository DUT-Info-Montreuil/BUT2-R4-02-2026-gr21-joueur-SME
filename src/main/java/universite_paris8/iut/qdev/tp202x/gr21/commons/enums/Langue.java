package universite_paris8.iut.qdev.tp202x.gr21.commons.enums;

public enum Langue {

    // null car pas encore réflechi

    FRANCAIS(null, null, 0),
    ANGLAIS(null, null, 0),
    ALLEMAND(null, null, 0),
    ESPAGNOL(null, null, 0),
    ITALIEN(null, null, 0);

    private String libelleCourt;
    private String libelleLong;
    private int identifiant;

    Langue(String libelleCourt, String libelleLong, int identifiant) {
        this.libelleCourt = libelleCourt;
        this.libelleLong = libelleLong;
        this.identifiant = identifiant;
    }
}
