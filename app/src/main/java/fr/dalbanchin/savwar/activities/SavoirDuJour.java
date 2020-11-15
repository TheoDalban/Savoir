package fr.dalbanchin.savwar.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

import java.net.CookieHandler;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import fr.dalbanchin.savwar.Alea;
import fr.dalbanchin.savwar.R;
import fr.dalbanchin.savwar.model.Savoir;
import fr.dalbanchin.savwar.storage.SavoirDatabaseStorage;
import fr.dalbanchin.savwar.storage.SavoirStorage;

public class SavoirDuJour extends AppCompatActivity {

    SavoirDatabaseStorage marvin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savoir_du_jour_activity);

        // on récupère la date actuelle
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date(System.currentTimeMillis());
        String date_current = formatter.format(date);

        marvin = marvin.get(getBaseContext());
        String dateMarvin;

        if (SavoirStorage.getsettingsSAVOIRID(getApplicationContext()) != -1) {
            dateMarvin = marvin.find(SavoirStorage.getsettingsSAVOIRID(getApplicationContext())).getDate();
        }else{
            dateMarvin = "nexiste pas";
        }
        if (SavoirStorage.getsettingsSAVOIRID(getApplicationContext()) == -1) {


            List<Savoir> savoir_import;
            savoir_import = marvin.findAllDate();

            //On prend un nb aleatoire pour choisir un savoir aléatoire n'étant pas encore passé dans savoir du jour
            Alea nb = new Alea(0, savoir_import.size() - 1);
            int nb_alea = nb.nombreAleatoire();


            Savoir savoir = savoir_import.get(nb_alea);

            marvin.updateDate(date_current, savoir.getId(), savoir);

            TextView lien = findViewById(R.id.en_savoir_plus);
            ((TextView) findViewById(R.id.info_savoir)).setText("" + savoir.getInfo() + "");

            SpannableString content = new SpannableString("En savoir plus");
            content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
            lien.setText(content);

            final Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(savoir.getLien()));
            lien.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(intent);
                }
            });

            SavoirStorage.setsettingsSAVOIRID(getApplicationContext(),savoir.getId());
        }

        else if (!dateMarvin.contains(date_current))  {
            System.out.println(date_current);
            System.out.println(dateMarvin);
            List<Savoir> savoir_import;
            savoir_import = marvin.findAllDate();

            //On prend un nb aleatoire pour choisir un savoir aléatoire n'étant pas encore passé dans savoir du jour
            Alea nb = new Alea(0, savoir_import.size() - 1);
            int nb_alea = nb.nombreAleatoire();


            Savoir savoir = savoir_import.get(nb_alea);

            marvin.updateDate(date_current, savoir.getId(), savoir);

            TextView lien = findViewById(R.id.en_savoir_plus);
            ((TextView) findViewById(R.id.info_savoir)).setText("" + savoir.getInfo() + "");

            SpannableString content = new SpannableString("En savoir plus");
            content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
            lien.setText(content);

            final Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(savoir.getLien()));
            lien.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(intent);
                }
            });

            SavoirStorage.setsettingsSAVOIRID(getApplicationContext(),savoir.getId());
        }

        else {

            Savoir savoir = marvin.find(SavoirStorage.getsettingsSAVOIRID(getApplicationContext()));

            TextView lien = findViewById(R.id.en_savoir_plus);
            ((TextView) findViewById(R.id.info_savoir)).setText("" + savoir.getInfo() + "");

            SpannableString content = new SpannableString("En savoir plus");
            content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
            lien.setText(content);

            final Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(savoir.getLien()));
            lien.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(intent);
                }
            });

            SavoirStorage.setsettingsSAVOIRID(getApplicationContext(),savoir.getId());

        }



    //    if (SavoirStorage.getPreferencesSavoir(getApplicationContext()) == 0) {




           // SavoirStorage.setPreferencesSavoir(getApplicationContext(),0);

    }
}