package fr.dalbanchin.savwar.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.sql.Date;
import java.text.SimpleDateFormat;

import fr.dalbanchin.savwar.R;
import fr.dalbanchin.savwar.model.Savoir;
import fr.dalbanchin.savwar.storage.SavoirDatabaseStorage;
import fr.dalbanchin.savwar.storage.SavoirStorage;


public class MainActivity extends AppCompatActivity {

    private static int REQUEST_IMAGE_CAPTURE = 1;

    private Button savoir;

    private Button theme;

    private Button favoris;

    private Button journuit;

    SavoirDatabaseStorage marvin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.savoir = (Button) findViewById(R.id.button_savoir);


        if (SavoirStorage.getsettingsBDD(getApplicationContext()) == 0) {

            SavoirStorage.ajouterBdd(getBaseContext());
            SavoirStorage.setsettingsBDD(getApplicationContext(),1);
        }


        savoir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                /*String info = " voici les informations que vous aimeriez connaitre ";
                String theme = " Astronaute ";
                String lien = "https://icom.univ-lyon2.fr/formation/master-1-informatique#admission";
                Integer favoring = 0;
                String date_sav = date_current;
                Savoir savoir = new Savoir(info,theme,lien,favoring,date_sav);*/

/*                try {
                    savoir_import = (Savoir) marvin.findDate();
                    marvin.update(date_current,savoir_import);
                }catch (SQLException e){
                    e.printStackTrace();
                    savoir_import = savoir;

                    //ArrayList<Savoir> listsavoir = (ArrayList<Savoir>) marvin.findAll();
                    //for(int i = 0; i < listsavoir.size(); i++) {
                     //   marvin.update(i, listsavoir.get(i)); // changer la façon de faire avec les id d'array list car c'est faux
                    //}
                }*/



                //marvin.update(date_current,savoir_import);

                //((ImageView) findViewById(R.id.image_savoir)).setImageDrawable(savoir_import.getTheme()+".png");
                SavoirStorage.SAVOIR_DU_JOUR_ID = -1;
                Intent savoirIntent = new Intent(getApplicationContext(), SavoirDuJour.class);
                startActivity(savoirIntent);
            }
        });
        this.theme = (Button) findViewById(R.id.button_theme);

        theme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent themeIntent = new Intent(getApplicationContext(), ThemeActivity.class);
                startActivity(themeIntent);
            }
        });
        this.favoris = (Button) findViewById(R.id.button_favoris);

        favoris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SavoirStorage.setsettingsSAVOIRTHEME(getApplicationContext(), 0 );
                Intent favorisIntent = new Intent(getApplicationContext(), FavorisActivity.class);
                startActivity(favorisIntent);
            }
        });
        this.journuit = (Button) findViewById(R.id.button_ajouter);


    }

    @SuppressLint("NewApi")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            if (data != null) {
                Bundle bundle = data.getExtras();
                if (bundle != null) {
                    ImageView image = findViewById(R.id.logo);
                    image.setImageBitmap((Bitmap) bundle.get("data"));
                    image.setImageTintList(new ColorStateList(new int[0][0], new int[0])); // Enlève le tint
                }
            }
        }
    }

}