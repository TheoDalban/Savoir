package fr.dalbanchin.savwar.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import fr.dalbanchin.savwar.R;
import fr.dalbanchin.savwar.adapter.RAdapterTheme;

public class ThemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RView);
        RAdapterTheme radapter = new RAdapterTheme(this);
        recyclerView.setAdapter(radapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
