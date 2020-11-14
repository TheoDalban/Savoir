package fr.dalbanchin.savwar.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import fr.dalbanchin.savwar.R;
import fr.dalbanchin.savwar.model.Savoir;
import fr.dalbanchin.savwar.storage.SavoirDatabaseStorage;
import fr.dalbanchin.savwar.storage.utility.BaseDeDonnee;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void login(View v){
        EditText username = (EditText)findViewById(R.id.username);
        EditText password = (EditText)findViewById(R.id.password);

        if (username.getText().toString().equals("") || password.getText().toString().equals("")){
            Toast.makeText(this, "Veuillez compléter tout les champs", Toast.LENGTH_LONG).show();
        }
        else if (username.getText().toString().equals("theo") && password.getText().toString().equals("dalban"))
        {
            Toast.makeText(this, "Bonjour Théo", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, AjouterActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(this, "Login ou mot de passe incorrect", Toast.LENGTH_LONG).show();
        }
    }
}