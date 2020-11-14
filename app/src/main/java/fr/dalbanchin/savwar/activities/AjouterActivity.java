package fr.dalbanchin.savwar.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import fr.dalbanchin.savwar.R;
import fr.dalbanchin.savwar.adapter.RAdapterTheme;
import fr.dalbanchin.savwar.model.Savoir;
import fr.dalbanchin.savwar.storage.SavoirDatabaseStorage;
import fr.dalbanchin.savwar.storage.utility.BaseDeDonnee;

public class AjouterActivity extends AppCompatActivity {

    SavoirDatabaseStorage marvin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);

    }

    public void ajouter(View v){
        EditText themeE = (EditText)findViewById(R.id.theme);
        EditText lienE = (EditText)findViewById(R.id.lien);
        EditText infoE = (EditText)findViewById(R.id.info);

        String theme = themeE.getText().toString();
        String lien = lienE.getText().toString();
        String info = infoE.getText().toString();

        if (theme.equals("") || lien.equals("") || info.equals("")){
            Toast.makeText(this, "Tous les champs ne sont pas remplis.", Toast.LENGTH_LONG).show();

        }
        else
        {
            Date now = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
            String dateJ = formatter.format(now);

            marvin = marvin.get(getBaseContext());

            //Création d'un savoir
            Savoir savoir = new Savoir(info,theme,lien,0,dateJ);

            //Ajout du savoir dans la BDDSQLITE
            marvin.insert(savoir);
            savoir = new Savoir(info,theme,lien,0,dateJ);
            marvin.insert(savoir);

            System.out.println(marvin.findAll());
            Toast.makeText(this,savoir.toString(), Toast.LENGTH_LONG).show();
            Toast.makeText(this,"Le : " + savoir.getDate(), Toast.LENGTH_LONG).show();
            Toast.makeText(this, "Vous avez bien ajouté votre savoir.", Toast.LENGTH_LONG).show();
            finish();
        }
    }
}
