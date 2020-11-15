package fr.dalbanchin.savwar.adapter;


import fr.dalbanchin.savwar.R;
import fr.dalbanchin.savwar.activities.SavoirDuJour;
import fr.dalbanchin.savwar.model.Savoir;
import fr.dalbanchin.savwar.storage.SavoirStorage;
import fr.dalbanchin.savwar.storage.utility.BaseDeDonnee;
import fr.dalbanchin.savwar.storage.SavoirDatabaseStorage;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class RAdapterFavoris extends RecyclerView.Adapter<RAdapterFavoris.ViewHolder> {
    private final Context context;
    SavoirDatabaseStorage marvin;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public LinearLayout row;

        public ImageView imageSavoir;
        public TextView textView;
        public ImageView iconPlus;

        public ViewHolder(View itemView) {
            super(itemView);

            row = (LinearLayout) itemView.findViewById(R.id.a_row_fav);
            imageSavoir = (ImageView) itemView.findViewById(R.id.image_savoir);
            textView = (TextView) itemView.findViewById(R.id.text_row_fav);
            iconPlus = (ImageView) itemView.findViewById(R.id.plusicon);
        }

        @Override
        public void onClick(View v) {

        }
    }

    List<Savoir> msgList;

    public RAdapterFavoris(Context c) {
        this.context = c;
        marvin = marvin.get(c);

        msgList = marvin.findAllFavoring();
    }

    @Override
    public void onBindViewHolder(RAdapterFavoris.ViewHolder viewHolder, int i) {
        final int changerPref;
        TextView textView = viewHolder.textView;
        textView.setText(msgList.get(i).getTitle());
        changerPref = msgList.get(i).getId();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SavoirStorage.setsettingsSavoirAfficheId(context,changerPref);
                Intent intentSavoir = new Intent(context,SavoirDuJour.class);
                context.startActivity(intentSavoir);
            }
        });
    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }


    @Override
    public RAdapterFavoris.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.row_favoris, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
}

