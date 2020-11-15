package fr.dalbanchin.savwar.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fr.dalbanchin.savwar.R;
import fr.dalbanchin.savwar.adapter.RAdapterFavoris;
import fr.dalbanchin.savwar.adapter.RAdapterTheme;
import fr.dalbanchin.savwar.storage.SavoirStorage;

public class FavorisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoris);

        ImageView back = findViewById(R.id.home);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RViewFav);
        RAdapterFavoris radapter = new RAdapterFavoris(this);
        recyclerView.setAdapter(radapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        TextView fav = findViewById(R.id.titre_favoris);
        int favoris_oui = SavoirStorage.getsettingsSAVOIRTHEME(getApplicationContext());
        String titre;
        switch(favoris_oui){
            case 0:
                titre = "Vos Favoris";
                break;
            case 1 :
                titre = "Les Animaux";
                break;
            case 2:
                titre = "La Cuisine";
                break;
            case 3:
                titre = "L'Espace";
                break;
            case 4:
                titre = "Géographie";
                break;
            case 5:
                titre = "Histoire";
                break;
            case 6:
                titre = "Humain";
                break;
            case 7:
                titre = "Nature";
                break;

            default:
                titre = "Les Savoirs";
                break;
        }

        fav.setText(titre);
    }
}
