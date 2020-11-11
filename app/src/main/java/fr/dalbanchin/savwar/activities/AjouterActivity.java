package fr.dalbanchin.savwar.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import fr.dalbanchin.savwar.R;
import fr.dalbanchin.savwar.adapter.RAdapterTheme;

public class AjouterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);

    }

    public void ajouter(View v){
        EditText theme = (EditText)findViewById(R.id.theme);
        EditText lien = (EditText)findViewById(R.id.lien);
        EditText info = (EditText)findViewById(R.id.info);

        if (theme.getText().toString().equals("") || lien.getText().toString().equals("") || info.getText().toString().equals("")){
            Toast.makeText(this, "Tous les champs ne sont pas remplis.", Toast.LENGTH_LONG).show();

        }
        else
        {

            Toast.makeText(this, "Vous avez bien ajouté votre savoir.", Toast.LENGTH_LONG).show();
            finish();
        }


    }
}
