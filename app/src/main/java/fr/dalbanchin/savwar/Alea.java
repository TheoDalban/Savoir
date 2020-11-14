package fr.dalbanchin.savwar;

public class Alea {
    private int min,max;

    public Alea(int min,int max){
        this.min = min;
        this.max = max;
    }
    // nb_aleatoire entre
    public int nombreAleatoire() {
        int res;
        res = this.min + (int)(Math.random() * ((max - min) + 1));
        return res;
    }
}
