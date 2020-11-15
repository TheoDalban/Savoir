package fr.dalbanchin.savwar.storage;

import android.content.Context;
import android.content.SharedPreferences;

public final class SavoirStorage {

    private static final String PREF_NAME = "fr.dalbanchin.savwar.preferences";
    private static final String PREF_SAVOIR_AFFICHE = "Savoir affiche";
    public static final int PREF_SAVOIR_JOUR = 0;
    private static final int PREF_SAVOIR_JOUR_DEFAULT = PREF_SAVOIR_JOUR;

    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }
    public static int getPreferencesSavoir(Context context) {
        return getPreferences(context).getInt(PREF_SAVOIR_AFFICHE, PREF_SAVOIR_JOUR_DEFAULT);
    }

    public static void setPreferencesSavoir(Context context, int pref_savoir) {
        getPreferences(context).edit().putInt(PREF_SAVOIR_AFFICHE, pref_savoir).apply();
    }
}
