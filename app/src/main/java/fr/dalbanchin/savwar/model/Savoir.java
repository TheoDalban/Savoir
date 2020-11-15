package fr.dalbanchin.savwar.model;

public class Savoir {
    private static int ID = 1;

    private final int id;
    private final String info;
    private final String theme;
    private final String lien;
    private final int favoring;
    private final String date;
    private final String title;

    public Savoir(int id, String title,String info, String theme, String lien, int favoring, String date) {
        this.id = id;
        this.title = title;
        this.info = info;
        this.theme = theme;
        this.lien = lien;
        this.favoring = favoring;
        this.date = date;
    }

    public Savoir(String title,String info, String theme, String lien, int favoring, String date) {
        this(ID++,title, info, theme, lien, favoring, date);
    }


    public int getId() {
        return id;
    }

    public String getInfo() {
        return info;
    }

    public String getTitle() { return title; }

    public String getTheme() {
        return theme;
    }

    public String getLien() {
        return lien;
    }

    public int getFavoring() {
        return favoring;
    }

    public String getDate() {
        return date;
    }

    public static void setID(int ID) {
        Savoir.ID = ID;
    }


    @Override
    public String toString() {
        return "Savoir{" +
                "id=" + id +
                ", info='" + info + '\'' +
                ", theme='" + theme + '\'' +
                ", lien='" + lien + '\'' +
                ", favoring=" + favoring +
                ", date='" + date + '\'' +
                '}';
    }
}
