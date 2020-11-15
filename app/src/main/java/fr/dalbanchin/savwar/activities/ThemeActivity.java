package fr.dalbanchin.savwar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import fr.dalbanchin.savwar.R;
import fr.dalbanchin.savwar.adapter.RAdapterTheme;
import fr.dalbanchin.savwar.storage.SavoirStorage;

public class ThemeActivity extends AppCompatActivity {

    private ImageView theme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        ImageView back = findViewById(R.id.home);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RView);
        RAdapterTheme radapter = new RAdapterTheme(this);
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
