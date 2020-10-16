package fr.dalbanchin.savwar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import fr.dalbanchin.savwar.adapter.RAdapter;

public class ThemeActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_theme);

            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RView);
            RAdapter radapter = new RAdapter(this);
            recyclerView.setAdapter(radapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
