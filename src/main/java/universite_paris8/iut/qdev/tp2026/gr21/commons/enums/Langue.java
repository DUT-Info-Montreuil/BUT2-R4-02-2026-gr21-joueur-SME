package universite_paris8.iut.qdev.tp2026.gr21.commons.enums;

public enum Langue {

    // null car pas encore réflechi

    FRANCAIS("fr", "Français", 1),
    ANGLAIS("en", "English", 2),
    ALLEMAND("de", "Deutsch", 3),
    ESPAGNOL("es", "Español", 4),
    ITALIEN("it", "Italiano", 5);

    private String libelleCourt;
    private String libelleLong;
    private int identifiant;

    Langue(String libelleCourt, String libelleLong, int identifiant) {
        this.libelleCourt = libelleCourt;
        this.libelleLong = libelleLong;
        this.identifiant = identifiant;
    }
}
