package fr.dalbanchin.savwar.model;

import fr.dalbanchin.savwar.storage.utility.DbBitmapUtility;

public class Savoir {
    private static int ID = 1;

    private int id;
    private String info;
    private String image_data;
    private String theme;
    private String lien;
    private String favoring;
    private String date;

    public Savoir(int id, String info, String image_data, String theme, String lien, String favoring, String date) {
        this.id = id;
        this.info = info;
        this.image_data = image_data;
        this.theme = theme;
        this.lien = lien;
        this.favoring = favoring;
        this.date = date;
    }

    public Savoir(String info, String image_data, String theme, String lien, String favoring, String date) {
        this(ID++, info, image_data, theme, lien, favoring, date);
    }


    public int getId() {
        return id;
    }

    public String getInfo() {
        return info;
    }

    public String getImage_data() {
        return image_data;
    }

    // Il n'existe pas de theme enum en sql lite pq pas créer des constantes de thèmes dans ce fichier ?
    // TODO créer des valeurs par thèmes ?

    public String getTheme() {
        return theme;
    }

    public String getLien() {
        return lien;
    }

    public String getFavoring() {
        return favoring;
    }

    public String getDate() {
        return date;
    }
}
