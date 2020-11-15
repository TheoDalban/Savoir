package fr.dalbanchin.savwar.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import fr.dalbanchin.savwar.R;
import fr.dalbanchin.savwar.adapter.RAdapterFavoris;
import fr.dalbanchin.savwar.adapter.RAdapterTheme;

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
    }
}
