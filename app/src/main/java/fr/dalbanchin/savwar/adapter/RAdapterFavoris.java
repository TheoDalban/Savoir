package fr.dalbanchin.savwar.adapter;


import fr.dalbanchin.savwar.R;

import android.content.Context;
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


public class RAdapterFavoris extends RecyclerView.Adapter<RAdapterFavoris.ViewHolder> {

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
        public void onClick (View v) {
            int pos = getAdapterPosition();
            Toast.makeText(v.getContext(), msgList.get(pos), Toast.LENGTH_LONG).show();
        }
    }

    ArrayList<String> msgList;


    public RAdapterFavoris(Context c) {
        msgList = new ArrayList<String>();
        msgList.add("ça fonctionne bg");
        msgList.add("Il faut changer l'image.");
    }

    @Override
    public void onBindViewHolder(RAdapterFavoris.ViewHolder viewHolder, int i) {
        TextView textView = viewHolder.textView;
        textView.setText(msgList.get(i));
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

